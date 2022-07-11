package com.chufan.nove.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chufan.nove.messaging.LoginMessage;
import com.chufan.nove.messaging.RegistrationMessage;
import com.chufan.nove.service.MessagingService;

@Controller
public class UserController {
    final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    MessagingService messagingService;

    @ResponseBody
    @RequestMapping("/")
    public String index(HttpSession session) {
        logger.info("in loging----");
        // Map<String, Object> model = new HashMap<>();
        // model.put("user", model);
        messagingService.sendRegistrationMessage(RegistrationMessage.of("m@find73.com", "Tony"));
        return "In Root html";
        // return new ModelAndView("index.html", model);
    }

    @ResponseBody
    @RequestMapping("/fail")
    public String fail(HttpSession session, @RequestParam(name = "success", defaultValue = "false") String success) {
        logger.info("in fail----:" + session.getId());
        // Map<String, Object> model = new HashMap<>();
        // model.put("user", model);
        boolean flag = false;
        if (Boolean.parseBoolean(success))
            flag = true;
        messagingService.sendLoginMessage(LoginMessage.of("mm@gg.com", "tim", flag));
        return "in fail process";
        // return new ModelAndView("index.html", model);
    }
}
