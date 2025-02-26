package com.dms.user.port.adapter.controller;

import com.dms.user.mq.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/mq")
public class MqController {

    @Autowired
    private MessageSender messageSender;

    @GetMapping("/send")
    private void sendMessage(@RequestParam("msg") String message) {
        messageSender.send(message);
    }
}
