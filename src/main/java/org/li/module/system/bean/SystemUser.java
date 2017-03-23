package org.li.module.system.bean;

import org.li.common.base.bean.BaseEntity;
import org.li.common.util.DateUtil;
import org.li.module.lingling.bean.SvOwner;

import java.sql.Timestamp;


/**
 * @author liyanjun
 * @date 2017-3-20 10:39:37
 */
public class SystemUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 令令数据库中的用户ID
     */
    private Integer ownerId;

    /**
     * lingling_id
     */
    private String linglingId;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户姓名
     */
    private String username;

    /**
     * 性别1:男，2女
     */
    private Integer sex;

    /**
     * 民族
     */
    private String nation;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 身份证地址
     */
    private String creditAddress;

    /**
     * 身份证号
     */
    private String creditNo;

    /**
     * 身份证图片地址
     */
    private String creditImgUrl;

    /**
     * 大头照片图片地址
     */
    private String headImgUrl;

    /**
     * 小区内住址ID
     */
    private Integer addressId;

    /**
     * 小区内住址
     */
    private String address;

    /**
     * 二维码字符串
     */
    private String qrcodeKey;

    /**
     * 二维码有效时间，单位分钟，最大4095分钟
     */
    private Integer endTime;

    /***/
    private Timestamp qrcodeCreateTime;

    /**
     * 开始有效时间
     */
    private Timestamp beginDate;

    /**
     * 结束有效时间
     */
    private Timestamp endDate;

    /**
     * 记录创建时间
     */
    private Timestamp createTime;

    /**
     * 更新时间
     */
    private Timestamp updateTime;

    private Integer isDel = -1; // 已删除,1,-1

    public SystemUser() {
    }

    public SystemUser(String phone, String password) {
        this.phone = phone;
        this.password = password;
    }

    public SystemUser(Integer id) {
        this.id = id;
    }

    public void setId(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return this.id;
    }

    public void setPhone(String value) {
        this.phone = value;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setOwnerId(Integer value) {
        this.ownerId = value;
    }

    public Integer getOwnerId() {
        return this.ownerId;
    }

    public void setLinglingId(String value) {
        this.linglingId = value;
    }

    public String getLinglingId() {
        return this.linglingId;
    }

    public void setPassword(String value) {
        this.password = value;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUsername(String value) {
        this.username = value;
    }

    public String getUsername() {
        return this.username;
    }

    public void setSex(Integer value) {
        this.sex = value;
    }

    public Integer getSex() {
        return this.sex;
    }

    public void setNation(String value) {
        this.nation = value;
    }

    public String getNation() {
        return this.nation;
    }

    public void setBirthday(String value) {
        this.birthday = value;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public void setCreditAddress(String value) {
        this.creditAddress = value;
    }

    public String getCreditAddress() {
        return this.creditAddress;
    }

    public void setCreditNo(String value) {
        this.creditNo = value;
    }

    public String getCreditNo() {
        return this.creditNo;
    }

    public void setCreditImgUrl(String value) {
        this.creditImgUrl = value;
    }

    public String getCreditImgUrl() {
        return this.creditImgUrl;
    }

    public void setHeadImgUrl(String value) {
        this.headImgUrl = value;
    }

    public String getHeadImgUrl() {
        return this.headImgUrl;
    }

    public void setAddressId(Integer value) {
        this.addressId = value;
    }

    public Integer getAddressId() {
        return this.addressId;
    }

    public void setAddress(String value) {
        this.address = value;
    }

    public String getAddress() {
        return this.address;
    }

    public void setQrcodeKey(String value) {
        this.qrcodeKey = value;
    }

    public String getQrcodeKey() {
        return this.qrcodeKey;
    }

    public void setEndTime(Integer value) {
        this.endTime = value;
    }

    public Integer getEndTime() {
        return this.endTime;
    }

    public void setQrcodeCreateTime(Timestamp value) {
        this.qrcodeCreateTime = value;
    }

    public Timestamp getQrcodeCreateTime() {
        return this.qrcodeCreateTime;
    }

    public void setBeginDate(Timestamp value) {
        this.beginDate = value;
    }

    public Timestamp getBeginDate() {
        return this.beginDate;
    }

    public void setEndDate(Timestamp value) {
        this.endDate = value;
    }

    public Timestamp getEndDate() {
        return this.endDate;
    }

    public void setCreateTime(Timestamp value) {
        this.createTime = value;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public void setUpdateTime(Timestamp value) {
        this.updateTime = value;
    }

    public Timestamp getUpdateTime() {
        return this.updateTime;
    }

    public void setIsDel(Integer value) {
        this.isDel = value;
    }

    public Integer getIsDel() {
        return this.isDel;
    }

    public SystemUser setValue(SvOwner value) {
        //TODO 赋值
        this.phone = value.getOwnerTelephone();
        this.ownerId = value.getOwnerId();
        this.linglingId = value.getLinglingId();
        this.username = value.getOwnerName();
        this.sex = value.getOwnerGender();
        this.nation = value.getOwnerRace();
        this.birthday = DateUtil.getStr(value.getOwnerBirthday(),"yyyy-MM-dd");
        this.creditAddress = value.getOwnerCensusAddr();
        this.creditNo = value.getOwnerIdenNumber();
        this.addressId = value.getResidentialId();
        this.address = value.getResidentialName();

        return this;
    }
}

