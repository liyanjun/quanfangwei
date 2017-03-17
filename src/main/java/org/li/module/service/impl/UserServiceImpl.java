
package org.li.module.service.impl;

import org.li.common.base.page.PageInfo;
import org.li.common.base.page.PagerControl;
import org.li.module.bean.User;
import org.li.module.dao.UserDao;
import org.li.module.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liyanjun
 * @date 2017-3-14 15:49:48
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public Integer insertUser(User user) {
        if (user == null) {
            return 0;
        }

        Integer i = userDao.insert(user);
        return i;
    }

    public Integer updateUser(User user) {
        if (user == null) {
            return 0;
        }

        Integer i = userDao.update(user);
        return i;
    }

    public PagerControl<User> page(User user, PageInfo pageInfo, String whereSql, String orderSql) {
        return userDao.getPagerByObj(user, pageInfo, whereSql, orderSql);
    }

    public User find(Integer id) {
        return userDao.getEntityById(id);
    }

    public Integer delete(Integer id) {
        User temp = new User();
        temp.setId(id);
        return userDao.update(temp);
    }

    public Integer delete(Integer id, Integer updateId) {
        User temp = new User();
        temp.setId(id);
        return userDao.update(temp);
    }

    @Override
    public User findByUserName(String userName) {
        User user = new User();
        user.setName(userName);
        return userDao.getEntityByObj(user);
    }


}
