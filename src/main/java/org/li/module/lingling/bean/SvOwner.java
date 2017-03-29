package org.li.module.lingling.bean;

import org.li.common.base.bean.BaseEntity;

import java.sql.Timestamp;


/**
 * 业主信息表
 * @author liyanjun
 * @date 2017-3-20 10:52:44
 */
public class SvOwner extends BaseEntity {

	private static final long serialVersionUID = 1L;


	/**主键ID，自增*/
	private Integer ownerId;

	/**父ID*/
	private Integer parentId;

	/**注册码*/
	private String regcode;

	/**业主名字*/
	private String ownerName;

	/**业主电话号码*/
	private String ownerTelephone;

	/***/
	private String weixinId;

	/**注册时间*/
	private Timestamp regTime;

	/**注册码有效时间*/
	private Integer regEffecDay;

	/**第一次登陆时间*/
	private Timestamp firstLoginTime;

	/**使用有效时间*/
	private Integer useEffecDay;

	/**有效状态，1为有效，0为无效*/
	private Integer status;

	/**关键小区主键ID*/
	private Integer residentialId;

	/**网络电话标识；以1开头为设备，以2开头为业主*/
	private String callId;

	/**voip的终端类型，关联sys_code*/
	private Integer terminalType;

	/**绑定手机*/
	private String note;

	/**lingLingId*/
	private String linglingId;

	/**是否有下发访客权限，1为有权限，0为没有权限，默认为1*/
	private Integer visitorAuthority;

	/**性别，1:男，2：女*/
	private Integer ownerGender;

	/**民族*/
	private String ownerRace;

	/**出生日期*/
	private Timestamp ownerBirthday;

	/**户籍地址*/
	private String ownerCensusAddr;

	/**身份证号*/
	private String ownerIdenNumber;

	/***/
	private Integer idenImgId;

	/**手机IMEI*/
	private String phoneImei;

	/**经度*/
	private Double longitude;

	/**纬度*/
	private Double latitude;

	/***/
	private String ownerPolice;

	/***/
	private String ownerActiveFrom;

	/***/
	private String ownerActiveTo;

	/**房号名*/
	private String roomNumber;

	/**
	 * 楼栋名
	 */
	private String residentialName;

	public SvOwner(){
	}

	public SvOwner(Integer ownerId){
		this.ownerId = ownerId;
	}

	public void setOwnerId(Integer value) {
		this.ownerId = value;
	}

	public Integer getOwnerId() {
		return this.ownerId;
	}
	public void setParentId(Integer value) {
		this.parentId = value;
	}

	public Integer getParentId() {
		return this.parentId;
	}
	public void setRegcode(String value) {
		this.regcode = value;
	}

	public String getRegcode() {
		return this.regcode;
	}
	public void setOwnerName(String value) {
		this.ownerName = value;
	}

	public String getOwnerName() {
		return this.ownerName;
	}
	public void setOwnerTelephone(String value) {
		this.ownerTelephone = value;
	}

	public String getOwnerTelephone() {
		return this.ownerTelephone;
	}
	public void setWeixinId(String value) {
		this.weixinId = value;
	}

	public String getWeixinId() {
		return this.weixinId;
	}

	public void setRegTime(Timestamp value) {
		this.regTime = value;
	}

	public Timestamp getRegTime() {
		return this.regTime;
	}
	public void setRegEffecDay(Integer value) {
		this.regEffecDay = value;
	}

	public Integer getRegEffecDay() {
		return this.regEffecDay;
	}

	public void setFirstLoginTime(Timestamp value) {
		this.firstLoginTime = value;
	}

	public Timestamp getFirstLoginTime() {
		return this.firstLoginTime;
	}
	public void setUseEffecDay(Integer value) {
		this.useEffecDay = value;
	}

	public Integer getUseEffecDay() {
		return this.useEffecDay;
	}
	public void setStatus(Integer value) {
		this.status = value;
	}

	public Integer getStatus() {
		return this.status;
	}
	public void setResidentialId(Integer value) {
		this.residentialId = value;
	}

	public Integer getResidentialId() {
		return this.residentialId;
	}
	public void setCallId(String value) {
		this.callId = value;
	}

	public String getCallId() {
		return this.callId;
	}
	public void setTerminalType(Integer value) {
		this.terminalType = value;
	}

	public Integer getTerminalType() {
		return this.terminalType;
	}
	public void setNote(String value) {
		this.note = value;
	}

	public String getNote() {
		return this.note;
	}
	public void setLinglingId(String value) {
		this.linglingId = value;
	}

	public String getLinglingId() {
		return this.linglingId;
	}
	public void setVisitorAuthority(Integer value) {
		this.visitorAuthority = value;
	}

	public Integer getVisitorAuthority() {
		return this.visitorAuthority;
	}
	public void setOwnerGender(Integer value) {
		this.ownerGender = value;
	}

	public Integer getOwnerGender() {
		return this.ownerGender;
	}
	public void setOwnerRace(String value) {
		this.ownerRace = value;
	}

	public String getOwnerRace() {
		return this.ownerRace;
	}

	public void setOwnerBirthday(Timestamp value) {
		this.ownerBirthday = value;
	}

	public Timestamp getOwnerBirthday() {
		return this.ownerBirthday;
	}
	public void setOwnerCensusAddr(String value) {
		this.ownerCensusAddr = value;
	}

	public String getOwnerCensusAddr() {
		return this.ownerCensusAddr;
	}
	public void setOwnerIdenNumber(String value) {
		this.ownerIdenNumber = value;
	}

	public String getOwnerIdenNumber() {
		return this.ownerIdenNumber;
	}
	public void setIdenImgId(Integer value) {
		this.idenImgId = value;
	}

	public Integer getIdenImgId() {
		return this.idenImgId;
	}
	public void setPhoneImei(String value) {
		this.phoneImei = value;
	}

	public String getPhoneImei() {
		return this.phoneImei;
	}
	public void setLongitude(Double value) {
		this.longitude = value;
	}

	public Double getLongitude() {
		return this.longitude;
	}
	public void setLatitude(Double value) {
		this.latitude = value;
	}

	public Double getLatitude() {
		return this.latitude;
	}
	public void setOwnerPolice(String value) {
		this.ownerPolice = value;
	}

	public String getOwnerPolice() {
		return this.ownerPolice;
	}
	public void setOwnerActiveFrom(String value) {
		this.ownerActiveFrom = value;
	}

	public String getOwnerActiveFrom() {
		return this.ownerActiveFrom;
	}
	public void setOwnerActiveTo(String value) {
		this.ownerActiveTo = value;
	}

	public String getOwnerActiveTo() {
		return this.ownerActiveTo;
	}

	public String getResidentialName() {
		return residentialName;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
}

