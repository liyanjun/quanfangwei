
package org.li.module.lingling.service;


import org.li.common.base.page.PageInfo;
import org.li.common.base.page.PagerControl;
import org.li.module.lingling.bean.SvLingLingDevice;
import org.li.module.lingling.bean.SvOwner;
import org.li.module.user.bean.SvDevice;

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
     * @return
     */
    List<SvLingLingDevice> findUserDevices(Integer owner_id);

    SvOwner findLingLingManagerInfo(String phone);
}
