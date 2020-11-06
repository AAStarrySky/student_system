package com.codesuibi.service;

import com.codesuibi.dao.UserDAO;
import com.codesuibi.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDao;

    @Override
    public void register(User user) {

        User userFindByName = userDao.findByName(user.getName());
        if(userFindByName != null){
            throw new RuntimeException("该用户已被注册");
        }
        user.setRegtime(new Date());
        user.setStatus("激活");
        userDao.save(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User login(User user) {
        User userFindByName = userDao.findByName(user.getName());
        if(userFindByName != null){
            if(StringUtils.equals(user.getPassword(),userFindByName.getPassword())) {
                return userFindByName;
            }
        }

        throw new RuntimeException("用户名或者密码输入错误");
    }

}

