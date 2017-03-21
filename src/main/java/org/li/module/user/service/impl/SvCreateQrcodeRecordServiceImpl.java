
package org.li.module.user.service.impl;

import org.li.common.base.page.PagerControl;
import org.li.common.base.page.PageInfo;
import org.li.module.user.bean.SvCreateQrcodeRecord;
import org.li.module.user.dao.SvCreateQrcodeRecordDao;
import org.li.module.user.service.SvCreateQrcodeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 创建开门二维码记录
 *
 * @author liyanjun
 * @date 2017-3-21 17:08:14
 */
@Service
public class SvCreateQrcodeRecordServiceImpl implements SvCreateQrcodeRecordService {

    @Autowired
    private SvCreateQrcodeRecordDao svCreateQrcodeRecordDao;

    public Integer insertSvCreateQrcodeRecord(SvCreateQrcodeRecord svCreateQrcodeRecord) {
        if (svCreateQrcodeRecord == null) {
            return 0;
        }

        Integer i = svCreateQrcodeRecordDao.insert(svCreateQrcodeRecord);
        return i;
    }

    public Integer updateSvCreateQrcodeRecord(SvCreateQrcodeRecord svCreateQrcodeRecord) {
        if (svCreateQrcodeRecord == null) {
            return 0;
        }

        Integer i = svCreateQrcodeRecordDao.update(svCreateQrcodeRecord);
        return i;
    }

    public PagerControl<SvCreateQrcodeRecord> page(SvCreateQrcodeRecord svCreateQrcodeRecord, PageInfo pageInfo, String whereSql, String orderSql) {
        return svCreateQrcodeRecordDao.getPagerByObj(svCreateQrcodeRecord, pageInfo, whereSql, orderSql);
    }

    public SvCreateQrcodeRecord find(Integer id) {
        return svCreateQrcodeRecordDao.getEntityById(id);
    }

    public Integer delete(Integer id) {
        SvCreateQrcodeRecord temp = new SvCreateQrcodeRecord();
        temp.setId(id);
        return svCreateQrcodeRecordDao.update(temp);
    }

    public Integer delete(Integer id, Integer updateId) {
        SvCreateQrcodeRecord temp = new SvCreateQrcodeRecord();
        temp.setId(id);
        return svCreateQrcodeRecordDao.update(temp);
    }

}
