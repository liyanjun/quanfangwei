package org.li.module.system.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.li.common.base.bean.BaseEntity;

import java.sql.Timestamp;

/**
 * 第三方链接日志表
 * @author liyanjun
 * @date 2017-3-21 17:08:14
 */
public class SystemThirdconnectorLog extends BaseEntity {

	private static final long serialVersionUID = 1L;


	/***/
	private Integer id;

	/**链接名*/
	private String connectorName;

	/**请求地址*/
	private String requestUrl;

	/**请求*/
	private String request;

	/**返回*/
	private String returnBack;

	/**保留参数*/
	private String other1;

	/**保留参数2*/
	private String other2;

	/***/
	private Timestamp createTime;

	public SystemThirdconnectorLog(){
	}

	public SystemThirdconnectorLog(Integer id){
		this.id = id;
	}

	public void setId(Integer value) {
		this.id = value;
	}

	public Integer getId() {
		return this.id;
	}
	public void setConnectorName(String value) {
		this.connectorName = value;
	}

	public String getConnectorName() {
		return this.connectorName;
	}
	public void setRequestUrl(String value) {
		this.requestUrl = value;
	}

	public String getRequestUrl() {
		return this.requestUrl;
	}
	public void setRequest(String value) {
		this.request = value;
	}

	public String getRequest() {
		return this.request;
	}
	public void setReturnBack(String value) {
		this.returnBack = value;
	}

	public String getReturnBack() {
		return this.returnBack;
	}
	public void setOther1(String value) {
		this.other1 = value;
	}

	public String getOther1() {
		return this.other1;
	}
	public void setOther2(String value) {
		this.other2 = value;
	}

	public String getOther2() {
		return this.other2;
	}

	public void setCreateTime(Timestamp value) {
		this.createTime = value;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}



	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("ConnectorName",getConnectorName())
			.append("RequestUrl",getRequestUrl())
			.append("Request",getRequest())
			.append("ReturnBack",getReturnBack())
			.append("Other1",getOther1())
			.append("Other2",getOther2())
			.append("CreateTime",getCreateTime())
			.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof SystemThirdconnectorLog == false) return false;
		if(this == obj) return true;
		SystemThirdconnectorLog other = (SystemThirdconnectorLog)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

