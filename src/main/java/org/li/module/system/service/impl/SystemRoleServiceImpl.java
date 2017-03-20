
package org.li.module.system.service.impl;

import org.li.common.base.page.PageInfo;
import org.li.common.base.page.PagerControl;
import org.li.module.system.bean.SystemRole;
import org.li.module.system.dao.SystemRoleDao;
import org.li.module.system.service.SystemRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author liyanjun
 * @date 2017-3-20 16:28:08
 */
@Service
public class SystemRoleServiceImpl implements SystemRoleService {

    @Autowired
    private SystemRoleDao systemRoleDao;
    
    public Integer insertSystemRole(SystemRole systemRole){
	if (systemRole == null) {
	    return 0;
	}
	
	Integer i = systemRoleDao.insert(systemRole);
	return i;
    }

    public Integer updateSystemRole(SystemRole systemRole){
	if (systemRole == null) {
	    return 0;
	}
	
	Integer i = systemRoleDao.update(systemRole);
	return i;
    }

    public PagerControl<SystemRole> page(SystemRole systemRole, PageInfo pageInfo, String whereSql, String orderSql){
	return systemRoleDao.getPagerByObj(systemRole, pageInfo, whereSql, orderSql);
    }

    public SystemRole find(Integer id){
	return systemRoleDao.getEntityById(id);
    }

	@Override
	public Integer delete(Integer id) {
		return null;
	}

	@Override
	public Integer delete(Integer id, Integer updateId) {
		return null;
	}
    
   /* public Integer delete(Integer id){
	SystemRole temp = new SystemRole();
	temp.setId(id);
	temp.setDeleted(true);
	return systemRoleDao.update(temp);
    }
    
    public Integer delete(Integer id, Integer updateId) {
	SystemRole temp = new SystemRole();
	temp.setId(id);
	temp.setDeleted(true);
	temp.setUpdateId(updateId);
	return systemRoleDao.update(temp);
    }*/
    

}
