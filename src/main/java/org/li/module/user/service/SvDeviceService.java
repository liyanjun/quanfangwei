
package org.li.module.user.service;

import org.li.common.base.page.PageInfo;
import org.li.common.base.page.PagerControl;
import org.li.module.user.bean.*;


/**
 * 
 * @author liyanjun
 * @date 2017-3-20 16:28:07
 */
public interface SvDeviceService {

    Integer insertSvDevice(SvDevice svDevice);

    Integer updateSvDevice(SvDevice svDevice);

    PagerControl<SvDevice> page(SvDevice svDevice, PageInfo pageInfo, String whereSql, String orderSql);

    SvDevice find(Integer id);
    
    Integer delete(Integer id);
    
    Integer delete(Integer id, Integer updateId);

}
