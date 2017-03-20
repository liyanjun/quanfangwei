
package org.li.module.system.service.impl;

import org.li.common.base.page.PageInfo;
import org.li.common.base.page.PagerControl;
import org.li.module.system.bean.SystemResource;
import org.li.module.system.dao.SystemResourceDao;
import org.li.module.system.service.SystemResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liyanjun
 * @date 2017-3-20 16:28:08
 */
@Service
public class SystemResourceServiceImpl implements SystemResourceService {

    @Autowired
    private SystemResourceDao systemResourceDao;

    public Integer insertSystemResource(SystemResource systemResource) {
        if (systemResource == null) {
            return 0;
        }

        Integer i = systemResourceDao.insert(systemResource);
        return i;
    }

    public Integer updateSystemResource(SystemResource systemResource) {
        if (systemResource == null) {
            return 0;
        }

        Integer i = systemResourceDao.update(systemResource);
        return i;
    }

    public PagerControl<SystemResource> page(SystemResource systemResource, PageInfo pageInfo, String whereSql, String orderSql) {
        return systemResourceDao.getPagerByObj(systemResource, pageInfo, whereSql, orderSql);
    }

    public SystemResource find(Integer id) {
        return systemResourceDao.getEntityById(id);
    }

    @Override
    public Integer delete(Integer id) {
        return null;
    }

    @Override
    public Integer delete(Integer id, Integer updateId) {
        return null;
    }

//    public Integer delete(Integer id){
//	SystemResource temp = new SystemResource();
//	temp.setId(id);
//	temp.setDeleted(true);
//	return systemResourceDao.update(temp);
//    }
//
//    public Integer delete(Integer id, Integer updateId) {
//	SystemResource temp = new SystemResource();
//	temp.setId(id);
//	temp.setDeleted(true);
//	temp.setUpdateId(updateId);
//	return systemResourceDao.update(temp);
//    }


}
