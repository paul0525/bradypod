package com.bradypod.contorller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author paul
 *
 */

@Controller
@RequestMapping("login")
public class LoginContorller {

    
    private static Logger log = LoggerFactory.getLogger( LoginContorller.class);

    @RequestMapping("loginview")
    public ModelAndView viewLogin( HttpServletRequest request){
        log.info("................hello login...........");
        return new ModelAndView("login/loginview");
    }
    
    
}
