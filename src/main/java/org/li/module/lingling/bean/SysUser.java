package org.li.module.lingling.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.li.common.base.bean.BaseEntity;



/**
 * 
 * @author liyanjun
 * @date 2017-3-21 11:04:54
 */
public class SysUser extends BaseEntity {

	private static final long serialVersionUID = 1L;


	/**用户表ID，自增*/
	private Integer userId;

	/**用户的登录账户*/
	private String account;

	/**父ID*/
	private Integer parentId;

	/**用户的真实姓名*/
	private String name;

	/**姓别*/
	private Integer sex;

	/**手机号码*/
	private String mobilePhone;

	/**固定电话*/
	private String telephone;

	/**电子邮箱*/
	private String email;

	/**详细地址*/
	private String address;

	/**密码：使用MD5加密*/
	private String password;

	/**归属部门：关联SYS_DEPARTMENT表*/
	private Integer deptId;

	/**用户类型*/
	private Integer typeId;

	/**注销用户：0未开通，1有效，2注销*/
	private Integer statusId;

	/**备注*/
	private String note;

	/**城市Id*/
	private Integer cityId;

	public SysUser(){
	}

	public SysUser(Integer userId){
		this.userId = userId;
	}

	public void setUserId(Integer value) {
		this.userId = value;
	}

	public Integer getUserId() {
		return this.userId;
	}
	public void setAccount(String value) {
		this.account = value;
	}

	public String getAccount() {
		return this.account;
	}
	public void setParentId(Integer value) {
		this.parentId = value;
	}

	public Integer getParentId() {
		return this.parentId;
	}
	public void setName(String value) {
		this.name = value;
	}

	public String getName() {
		return this.name;
	}
	public void setSex(Integer value) {
		this.sex = value;
	}

	public Integer getSex() {
		return this.sex;
	}
	public void setMobilePhone(String value) {
		this.mobilePhone = value;
	}

	public String getMobilePhone() {
		return this.mobilePhone;
	}
	public void setTelephone(String value) {
		this.telephone = value;
	}

	public String getTelephone() {
		return this.telephone;
	}
	public void setEmail(String value) {
		this.email = value;
	}

	public String getEmail() {
		return this.email;
	}
	public void setAddress(String value) {
		this.address = value;
	}

	public String getAddress() {
		return this.address;
	}
	public void setPassword(String value) {
		this.password = value;
	}

	public String getPassword() {
		return this.password;
	}
	public void setDeptId(Integer value) {
		this.deptId = value;
	}

	public Integer getDeptId() {
		return this.deptId;
	}
	public void setTypeId(Integer value) {
		this.typeId = value;
	}

	public Integer getTypeId() {
		return this.typeId;
	}
	public void setStatusId(Integer value) {
		this.statusId = value;
	}

	public Integer getStatusId() {
		return this.statusId;
	}
	public void setNote(String value) {
		this.note = value;
	}

	public String getNote() {
		return this.note;
	}
	public void setCityId(Integer value) {
		this.cityId = value;
	}

	public Integer getCityId() {
		return this.cityId;
	}



	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("UserId",getUserId())
			.append("Account",getAccount())
			.append("ParentId",getParentId())
			.append("Name",getName())
			.append("Sex",getSex())
			.append("MobilePhone",getMobilePhone())
			.append("Telephone",getTelephone())
			.append("Email",getEmail())
			.append("Address",getAddress())
			.append("Password",getPassword())
			.append("DeptId",getDeptId())
			.append("TypeId",getTypeId())
			.append("StatusId",getStatusId())
			.append("Note",getNote())
			.append("CityId",getCityId())
			.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
			.append(getUserId())
			.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof SysUser == false) return false;
		if(this == obj) return true;
		SysUser other = (SysUser)obj;
		return new EqualsBuilder()
			.append(getUserId(),other.getUserId())
			.isEquals();
	}
}

