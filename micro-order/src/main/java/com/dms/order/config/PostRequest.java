package com.dms.order.config;

import com.dms.remote.UserRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class PostRequest {

    @Autowired
    private UserRemoteService userRemoteService;

    @PostConstruct
    public void post(){
        userRemoteService.postRequest("http://order/user/list?name='order'");
    }
}
