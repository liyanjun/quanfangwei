
package org.li.module.lingling.dao.impl;

import org.li.common.base.dao.LingLingBaseDao;
import org.li.module.lingling.bean.*;
import org.li.module.lingling.dao.SvOwnerDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 业主信息表
 * @author liyanjun
 * @date 2017-3-20 10:52:44
 */
@Repository
public class SvOwnerDaoImpl extends LingLingBaseDao<Integer, SvOwner> implements SvOwnerDao {

    @Override
    public SvOwner findLingLingUserInfo(String phone) {
        SvOwner returnObj = this.getSqlSession().selectOne(this.getMapperNameSpace() + ".findLingLingUserInfo", phone);
        return returnObj;
    }

    @Override
    public List<SvLingLingDevice> findUserDevices(Integer ownerId, Integer first, Integer count) {
        return this.getSqlSession().selectList(this.getMapperNameSpace() + ".findUserDevices", getParameter( ownerId,  first,  count));
    }

    @Override
    public List<SvVisitorQrcode> findVisitRecord(Integer ownerId, Integer codeId,Integer first, Integer count) {
        Map map = getParameter( ownerId,  first,  count);
        map.put("codeId",codeId);
        return this.getSqlSession().selectList(this.getMapperNameSpace() + ".findVisitRecord", map);
    }

    @Override
    public SysUser findLingLingManagerInfo(String phone) {
        // 使用手机号查出多个管理员，问题解决
        List<Object> list = this.getSqlSession().selectList(this.getMapperNameSpace() + ".findLingLingManagerInfo", phone);
        if(list.size() == 0) {
            return null;
        }
        SysUser returnObj = (SysUser) list.get(0);
        return returnObj;
    }

    @Override
    public List<SvOwner> findManagerUser(Integer userId, Integer first, Integer count) {
        return this.getSqlSession().selectList(this.getMapperNameSpace() + ".findManagerUser", getParameter( userId,  first,  count));
    }

    @Override
    public List<SvResidential> findManagerBuilding(Integer ownerId, Integer first, Integer count) {
        return this.getSqlSession().selectList(this.getMapperNameSpace() + ".findManagerBuilding", getParameter( ownerId,  first,  count));
    }

    @Override
    public List<SvLingLingDevice> findAllDevices() {
        return this.getSqlSession().selectList(this.getMapperNameSpace() + ".findAllDevices");
    }

    @Override
    public List<SvLingLingDevice> findAllDevices(Integer first, Integer count) {
        return this.getSqlSession().selectList(this.getMapperNameSpace() + ".findAllDevices",getParameter(null,first,count));
    }

    @Override
    public SvLingLingDevice findDevicesById(Integer devId) {
        return this.getSqlSession().selectOne(this.getMapperNameSpace() + ".findDeviceById",devId);
    }

    @Override
    public List<SvRoom> findManagerRoom(Integer residentialId, Integer first, Integer count) {
        Map map = getParameter( null,  first,  count);
        map.put("residentialId",residentialId);
        return this.getSqlSession().selectList(this.getMapperNameSpace() + ".findManagerRoom",map);
    }

    @Override
    public List<SvOwner> findLingLingUserInfoByName(Integer ownerId, String name, int first, int count) {
        Map map = getParameter( ownerId,  first,  count);
        map.put("name",name);
        return this.getSqlSession().selectList(this.getMapperNameSpace() + ".findManagerUserByName",map);
    }

    private Map getParameter(Integer ownerId, Integer first, Integer count){
        Map<String, Object> map = new HashMap<String, Object>();
        if (null != ownerId) {
            map.put("ownerId", ownerId);
        }
        if (null != first) {
            map.put("first", first);
        }
        if (null != count) {
            map.put("count", count);
        }
        return map;
    }

}
