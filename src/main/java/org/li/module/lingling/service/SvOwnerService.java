
package org.li.module.lingling.service;


import org.li.common.base.page.PageInfo;
import org.li.common.base.page.PagerControl;
import org.li.module.lingling.bean.SvOwner;

/**
 * 业主信息表
 * @author liyanjun
 * @date 2017-3-20 10:52:44
 */
public interface SvOwnerService {

    Integer insertSvOwner(SvOwner svOwner);

    Integer updateSvOwner(SvOwner svOwner);

    PagerControl<SvOwner> page(SvOwner svOwner, PageInfo pageInfo, String whereSql, String orderSql);

    SvOwner find(Integer id);
    
}
