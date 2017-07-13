/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.uch.appventas.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pe.uch.appventas.model.Producto;
import pe.uch.appventas.service.ProductoService;

@Controller
public class ProductoController {

    @Autowired
    private ProductoService Pservice;

    @RequestMapping(value = "/crudProductoConsultar.htm", method = RequestMethod.GET)
    public String consultarProducto(
            @RequestParam("codigo") String codigo,
            @RequestParam("nombre") String nombre,
            Model model) {
        List<Map<String, Object>> bean = Pservice.getProductos(codigo,nombre);
        model.addAttribute("listaP", bean);

        return "crudProductosLista";
    }

    @RequestMapping(value = "/crudProductoNuevo.htm", method = RequestMethod.GET)
    public String crudProductoNuevo(Model model) {

        Producto bean = new Producto();

        model.addAttribute("activo", "active");

        return "crudProductosEditar";
    }

    @RequestMapping(value = "/crudProductosEditar.htm", method = RequestMethod.GET)
    public String crudProductoEditar(
            @RequestParam("idprod") String idprod,
            Model model) {
        String destino = "";
        Producto bean = null;
        try {
            bean = Pservice.getProducto(idprod);
            model.addAttribute("accion", "EDITAR");
            model.addAttribute("beanP", bean);
            destino = "crudProductosEditar";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            destino = "mainadmin";
        }
        return destino;
    }

    @RequestMapping(value = "/crudProductosEliminar.htm", method = RequestMethod.GET)
    public String crudProductoEliminar(
            @RequestParam("idprod") String idprod,
            Model model) {
        String destino = "";
        Producto bean = null;
        try {
            bean = Pservice.getProducto(idprod);
            model.addAttribute("accion", "ELIMINAR");
            model.addAttribute("beanP", bean);
            model.addAttribute("disabled", "disabled");
            destino = "crudProductosEditar";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            destino = "mainadmin";
        }
        return destino;
    }
}
