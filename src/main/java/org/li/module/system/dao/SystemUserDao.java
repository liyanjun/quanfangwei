
package org.li.module.system.dao;


import org.li.common.base.dao.IDao;
import org.li.module.system.bean.SystemUser;
import org.li.module.system.bean.SystemUserRole;

/**
 * @author liyanjun
 * @date 2017-3-20 10:39:37
 */
public interface SystemUserDao extends IDao<Integer, SystemUser> {

    int insertUserRole(SystemUserRole systemUserRole);

    Integer findRoleId(Integer id);
}
