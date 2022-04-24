package com.zking.killgoods.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/input")
public class InputController {


    @RequestMapping("/{path}")
    public String goPage(@PathVariable String path){
        return path;
    }

    @RequestMapping("/{dir}/{path}")
    public String toDirPage(@PathVariable("dir") String dir,@PathVariable("path") String path){
        System.out.println(dir + "/" + path);
        return "/"+dir+"/"+path;
    }

}
