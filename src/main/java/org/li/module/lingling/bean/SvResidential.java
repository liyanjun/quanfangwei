package org.li.module.lingling.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.li.common.base.bean.BaseEntity;

import java.sql.Timestamp;



/**
 * 
 * @author liyanjun
 * @date 2017-3-21 11:04:52
 */
public class SvResidential extends BaseEntity {

	private static final long serialVersionUID = 1L;


	/**主键Id，自增*/
	private Integer residentialId;

	/**社区ID*/
	private Integer regionId;

	/**小区编码*/
	private String residentialCode;

	/**小区名称*/
	private String residentialName;

	/**经理名称*/
	private String managerName;

	/**电话号码*/
	private String telephone;

	/**地址*/
	private String address;

	/**申请时间*/
	private Timestamp time;

	/**用户ID*/
	private Integer userId;

	/**小区类型*/
	private Integer residentialType;

	/**开始时间*/
	private Integer startTime;

	/**结束时间*/
	private Integer endTime;

	/**状态，0为无效，1为有效*/
	private Integer status;

	/**备注*/
	private String note;

	/**父ID*/
	private Integer parentId;

	public SvResidential(){
	}

	public SvResidential(Integer residentialId){
		this.residentialId = residentialId;
	}

	public void setResidentialId(Integer value) {
		this.residentialId = value;
	}

	public Integer getResidentialId() {
		return this.residentialId;
	}
	public void setRegionId(Integer value) {
		this.regionId = value;
	}

	public Integer getRegionId() {
		return this.regionId;
	}
	public void setResidentialCode(String value) {
		this.residentialCode = value;
	}

	public String getResidentialCode() {
		return this.residentialCode;
	}
	public void setResidentialName(String value) {
		this.residentialName = value;
	}

	public String getResidentialName() {
		return this.residentialName;
	}
	public void setManagerName(String value) {
		this.managerName = value;
	}

	public String getManagerName() {
		return this.managerName;
	}
	public void setTelephone(String value) {
		this.telephone = value;
	}

	public String getTelephone() {
		return this.telephone;
	}
	public void setAddress(String value) {
		this.address = value;
	}

	public String getAddress() {
		return this.address;
	}

	public void setTime(Timestamp value) {
		this.time = value;
	}

	public Timestamp getTime() {
		return this.time;
	}
	public void setUserId(Integer value) {
		this.userId = value;
	}

	public Integer getUserId() {
		return this.userId;
	}
	public void setResidentialType(Integer value) {
		this.residentialType = value;
	}

	public Integer getResidentialType() {
		return this.residentialType;
	}
	public void setStartTime(Integer value) {
		this.startTime = value;
	}

	public Integer getStartTime() {
		return this.startTime;
	}
	public void setEndTime(Integer value) {
		this.endTime = value;
	}

	public Integer getEndTime() {
		return this.endTime;
	}
	public void setStatus(Integer value) {
		this.status = value;
	}

	public Integer getStatus() {
		return this.status;
	}
	public void setNote(String value) {
		this.note = value;
	}

	public String getNote() {
		return this.note;
	}
	public void setParentId(Integer value) {
		this.parentId = value;
	}

	public Integer getParentId() {
		return this.parentId;
	}



	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("ResidentialId",getResidentialId())
			.append("RegionId",getRegionId())
			.append("ResidentialCode",getResidentialCode())
			.append("ResidentialName",getResidentialName())
			.append("ManagerName",getManagerName())
			.append("Telephone",getTelephone())
			.append("Address",getAddress())
			.append("Time",getTime())
			.append("UserId",getUserId())
			.append("ResidentialType",getResidentialType())
			.append("StartTime",getStartTime())
			.append("EndTime",getEndTime())
			.append("Status",getStatus())
			.append("Note",getNote())
			.append("ParentId",getParentId())
			.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
			.append(getResidentialId())
			.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof SvResidential == false) return false;
		if(this == obj) return true;
		SvResidential other = (SvResidential)obj;
		return new EqualsBuilder()
			.append(getResidentialId(),other.getResidentialId())
			.isEquals();
	}
}

