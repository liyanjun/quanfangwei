
package org.li.module.lingling.service;


import org.li.module.lingling.bean.*;

import java.util.List;

/**
 * 业主信息表
 * @author liyanjun
 * @date 2017-3-20 10:52:44
 */
public interface SvOwnerService {

    /**
     * 从令令数据库查询用户信息
     * @param phone
     * @return
     */
    SvOwner findLingLingUserInfo(String phone);

    /**
     * 住户可用设备查询
     * @param owner_id
     * @param first
     *@param count @return
     */
    List<SvLingLingDevice> findUserDevices(Integer owner_id, Integer first, Integer count);

    /**
     * 查询访客记录
     * @param ownerId
     * @param first
     * @param count
     */
    List<SvVisitorQrcode> findVisitRecord(Integer ownerId, Integer codeId,Integer first, Integer count);

    SysUser findLingLingManagerInfo(String phone);

    List<SvOwner> findLingLingUserInfoList(Integer userId, Integer first, Integer count);

    List<SvResidential> findManagerBuilding(Integer ownerId, Integer first, Integer count);

    List<SvLingLingDevice> findAllDevices();

    List<SvLingLingDevice> findAllDevices(Integer first, Integer count);

    SvLingLingDevice findDevicesById(Integer devId);
}
