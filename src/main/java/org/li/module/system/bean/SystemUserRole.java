package org.li.module.system.bean;

import org.li.common.base.bean.BaseEntity;


/**
 * 
 * @author liyanjun
 * @date 2017-3-20 16:28:08
 */
public class SystemUserRole extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**角色ID*/
	private Integer roleId;

	/**用户名*/
	private Integer userId;

	public SystemUserRole(Integer id, Integer roleId) {
		this.userId = id;
		this.roleId = roleId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}

