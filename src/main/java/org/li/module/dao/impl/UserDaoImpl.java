
package org.li.module.dao.impl;

import org.li.common.base.dao.BaseDao;
import org.li.module.bean.User;
import org.li.module.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author liyanjun
 * @date 2017-3-14 15:49:48
 */
@Repository
public class UserDaoImpl extends BaseDao<Integer, User> implements UserDao {

}
