package com.srm.user.model.payload;


import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotNull;

@Data
public class CreateUserPayload {
    @NotNull(message = "User name cannot be empty")
    private String name;
    @NotNull(message = "User phone cannot be empty")
    private String phone;
    @NotNull(message = "User email cannot be empty")
    private String email;
    @NotNull(message = "User password cannot be empty")
    private String password;

    private String address;
}
