/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package mx.edu.uteq.evaluacion1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author Jesus7
 */
@Controller
public class CreateController {
    
    @RequestMapping("/create")
    public String page(Model model) {
        return "/views/create";
    }
    
    @ExceptionHandler({Exception.class})
    public String databaseError() {
        return "/helpers/error";
    }
    
}
