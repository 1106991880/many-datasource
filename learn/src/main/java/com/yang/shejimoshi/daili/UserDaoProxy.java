package com.yang.shejimoshi.daili;

/**
 * @Author: yang
 * @Date: 2020-03-17 21:58
 * @Description:
 */
public class UserDaoProxy implements UserDao {

    private UserDao userDao;

    public UserDaoProxy(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add() {
        System.out.println("开始");
        userDao.add();
        System.out.println("结束");
    }
}
