package com.srm.user.controller;

import com.srm.user.model.entity.UserClass;
import com.srm.user.model.payload.CreateUserPayload;
import com.srm.user.model.payload.GetUserPayload;
import com.srm.user.model.payload.UpdateUserPayload;
import com.srm.user.model.response.UserResponse;
import com.srm.user.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController()
@RequestMapping(value = "/user")
public class controllerClass {

    @Autowired
    LoginService loginService;

    @GetMapping(value = "/get")
    public UserResponse getUser(@RequestBody @Valid GetUserPayload request) throws Exception{

        return  loginService.getUser(request);
    }


    @PostMapping(value = "/create")
    public UserResponse createUser( @Valid @RequestBody CreateUserPayload request) throws Exception {
        return loginService.createUser(request);
    }

    @PutMapping(value = "/update")
    public UserResponse updateUser(@RequestBody UpdateUserPayload req) throws Exception {
        return loginService.updateUser(req);
    }
}
