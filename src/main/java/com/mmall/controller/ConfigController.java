package com.mmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Auth wangfan
 */
@Controller
@RequestMapping("/config")
public class ConfigController {

    @RequestMapping("config.page")
    public ModelAndView page() {
        return new ModelAndView("config");
    }
}
