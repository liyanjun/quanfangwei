
package org.li.module.user.service;

import org.li.common.base.page.PageInfo;
import org.li.common.base.page.PagerControl;
import org.li.module.user.bean.*;


/**
 * 
 * @author liyanjun
 * @date 2017-3-20 16:28:07
 */
public interface SvQrcodeService {

    Integer insertSvQrcode(SvQrcode svQrcode);

    Integer updateSvQrcode(SvQrcode svQrcode);

    PagerControl<SvQrcode> page(SvQrcode svQrcode, PageInfo pageInfo, String whereSql, String orderSql);

    SvQrcode find(Integer id);
    
    Integer delete(Integer id);
    
    Integer delete(Integer id, Integer updateId);

}
