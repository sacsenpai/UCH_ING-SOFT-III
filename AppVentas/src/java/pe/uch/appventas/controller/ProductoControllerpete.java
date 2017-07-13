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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pe.uch.appventas.model.Producto;
import pe.uch.appventas.service.ProductoServicepete;


public class ProductoControllerpete {
    
    private ProductoServicepete productoService;
    
//    @RequestMapping(value="/crudProductoConsultar.htm",method=RequestMethod.GET)
    public String crudProductoConsultar(
                @RequestParam("criterioproducto") String criterio,
                Model model){
        String destino;
        model.addAttribute("activoproducto", "active");
        
        destino="crudProductosLista";
        List<Map<String, Object>> lista=productoService.getProducto(criterio);
        model.addAttribute("lista",lista);
        
        return destino;
        
    }
    
//    @RequestMapping(value="/crudProductoNuevo.htm",method = RequestMethod.GET)
    public String crudProductoNuevo(Model model){
        
        Producto bean=new Producto();
        
        model.addAttribute("activo", "active");
        
        return "crudProductosEditar";
    }
}
