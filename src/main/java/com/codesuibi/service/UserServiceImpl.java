package com.codesuibi.service;

import com.codesuibi.dao.UserDAO;
import com.codesuibi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public void register(User user) {
        user.setRegtime(new Date());

        userDAO.save(user);
    }
}
