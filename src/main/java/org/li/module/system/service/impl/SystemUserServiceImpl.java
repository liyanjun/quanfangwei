
package org.li.module.system.service.impl;

import org.li.common.base.page.PageInfo;
import org.li.common.base.page.PagerControl;
import org.li.module.system.bean.SystemUser;
import org.li.module.system.dao.SystemUserDao;
import org.li.module.system.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liyanjun
 * @date 2017-3-20 10:39:37
 */
@Service
public class SystemUserServiceImpl implements SystemUserService {

    @Autowired
    private SystemUserDao systemUserDao;

    public Integer insertSystemUser(SystemUser systemUser) {
        if (systemUser == null) {
            return 0;
        }

        Integer i = systemUserDao.insert(systemUser);
        return i;
    }

    public Integer updateSystemUser(SystemUser systemUser) {
        if (systemUser == null) {
            return 0;
        }

        Integer i = systemUserDao.update(systemUser);
        return i;
    }

    public PagerControl<SystemUser> page(SystemUser systemUser, PageInfo pageInfo, String whereSql, String orderSql) {
        return systemUserDao.getPagerByObj(systemUser, pageInfo, whereSql, orderSql);
    }

    public SystemUser find(Integer id) {
        return systemUserDao.getEntityById(id);
    }

    public Integer delete(Integer id) {
        SystemUser temp = new SystemUser();
        temp.setId(id);
        temp.setId(1);
        return systemUserDao.update(temp);
    }

    public Integer delete(Integer id, Integer updateId) {
        SystemUser temp = new SystemUser();
        temp.setId(id);
        temp.setId(1);
        return systemUserDao.update(temp);
    }


}
