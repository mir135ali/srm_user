package com.srm.user.controller;

import com.srm.user.model.entity.UserClass;
import com.srm.user.model.payload.CreateUserPayload;
import com.srm.user.model.response.UserResponse;
import com.srm.user.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(value = "/user")
public class controllerClass {

    @Autowired
    LoginService loginService;

    @GetMapping(value = "/get")
    public UserClass getMapping(@RequestBody UserClass userReq){

        return  loginService.getUser(userReq);
    }

    @PostMapping(value = "/update")
    public String updateUser(@RequestBody UserClass userRequest) {
         return loginService.updateUser(userRequest);
    }

//    @PutMapping(value = "/update")
//    public UserClass update(@RequestBody UpdateUser userReq) throws UserException {
//        return loginService.updateUser(userReq);
//    }

    @PostMapping(value = "/create")
    public UserResponse createUser(@RequestBody @Validated CreateUserPayload request) throws Exception {
        return loginService.createUser(request);
    }
}
