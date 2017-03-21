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
public class SvVisitorQrcode extends BaseEntity {

	private static final long serialVersionUID = 1L;


	/**主键Id，自增*/
	private Integer codeId;

	/**业主ID*/
	private Integer ownerId;

	/**二维码数据*/
	private byte[] codeData;

	/**二维码的类型；1为访客二维码，2为APP生成二维码*/
	private Integer codeType;

	/**访客姓名*/
	private String visitorName;

	/**访客电话号码*/
	private String visitorTelephone;

	/**访客姓别；1为男，0为女*/
	private Integer visitorGender;

	/**是否驾车；0为否 1为是*/
	private Integer isDrive;

	/**访客目的*/
	private String visitorPurpose;

	/**生成二维码的原因*/
	private String makeReason;

	/**生成时间*/
	private Timestamp makeTime;

	/**开始时间*/
	private Timestamp startTime;

	/**结束时间*/
	private Timestamp endTime;

	/**有效次数*/
	private Integer effecNumber;

	/**状态；0为无效，1为有效*/
	private Integer status;

	/**v3平台的codeid*/
	private Integer v3CodeId;

	/***/
	private Integer userId;

	public SvVisitorQrcode(){
	}

	public SvVisitorQrcode(Integer codeId){
		this.codeId = codeId;
	}

	public void setCodeId(Integer value) {
		this.codeId = value;
	}

	public Integer getCodeId() {
		return this.codeId;
	}
	public void setOwnerId(Integer value) {
		this.ownerId = value;
	}

	public Integer getOwnerId() {
		return this.ownerId;
	}
	public void setCodeData(byte[] value) {
		this.codeData = value;
	}

	public byte[] getCodeData() {
		return this.codeData;
	}
	public void setCodeType(Integer value) {
		this.codeType = value;
	}

	public Integer getCodeType() {
		return this.codeType;
	}
	public void setVisitorName(String value) {
		this.visitorName = value;
	}

	public String getVisitorName() {
		return this.visitorName;
	}
	public void setVisitorTelephone(String value) {
		this.visitorTelephone = value;
	}

	public String getVisitorTelephone() {
		return this.visitorTelephone;
	}
	public void setVisitorGender(Integer value) {
		this.visitorGender = value;
	}

	public Integer getVisitorGender() {
		return this.visitorGender;
	}
	public void setIsDrive(Integer value) {
		this.isDrive = value;
	}

	public Integer getIsDrive() {
		return this.isDrive;
	}
	public void setVisitorPurpose(String value) {
		this.visitorPurpose = value;
	}

	public String getVisitorPurpose() {
		return this.visitorPurpose;
	}
	public void setMakeReason(String value) {
		this.makeReason = value;
	}

	public String getMakeReason() {
		return this.makeReason;
	}

	public void setMakeTime(Timestamp value) {
		this.makeTime = value;
	}

	public Timestamp getMakeTime() {
		return this.makeTime;
	}

	public void setStartTime(Timestamp value) {
		this.startTime = value;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setEndTime(Timestamp value) {
		this.endTime = value;
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}
	public void setEffecNumber(Integer value) {
		this.effecNumber = value;
	}

	public Integer getEffecNumber() {
		return this.effecNumber;
	}
	public void setStatus(Integer value) {
		this.status = value;
	}

	public Integer getStatus() {
		return this.status;
	}
	public void setV3CodeId(Integer value) {
		this.v3CodeId = value;
	}

	public Integer getV3CodeId() {
		return this.v3CodeId;
	}
	public void setUserId(Integer value) {
		this.userId = value;
	}

	public Integer getUserId() {
		return this.userId;
	}



	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("CodeId",getCodeId())
			.append("OwnerId",getOwnerId())
			.append("CodeData",getCodeData())
			.append("CodeType",getCodeType())
			.append("VisitorName",getVisitorName())
			.append("VisitorTelephone",getVisitorTelephone())
			.append("VisitorGender",getVisitorGender())
			.append("IsDrive",getIsDrive())
			.append("VisitorPurpose",getVisitorPurpose())
			.append("MakeReason",getMakeReason())
			.append("MakeTime",getMakeTime())
			.append("StartTime",getStartTime())
			.append("EndTime",getEndTime())
			.append("EffecNumber",getEffecNumber())
			.append("Status",getStatus())
			.append("V3CodeId",getV3CodeId())
			.append("UserId",getUserId())
			.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
			.append(getCodeId())
			.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof SvVisitorQrcode == false) return false;
		if(this == obj) return true;
		SvVisitorQrcode other = (SvVisitorQrcode)obj;
		return new EqualsBuilder()
			.append(getCodeId(),other.getCodeId())
			.isEquals();
	}
}

