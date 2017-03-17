
package org.li.module.service;


import org.li.common.base.page.PageInfo;
import org.li.common.base.page.PagerControl;
import org.li.module.bean.User;

/**
 * 
 * @author liyanjun
 * @date 2017-3-14 15:49:48
 */
public interface UserService {

    Integer insertUser(User user);

    Integer updateUser(User user);

    PagerControl<User> page(User user, PageInfo pageInfo, String whereSql, String orderSql);

    User find(Integer id);
    
    Integer delete(Integer id);
    
    Integer delete(Integer id, Integer updateId);

    User findByUserName(String userName);
}
