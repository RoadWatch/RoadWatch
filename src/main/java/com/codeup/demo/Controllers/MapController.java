package com.codeup.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapController {

    public MapController() {
    }

    @GetMapping("/map")
    public String showMapPage(Model model){
        return "map/index";
    }
//    comment

}
