
package org.li.module.lingling.dao.impl;

import org.li.common.base.dao.LingLingBaseDao;
import org.li.module.lingling.bean.SvOwner;
import org.li.module.lingling.dao.SvOwnerDao;
import org.li.module.user.bean.SvDevice;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 业主信息表
 * @author liyanjun
 * @date 2017-3-20 10:52:44
 */
@Repository
public class SvOwnerDaoImpl extends LingLingBaseDao<Integer, SvOwner> implements SvOwnerDao {

    @Override
    public SvOwner findLingLingUserInfo(String phone) {
        SvOwner returnObj = this.getSqlSession().selectOne(this.getMapperNameSpace() + ".findLingLingUserInfo", phone);
        return returnObj;
    }

    @Override
    public List<SvDevice> findUserDevices(Integer owner_id) {
        return this.getSqlSession().selectList(this.getMapperNameSpace() + ".findUserDevices", owner_id);
    }
}
