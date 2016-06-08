package com.igumnov.assignment2.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping("/")
    public String home() {

        return "index";
    }

    @RequestMapping("/ng-templates/{resource}")
    public String angularHtmlTemplate(@PathVariable("resource") String resource) {

        return "ng-templates/" + resource;
    }

}
