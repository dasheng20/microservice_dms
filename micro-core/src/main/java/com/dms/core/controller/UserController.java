package com.dms.core.controller;

import com.dms.bean.UserInfoDTO;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/core")
public class UserController {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/userOne")
    public Mono<UserInfoDTO> userOne(){
        Mono<UserInfoDTO> users = webClientBuilder.
                build()
                .get()
                .uri("http://user/user/user/one?name=test")
                .retrieve()
                .bodyToMono(UserInfoDTO.class);
        return users;
    }

    @GetMapping("/userList")
    public List<UserInfoDTO> userList(){
        List<UserInfoDTO> users = Lists.newArrayList();
        for (String uri : RegistryRequestList.registryRequestList) {
            List<UserInfoDTO> userList = webClientBuilder.
                    build()
                    .get()
                    .uri(uri)
                    .retrieve()
                    .bodyToFlux(UserInfoDTO.class).collectList().block();
            if (!CollectionUtils.isEmpty(userList)){
                users.addAll(userList);
            }
        }
        return users;
    }
}
