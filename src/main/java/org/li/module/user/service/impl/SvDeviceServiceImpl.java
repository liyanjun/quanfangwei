
package org.li.module.user.service.impl;

import org.li.common.base.page.PageInfo;
import org.li.common.base.page.PagerControl;
import org.li.module.user.bean.*;
import org.li.module.user.dao.SvDeviceDao;
import org.li.module.user.service.SvDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liyanjun
 * @date 2017-3-20 16:28:07
 */
@Service
public class SvDeviceServiceImpl implements SvDeviceService {

    @Autowired
    private SvDeviceDao svDeviceDao;

    public Integer insertSvDevice(SvDevice svDevice) {
        if (svDevice == null) {
            return 0;
        }

        Integer i = svDeviceDao.insert(svDevice);
        return i;
    }

    public Integer updateSvDevice(SvDevice svDevice) {
        if (svDevice == null) {
            return 0;
        }

        Integer i = svDeviceDao.update(svDevice);
        return i;
    }

    public PagerControl<SvDevice> page(SvDevice svDevice, PageInfo pageInfo, String whereSql, String orderSql) {
        return svDeviceDao.getPagerByObj(svDevice, pageInfo, whereSql, orderSql);
    }

    public SvDevice find(Integer id) {
        return svDeviceDao.getEntityById(id);
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
//	SvDevice temp = new SvDevice();
//	temp.setId(id);
//	temp.setDeleted(true);
//	return svDeviceDao.update(temp);
//    }
//
//    public Integer delete(Integer id, Integer updateId) {
//	SvDevice temp = new SvDevice();
//	temp.setId(id);
//	temp.setDeleted(true);
//	temp.setUpdateId(updateId);
//	return svDeviceDao.update(temp);
//    }


}
