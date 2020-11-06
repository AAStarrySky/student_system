package com.codesuibi.service;

import com.codesuibi.entity.User;

public interface UserService {
    void register(User user);

    User login(User user);
}
