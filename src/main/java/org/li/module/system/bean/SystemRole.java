package org.li.module.system.bean;

import org.li.common.base.bean.BaseEntity;



/**
 * 
 * @author liyanjun
 * @date 2017-3-20 16:28:08
 */
public class SystemRole extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**角色名*/
	private String name;

	/**角色描述*/
	private String describ;

	public SystemRole(){
	}

	public SystemRole(Integer id){
		this.id = id;
	}

	public void setId(Integer value) {
		this.id = value;
	}

	public Integer getId() {
		return this.id;
	}
	public void setName(String value) {
		this.name = value;
	}

	public String getName() {
		return this.name;
	}
	public void setDescrib(String value) {
		this.describ = value;
	}

	public String getDescrib() {
		return this.describ;
	}
}

