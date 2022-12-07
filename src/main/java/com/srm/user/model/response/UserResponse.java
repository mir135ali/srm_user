package com.srm.user.model.response;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;
import org.springframework.web.bind.annotation.ResponseBody;

@Data
@ResponseBody
public class UserResponse {
    private Integer userId;
    private String name;
    private String email;
    private String phone;
    private String address;
}
