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
import pe.uch.appventas.model.Categoria;
import pe.uch.appventas.model.Empleado;
import pe.uch.appventas.model.Permiso;

@Service
public class LoginService extends AbstractJdbcSupport {

    private static final String CONSULTA_VENTAS = "select "
            + "e.idemp      idemp,"
            + "e.nombre     nombre,"
            + "e.apellido   apellido,"
            + "e.email      email,"
            + "e.telefono   telefono,"
            + "e.dni        dni,"
            + "e.direccion  direccion,"
            + "e.estado     estado "
            + "from empleado e ";

    //mismo metodo realizado con Map<String, Object>
    /*public Map<String, Object> validar(String usuario, String clave) {
        Map<String, Object> datos = null;
        try {
            String sql = "select "
                    + "e.idemp          ,"
                    + "e.nombre         ,"
                    + "e.apellido	,"
                    + "e.email          ,"
                    + "e.telefono	,"
                    + "e.dni		,"
                    + "e.direccion	,"
                    + "e.estado "
                    + "from empleado e "
                    + "inner join usuario u on u.idemp=e.idemp "
                    + "where u.usuario like ? and u.clave like sha(?);";
            datos = jdbcTemplate.queryForMap(sql, usuario, clave);
        } catch (EmptyResultDataAccessException e) {
        }
        return datos;
    }*/
    public Empleado validar(String usuario, String clave) {
        Empleado bean = null;

        try {
            String sql = CONSULTA_VENTAS
                    + "inner join usuario u on u.idemp=e.idemp "
                    + "where u.usuario = ? and u.clave = sha(?) and e.estado=1";
            bean = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Empleado>(Empleado.class), usuario, clave);
        } catch (EmptyResultDataAccessException e) {

        }

        return bean;
    }

    public Permiso permiso(int codigo) {
        Permiso bean = null;
        try {
            String sql = "select idrol, idemp, estado from permiso where estado=1 and idemp=?";
            bean = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Permiso>(Permiso.class), codigo);
        } catch (EmptyResultDataAccessException e) {
        }
        return bean;
    }
    
    public List<Map<String,Object>> categoria(){
     List<Map<String,Object>> bean=null;
        try {
            String sql="select idcat,"
                    + "nombre,"
                    + "descripcion from categoria";
            bean=jdbcTemplate.queryForList(sql);
        } catch (EmptyResultDataAccessException e) {
        }
        return bean;
    }
}
