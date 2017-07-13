/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.uch.appventas.service;

import java.util.List;
import java.util.Map;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;
import pe.uch.appventas.model.Producto;

@Service
public class ProductoService extends AbstractJdbcSupport {

    private final String SQL_SELECT = "select "
            + "idprod,"
            + "idcat,"
            + "nombre,"
            + "descripcion,"
            + "precio,"
            + "stock "
            + " from producto";

    /**
     * consulta por nombre de producto
     *
     * @param criterio
     * @return
     */
    public List<Map<String, Object>> getProductos(String codigo,String nombre) {
        List<Map<String, Object>> lista = null;

        try {
            String sql = "select "
                    + "p.idprod,"
                    + "c.nombre categoria,"
                    + "p.nombre nombre,"
                    + "p.descripcion descripcion,"
                    + "p.precio precio,"
                    + "p.stock stock,"
                    + "if(p.estado,'vigente','anulado') estado "
                    + " from producto p"
                    + " inner join categoria c on p.idcat = c.idcat "
                    + " where  c.idcat = ?";
            
            System.out.println("sql:"+sql);
            lista = jdbcTemplate.queryForList(sql,codigo);
        } catch (EmptyResultDataAccessException e) {
        }
        return lista;
    }
    public Producto getProducto(String idprod){
        Producto bean=null;
        try {
            String sql=SQL_SELECT+" where idprod=?";
            bean=jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Producto>(Producto.class), idprod);
        } catch (EmptyResultDataAccessException e) {
        }
        return bean;
    }
/**
 * edita la tabla producto por su id
 * @param bean
 * @param idprod 
 */
    public void editarProducto(Producto bean, String idprod ) {
        try {
            String sql = "update producto "
                    + "set idcat=?,"
                    + "nombre=?,"
                    + "descripcion=?,"
                    + "precio=?,"
                    + "stock=? "
                    + "where idprod=?";
            jdbcTemplate.update(sql, bean.getIdcat(),bean.getNombre(),bean.getDescripcion(),bean.getPrecio(),bean.getStock(),idprod);
        } catch (EmptyResultDataAccessException e) {
        }
        
    }
}
