package com.rg.service.impl;

import com.rg.dao.UserDao;
import com.rg.service.UserService;
import com.rg.utils.BeanFactory;

/**
 * @BelongsProject: custom_ioc
 * @Author: RG
 * @CreateTime: 2022/10/10 5:08 下午
 * @Description:
 */
public class UserServiceImpl implements UserService {

    @Override
    public void save() {
        UserDao userDao = (UserDao) BeanFactory.getBean("userDao");
        userDao.save();
    }
}
