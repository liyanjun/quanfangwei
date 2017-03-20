
package org.li.module.system.service;


import org.li.common.base.page.PageInfo;
import org.li.common.base.page.PagerControl;
import org.li.module.system.bean.SystemRole;

/**
 * 
 * @author liyanjun
 * @date 2017-3-20 16:28:08
 */
public interface SystemRoleService {

    Integer insertSystemRole(SystemRole systemRole);

    Integer updateSystemRole(SystemRole systemRole);

    PagerControl<SystemRole> page(SystemRole systemRole, PageInfo pageInfo, String whereSql, String orderSql);

    SystemRole find(Integer id);
    
    Integer delete(Integer id);
    
    Integer delete(Integer id, Integer updateId);

}
