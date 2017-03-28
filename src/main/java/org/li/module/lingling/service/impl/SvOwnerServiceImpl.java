
package org.li.module.lingling.service.impl;

import org.li.module.lingling.bean.*;
import org.li.module.lingling.dao.SvOwnerDao;
import org.li.module.lingling.service.SvOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 业主信息表
 *
 * @author liyanjun
 * @date 2017-3-20 10:52:44
 */
@Service
public class SvOwnerServiceImpl implements SvOwnerService {

    @Autowired
    private SvOwnerDao svOwnerDao;

    @Override
    public SvOwner findLingLingUserInfo(String phone) {
        return svOwnerDao.findLingLingUserInfo(phone);
    }

    @Override
    public List<SvLingLingDevice> findUserDevices(Integer ownerId, Integer first, Integer count) {
        return svOwnerDao.findUserDevices(ownerId,first,count);
    }

    @Override
    public List<SvVisitorQrcode> findVisitRecord(Integer ownerId, Integer codeId,Integer first, Integer count) {
        return svOwnerDao.findVisitRecord(ownerId,codeId,first,count);
    }

    @Override
    public SysUser findLingLingManagerInfo(String phone) {
        return svOwnerDao.findLingLingManagerInfo(phone);
    }

    @Override
    public List<SvOwner> findLingLingUserInfoList(Integer userId, Integer first, Integer count) {
        return svOwnerDao.findManagerUser(userId,first,count);
    }

    @Override
    public List<SvResidential> findManagerBuilding(Integer ownerId, Integer first, Integer count) {
        return svOwnerDao.findManagerBuilding(ownerId,first,count);
    }

    @Override
    public List<SvLingLingDevice> findAllDevices() {
        return svOwnerDao.findAllDevices();
    }

    @Override
    public List<SvLingLingDevice> findAllDevices(Integer first, Integer count) {
        return svOwnerDao.findAllDevices(first,count);
    }

    @Override
    public SvLingLingDevice findDevicesById(Integer devId) {
        return svOwnerDao.findDevicesById(devId);
    }

}
