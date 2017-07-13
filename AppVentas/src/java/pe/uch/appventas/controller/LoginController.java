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
import pe.uch.appventas.model.Categoria;
import pe.uch.appventas.model.Empleado;
import pe.uch.appventas.model.Permiso;
import pe.uch.appventas.service.LoginService;

@Controller
public class LoginController {

    @Autowired
    private LoginService lService;

    @RequestMapping(value = "/login.htm", method = RequestMethod.POST)
    public String login(
            @RequestParam("usuario") String usuario,
            @RequestParam("clave") String clave,
            Model model) {

        String destino = "";
        Empleado bean = null;
        Permiso permiso = null;
        List<Map<String,Object>> categoria = null;
        try {
            bean = lService.validar(usuario, clave);
            permiso = lService.permiso(bean.getIdemp());
            categoria = lService.categoria();
            model.addAttribute("categoria", categoria);
            model.addAttribute("bean", bean);
            System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSAFSADGFAHSJGKJHGFDSGDHFJKJFDJSHGGHJKGFH     " + permiso.getIdrol() + "   " + bean.getNombre());
            if (bean == null) {

                throw new Exception("datos incorrectos.");
            } else if (permiso.getIdrol() == 1) {

                destino = "mainadmin";
            } else if (permiso.getIdrol() == 2) {
                destino = "mainvendedor";
            } else if (permiso.getIdrol() == 3) {
                destino = "mainoperador";
            } else if (permiso.getIdrol() == 4) {
                destino = "mainusuario";
            }

        } catch (Exception e) {

            destino = "index";
            model.addAttribute("error", e.getMessage());
        }
        return destino;

    }
}
