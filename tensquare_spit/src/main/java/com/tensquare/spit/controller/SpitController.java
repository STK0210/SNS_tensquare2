package com.tensquare.spit.controller;

import com.tensquare.spit.service.SpitService;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @auther likeyu
 * @create 2019-09-03-22:44
 **/
@Controller
@CrossOrigin
@RequestMapping("/spit")
public class SpitController {

    @Autowired
    private SpitService spitService;

    public Result findAll() {
        return null;
    }


}
