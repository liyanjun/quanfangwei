
package org.li.module.system.service;


import org.li.common.base.page.PageInfo;
import org.li.common.base.page.PagerControl;
import org.li.module.system.bean.SystemUser;

/**
 * @author liyanjun
 * @date 2017-3-20 10:39:37
 */
public interface SystemUserService {

    Integer insertSystemUser(SystemUser systemUser,Integer roleId);

    Integer updateSystemUser(SystemUser systemUser);

    PagerControl<SystemUser> page(SystemUser systemUser, PageInfo pageInfo, String whereSql, String orderSql);

    SystemUser find(Integer id);

    Integer delete(Integer id);

    Integer delete(Integer id, Integer updateId);

    SystemUser findByPhone(String phone);

//    void createQRCode(SystemUser systemUser);
}
