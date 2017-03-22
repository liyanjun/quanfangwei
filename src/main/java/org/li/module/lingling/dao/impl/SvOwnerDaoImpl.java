
package org.li.module.lingling.dao.impl;

import org.li.common.base.dao.LingLingBaseDao;
import org.li.module.lingling.bean.SvLingLingDevice;
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
    public List<SvLingLingDevice> findUserDevices(Integer ownerId) {
        return this.getSqlSession().selectList(this.getMapperNameSpace() + ".findUserDevices", ownerId);
    }

    @Override
    public SvOwner findLingLingManagerInfo(String phone) {
        SvOwner returnObj = this.getSqlSession().selectOne(this.getMapperNameSpace() + ".findLingLingManagerInfo", phone);
        return returnObj;
    }
}
