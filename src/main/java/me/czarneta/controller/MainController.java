package me.czarneta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Dawid on 11.04.2017.
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String getMainPage() {
        return "main";
    }

    @RequestMapping("/{name}")
    public String getMainPageWithName(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "main";
    }


}