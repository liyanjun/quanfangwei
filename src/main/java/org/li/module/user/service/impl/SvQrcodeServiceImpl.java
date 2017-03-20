
package org.li.module.user.service.impl;

import org.li.common.base.page.PageInfo;
import org.li.common.base.page.PagerControl;
import org.li.module.user.bean.*;
import org.li.module.user.dao.SvQrcodeDao;
import org.li.module.user.service.SvQrcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liyanjun
 * @date 2017-3-20 16:28:07
 */
@Service
public class SvQrcodeServiceImpl implements SvQrcodeService {

    @Autowired
    private SvQrcodeDao svQrcodeDao;

    public Integer insertSvQrcode(SvQrcode svQrcode) {
        if (svQrcode == null) {
            return 0;
        }

        Integer i = svQrcodeDao.insert(svQrcode);
        return i;
    }

    public Integer updateSvQrcode(SvQrcode svQrcode) {
        if (svQrcode == null) {
            return 0;
        }

        Integer i = svQrcodeDao.update(svQrcode);
        return i;
    }

    public PagerControl<SvQrcode> page(SvQrcode svQrcode, PageInfo pageInfo, String whereSql, String orderSql) {
        return svQrcodeDao.getPagerByObj(svQrcode, pageInfo, whereSql, orderSql);
    }

    public SvQrcode find(Integer id) {
        return svQrcodeDao.getEntityById(id);
    }

    @Override
    public Integer delete(Integer id) {
        return null;
    }

    @Override
    public Integer delete(Integer id, Integer updateId) {
        return null;
    }

   /* public Integer delete(Integer id) {
        SvQrcode temp = new SvQrcode();
        temp.setId(id);
        temp.setDeleted(true);
        return svQrcodeDao.update(temp);
    }

    public Integer delete(Integer id, Integer updateId) {
        SvQrcode temp = new SvQrcode();
        temp.setId(id);
        temp.setDeleted(true);
        temp.setUpdateId(updateId);
        return svQrcodeDao.update(temp);
    }*/


}
