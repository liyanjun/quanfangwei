
package org.li.module.system.service;


import org.li.common.base.page.PageInfo;
import org.li.common.base.page.PagerControl;
import org.li.module.system.bean.SystemThirdconnectorLog;

/**
 * 第三方链接日志表
 * @author liyanjun
 * @date 2017-3-21 17:08:14
 */
public interface SystemThirdconnectorLogService {

    Integer insertSystemThirdconnectorLog(SystemThirdconnectorLog systemThirdconnectorLog);

    Integer updateSystemThirdconnectorLog(SystemThirdconnectorLog systemThirdconnectorLog);

    SystemThirdconnectorLog find(Integer id);
    
    Integer delete(Integer id);
    
    Integer delete(Integer id, Integer updateId);

}
