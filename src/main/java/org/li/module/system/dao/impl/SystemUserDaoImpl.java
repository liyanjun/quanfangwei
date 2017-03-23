
package org.li.module.system.dao.impl;

import org.li.common.base.dao.BaseDao;
import org.li.module.system.bean.SystemRole;
import org.li.module.system.bean.SystemUser;
import org.li.module.system.bean.SystemUserRole;
import org.li.module.system.dao.SystemUserDao;
import org.springframework.stereotype.Repository;

/**
 * @author liyanjun
 * @date 2017-3-20 10:39:37
 */
@Repository
public class SystemUserDaoImpl extends BaseDao<Integer, SystemUser> implements SystemUserDao {

    @Override
    public int insertUserRole(SystemUserRole systemUserRole) {
        return this.getSqlSession().insert(this.getMapperNameSpace() + ".insertSelective", systemUserRole);
    }
}
