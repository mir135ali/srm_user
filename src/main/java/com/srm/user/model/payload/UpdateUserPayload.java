package com.srm.user.model.payload;


import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateUserPayload {

    @NotNull(message = "email can't be changed")
    private String email;
    private String name;

    private String phone;

    private String password;

    private String address;
}
