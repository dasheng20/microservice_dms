package com.dms.user.port.adapter.controller;

import com.dms.bean.UserInfoDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/list")
    public List<UserInfoDTO> list(@RequestParam("name") String name) {
        name = name + "user";
        List<UserInfoDTO> list = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            UserInfoDTO userInfoDTO = new UserInfoDTO();
            userInfoDTO.setUserId(name + i);
            userInfoDTO.setUserName(name+ i);
            userInfoDTO.setUserPassword(name + i);
            userInfoDTO.setUserEmail(name + i);
            userInfoDTO.setUserPhone(name + i);
            userInfoDTO.setUserAddress(name + i);
            list.add(userInfoDTO);
        }
        return list;
    }

    @GetMapping("/one")
    public UserInfoDTO one(@RequestParam("name") String name) {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setUserId("1111");
        userInfoDTO.setUserName(name);
        userInfoDTO.setUserPassword("1111");
        userInfoDTO.setUserEmail("1111@qq.com");
        userInfoDTO.setUserPhone("222");
        userInfoDTO.setUserAddress("333");
        return userInfoDTO;
    }
}
