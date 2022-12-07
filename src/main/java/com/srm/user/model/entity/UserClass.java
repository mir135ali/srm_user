package com.srm.user.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name="user_table")
@NoArgsConstructor
@AllArgsConstructor
public class UserClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String phoneNumber;

    @Column
    private String address;
}
