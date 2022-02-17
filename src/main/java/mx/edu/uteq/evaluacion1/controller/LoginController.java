
package mx.edu.uteq.evaluacion1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;


@Controller
public class LoginController {
    
    @RequestMapping("/login")
    public String page(Model model) {
        return "/views/login";
    }
    
    @ExceptionHandler({Exception.class})
    public String databaseError() {
        return "/error";
    }
    
}
