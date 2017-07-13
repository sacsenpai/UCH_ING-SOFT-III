package pe.uch.appventas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.uch.appventas.service.AppService;

@Controller
public class AppController {

    @Autowired
    private AppService appService;
    
    @RequestMapping(value = "/index.htm", method = RequestMethod.GET)
    public String home() {
        return "index";
    }
    @RequestMapping(value="/mainadmin.htm",method = RequestMethod.GET)
    public String llenaCategoria(Model model){
        model.addAttribute("bean", appService.getCategoria());
        return "mainadmin";
    }

}
