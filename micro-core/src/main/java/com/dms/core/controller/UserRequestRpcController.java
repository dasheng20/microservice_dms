package com.dms.core.controller;

import com.dms.remote.UserRemoteService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRequestRpcController implements UserRemoteService {
    @Override
    public void postRequest(String uri) {
        RegistryRequestList.registryRequestList.add(uri);
    }
}
