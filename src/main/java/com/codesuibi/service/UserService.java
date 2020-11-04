package com.codesuibi.service;

import com.codesuibi.entity.User;
import org.springframework.transaction.annotation.Transactional;


public interface UserService {
    void register(User user);
}
