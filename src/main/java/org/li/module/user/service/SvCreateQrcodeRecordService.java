
package org.li.module.user.service;


import org.li.common.base.page.PageInfo;
import org.li.common.base.page.PagerControl;
import org.li.module.user.bean.SvCreateQrcodeRecord;

/**
 * 创建开门二维码记录
 * @author liyanjun
 * @date 2017-3-21 17:08:14
 */
public interface SvCreateQrcodeRecordService {

    Integer insertSvCreateQrcodeRecord(SvCreateQrcodeRecord svCreateQrcodeRecord);

    Integer updateSvCreateQrcodeRecord(SvCreateQrcodeRecord svCreateQrcodeRecord);

    PagerControl<SvCreateQrcodeRecord> page(SvCreateQrcodeRecord svCreateQrcodeRecord, PageInfo pageInfo, String whereSql, String orderSql);

    SvCreateQrcodeRecord find(Integer id);
    
    Integer delete(Integer id);
    
    Integer delete(Integer id, Integer updateId);

}
