
package mx.edu.uteq.evaluacion1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class AUPhotosController {
    
    @RequestMapping("/photosAUNormal")
    public String page(Model model) {
        //model.addAttribute("attribute", "value");
        return "/views/photosAU";
    }
    
    @ExceptionHandler({Exception.class})
    public String databaseError() {
        return "/error";
    }
    
}
