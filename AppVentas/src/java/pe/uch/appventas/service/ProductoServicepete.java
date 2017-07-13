package pe.uch.appventas.service;

import java.util.List;
import java.util.Map;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pe.uch.appventas.model.Producto;


public class ProductoServicepete extends AbstractJdbcSupport {

    private final String SQL_SELECT = "select "
            + "	p.idprod idprod,"
            + "	p.idcat idcat,"
            + "	p.nombre nombre,"
            + "	p.descripcion descripcion,"
            + "	p.precio precio,"
            + "	p.stock stock,"
            + "	p.estado estado "
            + "	from producto p ";
    
    
    public Producto read(String codigo){
        Producto bean=null;
        try {
            String sql= SQL_SELECT
                    +"where idprod = ?";
            bean= jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Producto>(Producto.class),codigo);
        } catch (EmptyResultDataAccessException e) {
        }
        return bean;
    }

    /**
     * consulta el producto y su categoria por criterio.
     *
     * @param criterio
     * @return
     */
    public List<Map<String, Object>> getProducto(String criterio) {
        List<Map<String, Object>> lista = null;
        try {
            String sql = "select "
                    + " p.idprod idprod"
                    + "	c.nombre categoria,"
                    + "	p.nombre,"
                    + "	p.descripcion,"
                    + "	p.precio,"
                    + "	p.stock,"
                    + "	if(p.estado=1,'prah','anulado') estado "
                    + "	from producto p "
                    + "	inner join categoria c on p.idcat=c.idcat"
                    + " where c.nombre like  concat('%',?,'%') or p.nombre like  concat('%',?,'%') ";
            lista = jdbcTemplate.queryForList(sql, criterio, criterio);
        } catch (EmptyResultDataAccessException e) {
        }
        return lista;
    }
    public List<Producto> getProducto(Producto bean){
        List<Producto> lista=null;
        try {
            String sql="select "
                    + "idprod,"
                    + "idcat,"
                    + "nombre,"
                    + "descripcion,"
                    + "precio,"
                    + "stock,"
                    + "estado from producto "
                    + "where nombre= concat('%',?,'%') or idcat= concat('%',?,'%')";
            lista = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Producto>(Producto.class), bean.getNombre());
        } catch (EmptyResultDataAccessException e) {
        }
        return lista;
    }

    /**
     *
     * @param p
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void crearProducto(Producto bean) {
        /*
        leer el codigo del producto
        */
        String sql = "select idprod from producto for update ";
        Map<String, Object> datos;
        datos = jdbcTemplate.queryForMap(sql);
        int cont = Integer.parseInt(datos.get("idprod").toString());
        
        /*
        crea el codigo
        */
        cont ++;
        String idprod=String.format(""+cont);
        
        /*
        inserta producto
        */
        sql = "insert into producto(idprod,idcat,nombre,descripcion,precio,stock,estado)\n"
                + "	values (?,?,?,?,?,?,?)";
        Object[] args = new Object[]{idprod, bean.getIdcat(), bean.getNombre(), bean.getDescripcion(), bean.getPrecio(), bean.getStock(), bean.getEstado()};
        jdbcTemplate.update(sql, args);
        
        bean.setIdprod(cont);
    }

}
