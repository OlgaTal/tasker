package com.chyld.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/tasks"})
public class TasksController {

    @RequestMapping(path = {"", "/"}, method = RequestMethod.GET)
    public void index(){

    }
}
