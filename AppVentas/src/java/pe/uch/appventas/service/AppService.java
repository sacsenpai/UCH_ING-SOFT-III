/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.uch.appventas.service;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pe.uch.appventas.model.Categoria;
import pe.uch.appventas.model.Producto;

@Service
public class AppService extends AbstractJdbcSupport{
    public Categoria getCategoria(){
        Categoria bean=null;
        try {
            
        String sql="select idcat,nombre from categoria";
        bean=jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Categoria>(Categoria.class));
        } catch (EmptyResultDataAccessException e) {
        }
        return bean;
    }
    
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public void crearProducto(Producto bean){
        
        //leer categoria
        Categoria cat=getCategoria();
        //insertar producto
        String sql="insert into producto("
                + "idcat,"
                + "nombre,"
                + "descripcion,"
                + "precio,"
                + "stock) values(?,?,?,?,?) ";
        
        Object[] args=new Object[]{
            bean.getIdcat(),bean.getNombre(),bean.getDescripcion(),bean.getPrecio()
        };
        jdbcTemplate.update(sql,args);
    }
    
    
}
