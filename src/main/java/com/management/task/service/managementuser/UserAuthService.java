package com.management.task.service.managementuser;

import com.management.task.model.app.SimpleMap;
import com.management.task.model.request.UserRequestRecord;

public interface UserAuthService {

    void register(UserRequestRecord request);

    SimpleMap login(UserRequestRecord request);

}
