package com.dms.bean;

import lombok.Data;

@Data
public class UserInfoDTO {
    private String userId;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userPhone;
    private String userAddress;
}
