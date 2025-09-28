package com.management.task.model.enums;


import lombok.Getter;

@Getter
public enum Role {

    ADMIN("Admin"),
    MEMBER("Member");

    private final String label;

    Role(String label){this.label=label;}

}
