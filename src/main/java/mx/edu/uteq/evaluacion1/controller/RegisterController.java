
package mx.edu.uteq.evaluacion1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class RegisterController {
    
    @RequestMapping("/register")
    public String page(Model model) {
        //model.addAttribute("attribute", "value");
        return "/views/register";
    }
    
    @ExceptionHandler({Exception.class})
    public String databaseError() {
        return "/helpers/error";
    }
    
}
