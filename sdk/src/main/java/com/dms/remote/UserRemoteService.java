package com.dms.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "core",path = "/core",contextId = "userRemoteService",qualifiers = {"userRemoteService"})
public interface UserRemoteService {

    @GetMapping("/user/postRequest")
    void postRequest(@RequestParam("uri") String uri);
}
