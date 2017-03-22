
package org.li.module.lingling.dao;
import org.li.common.base.dao.IDao;
import org.li.module.lingling.bean.SvLingLingDevice;
import org.li.module.lingling.bean.SvOwner;
import org.li.module.user.bean.SvDevice;

import java.util.List;

/**
 * 业主信息表
 * @author liyanjun
 * @date 2017-3-20 10:52:44
 */
public interface SvOwnerDao extends IDao<Integer, SvOwner> {

    SvOwner findLingLingUserInfo(String phone);

    List<SvLingLingDevice> findUserDevices(Integer owner_id);

    SvOwner findLingLingManagerInfo(String phone);
}
