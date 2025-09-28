package com.management.task.model.request;

import com.management.task.model.enums.Role;
import com.management.task.model.enums.UserStatus;

public record UserRequestRecord(

        String username,
        String password,
        Role role,
        UserStatus userStatus

) {
}
