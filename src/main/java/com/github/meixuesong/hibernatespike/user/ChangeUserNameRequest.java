package com.github.meixuesong.hibernatespike.user;

import lombok.Value;

@Value
public class ChangeUserNameRequest {
    private String id;
    private String name;

    public ChangeUserNameRequest(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
