
package org.li.module.system.service;


import org.li.common.base.page.PageInfo;
import org.li.common.base.page.PagerControl;
import org.li.module.system.bean.SystemResource;

/**
 * 
 * @author liyanjun
 * @date 2017-3-20 16:28:08
 */
public interface SystemResourceService {

    Integer insertSystemResource(SystemResource systemResource);

    Integer updateSystemResource(SystemResource systemResource);

    PagerControl<SystemResource> page(SystemResource systemResource, PageInfo pageInfo, String whereSql, String orderSql);

    SystemResource find(Integer id);
    
    Integer delete(Integer id);
    
    Integer delete(Integer id, Integer updateId);

}
