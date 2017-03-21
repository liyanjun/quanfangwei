
package org.li.module.system.service.impl;

import org.li.common.base.page.PageInfo;
import org.li.module.system.bean.SystemThirdconnectorLog;
import org.li.module.system.dao.SystemThirdconnectorLogDao;
import org.li.module.system.service.SystemThirdconnectorLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 第三方链接日志表
 *
 * @author liyanjun
 * @date 2017-3-21 17:08:14
 */
@Service
public class SystemThirdconnectorLogServiceImpl implements SystemThirdconnectorLogService {

    @Autowired
    private SystemThirdconnectorLogDao systemThirdconnectorLogDao;

    public Integer insertSystemThirdconnectorLog(SystemThirdconnectorLog systemThirdconnectorLog) {
        if (systemThirdconnectorLog == null) {
            return 0;
        }

        Integer i = systemThirdconnectorLogDao.insert(systemThirdconnectorLog);
        return i;
    }

    public Integer updateSystemThirdconnectorLog(SystemThirdconnectorLog systemThirdconnectorLog) {
        if (systemThirdconnectorLog == null) {
            return 0;
        }

        Integer i = systemThirdconnectorLogDao.update(systemThirdconnectorLog);
        return i;
    }

    public SystemThirdconnectorLog find(Integer id) {
        return systemThirdconnectorLogDao.getEntityById(id);
    }

    public Integer delete(Integer id) {
        SystemThirdconnectorLog temp = new SystemThirdconnectorLog();
        temp.setId(id);
//	temp.setDeleted(true);
        return systemThirdconnectorLogDao.update(temp);
    }

    public Integer delete(Integer id, Integer updateId) {
        SystemThirdconnectorLog temp = new SystemThirdconnectorLog();
        temp.setId(id);
//	temp.setDeleted(true);
//	temp.setUpdateId(updateId);
        return systemThirdconnectorLogDao.update(temp);
    }


    private class PagerControl<T> {
    }
}
