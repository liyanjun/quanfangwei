
package org.li.module.lingling.dao;
import org.li.common.base.dao.IDao;
import org.li.module.lingling.bean.*;
import org.li.module.user.bean.SvDevice;

import java.util.List;

/**
 * 业主信息表
 * @author liyanjun
 * @date 2017-3-20 10:52:44
 */
public interface SvOwnerDao extends IDao<Integer, SvOwner> {

    SvOwner findLingLingUserInfo(String phone);

    List<SvLingLingDevice> findUserDevices(Integer owner_id, Integer first, Integer count);

    List<SvVisitorQrcode> findVisitRecord(Integer ownerId, Integer codeId, Integer first, Integer count);

    SysUser findLingLingManagerInfo(String phone);

    List<SvOwner> findManagerUser(Integer userId, Integer first, Integer count);

    List<SvResidential> findManagerBuilding(Integer ownerId, Integer first, Integer count);
}
