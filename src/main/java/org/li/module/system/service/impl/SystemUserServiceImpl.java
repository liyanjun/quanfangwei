
package org.li.module.system.service.impl;

import org.li.common.base.page.PageInfo;
import org.li.common.base.page.PagerControl;
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

    @Transactional
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
        temp.setId(1);
        return systemUserDao.update(temp);
    }

    public Integer delete(Integer id, Integer updateId) {
        SystemUser temp = new SystemUser();
        temp.setId(id);
        temp.setId(1);
        return systemUserDao.update(temp);
    }

    @Override
    public SystemUser findByPhone(String phone) {
        SystemUser systemUser = new SystemUser();
        systemUser.setPhone(phone);
        return systemUserDao.getEntityByObj(systemUser);
    }

    @Override
    public void createQRCode(SystemUser systemUser) {
        List<SvLingLingDevice> devices = svOwnerDao.findUserDevices(systemUser.getOwnerId(),null,null);
        //TODO 生成开门秘钥,生成我们自己的设备记录
        List<SvDevice> svDevices = LingLingSDK.createSdkKey(devices);
        //TODO 生成业主二维码
        LingLingSDK.createQrcodeKey(devices, systemUser);

        //TODO 更新开门秘钥到我们自己的数据库
        for (SvDevice device : svDevices){
            SvDevice svDevice = new SvDevice();
            svDeviceDao.insert(svDevice);
        }
        systemUserDao.insert(systemUser);
        //TODO 关联角色

    }


}
