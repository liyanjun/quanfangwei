
package org.li.module.lingling.service.impl;

import org.li.common.base.page.PageInfo;
import org.li.common.base.page.PagerControl;
import org.li.module.lingling.bean.SvLingLingDevice;
import org.li.module.lingling.bean.SvOwner;
import org.li.module.lingling.dao.SvOwnerDao;
import org.li.module.lingling.service.SvOwnerService;
import org.li.module.user.bean.SvDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<SvLingLingDevice> findUserDevices(Integer ownerId) {
        return svOwnerDao.findUserDevices(ownerId);
    }

    @Override
    public SvOwner findLingLingManagerInfo(String phone) {
        return svOwnerDao.findLingLingManagerInfo(phone);
    }

}
