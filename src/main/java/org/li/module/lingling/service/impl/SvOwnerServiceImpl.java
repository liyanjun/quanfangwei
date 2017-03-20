
package org.li.module.lingling.service.impl;

import org.li.common.base.page.PageInfo;
import org.li.common.base.page.PagerControl;
import org.li.module.lingling.bean.SvOwner;
import org.li.module.lingling.dao.SvOwnerDao;
import org.li.module.lingling.service.SvOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Integer insertSvOwner(SvOwner svOwner) {
        if (svOwner == null) {
            return 0;
        }

        Integer i = svOwnerDao.insert(svOwner);
        return i;
    }

    public Integer updateSvOwner(SvOwner svOwner) {
        if (svOwner == null) {
            return 0;
        }

        Integer i = svOwnerDao.update(svOwner);
        return i;
    }

    public PagerControl<SvOwner> page(SvOwner svOwner, PageInfo pageInfo, String whereSql, String orderSql) {
        return svOwnerDao.getPagerByObj(svOwner, pageInfo, whereSql, orderSql);
    }

    public SvOwner find(Integer id) {
        return svOwnerDao.getEntityById(id);
    }

}
