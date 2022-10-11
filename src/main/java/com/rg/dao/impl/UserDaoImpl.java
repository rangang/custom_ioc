package com.rg.dao.impl;

import com.rg.dao.UserDao;

/**
 * @BelongsProject: custom_ioc
 * @Author: RG
 * @CreateTime: 2022/10/10 5:07 下午
 * @Description:
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("保存成功了。。。");
    }
}
