package org.li.common.base.bean;

import java.io.Serializable;

/**
 * 所有实体的公共父类
 *
 */
public abstract class BaseEntity implements Serializable{

	/***/
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
