package org.li.module.system.bean;

import org.li.common.base.bean.BaseEntity;



/**
 * 
 * @author liyanjun
 * @date 2017-3-20 16:28:07
 */
public class SystemResource extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**资源名*/
	private String name;

	/**资源地址*/
	private String url;

	public SystemResource(){
	}

	public SystemResource(Integer id){
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
	public void setUrl(String value) {
		this.url = value;
	}

	public String getUrl() {
		return this.url;
	}

}

