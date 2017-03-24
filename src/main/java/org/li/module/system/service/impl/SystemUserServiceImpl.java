
package org.li.module.system.service.impl;

import org.li.common.base.page.PageInfo;
import org.li.common.base.page.PagerControl;
import org.li.common.util.DateUtil;
import org.li.common.util.lingling.LingLingSDK;
import org.li.module.lingling.bean.SvLingLingDevice;
import org.li.module.lingling.dao.SvOwnerDao;
import org.li.module.system.bean.SystemUser;
import org.li.module.system.bean.SystemUserRole;
import org.li.module.system.dao.SystemUserDao;
import org.li.module.system.service.SystemUserService;
import org.li.module.user.bean.SvDevice;
import org.li.module.user.dao.SvDeviceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;

import java.util.List;

/**
 * @author liyanjun
 * @date 2017-3-20 10:39:37
 */
@Service
public class SystemUserServiceImpl implements SystemUserService {

    @Autowired
    private SystemUserDao systemUserDao;
    @Autowired
    private SvOwnerDao svOwnerDao;

    @Autowired
    private SvDeviceDao svDeviceDao;

    @Transactional(value = "transactionManagerMine")
    public Integer insertSystemUser(SystemUser systemUser,Integer roleId) {

        if (systemUser == null) {
            return 0;
        }
        Integer i = systemUserDao.insert(systemUser);
        systemUserDao.insertUserRole(new SystemUserRole(systemUser.getId(),roleId));
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
        temp.setIsDel(1);
        temp.setUpdateTime(DateUtil.getCurrentTimestamp());
        return systemUserDao.update(temp);
    }

//    public Integer delete(Integer id, Integer updateId) {
//        SystemUser temp = new SystemUser();
//        temp.setId(id);
//        temp.setIsDel(1);
//        temp.setUpdateTime(DateUtil.getCurrentTimestamp());
//        return systemUserDao.update(temp);
//    }

    @Override
    public SystemUser findByPhone(String phone) {
        SystemUser systemUser = new SystemUser();
        systemUser.setPhone(phone);
        systemUser = systemUserDao.getEntityByObj(systemUser);
        if(systemUser == null){
            return null;
        }
        systemUser.setRoleId(systemUserDao.findRoleId(systemUser.getId()));
        return systemUser;
    }

}
