package com.dms.order.controller;

import com.dms.bean.UserInfoDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class OrderUserController {

    @GetMapping("/list")
    public List<UserInfoDTO> list(@RequestParam("name") String name) {
        name = name + "order";
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
}
