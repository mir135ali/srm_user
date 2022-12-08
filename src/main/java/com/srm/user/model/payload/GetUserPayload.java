package com.srm.user.model.payload;


import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class GetUserPayload {

    @NotNull(message = "Please enter email")
    private String email;

    @NotNull(message = "Please enter password")
    private String password;
}
