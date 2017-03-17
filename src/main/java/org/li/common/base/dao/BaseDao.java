package org.li.common.base.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.li.common.base.bean.BaseEntity;
import org.li.common.base.page.PageInfo;
import org.li.common.base.page.PagerControl;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * delete(T pk), (M entity), getEntityById(T pk)添加了缓存操作；
 * 其他需要操作缓存的方法，在具体实现中重写
 * @param <T>
 * @param <M>
 */
public abstract class BaseDao<T extends Serializable, M extends BaseEntity> extends SqlSessionDaoSupport implements IDao<T, M> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static final String insertSelective = ".insertSelective";
    public static final String updateSelective = ".updateByPrimaryKeySelective";
    public static final String selectByPrimaryKey = ".selectByPrimaryKey";
    public static final String selectByPrimaryKeys = ".selectByPrimaryKeys";
    public static final String getListByEntityAndPageInfo = ".getListByEntityAndPageInfo";
    public static final String getTotalByEntity = ".getTotalByEntity";
    public static final String deleteByPrimaryKey = ".deleteByPrimaryKey";
    public static final String deleteByEntity = ".deleteByEntity";

    private Class<M> curClassType = null;

    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public SqlSession getSqlSession() {
        return super.getSqlSession();
    }

    public String getMapperNameSpace() {
        return getClass().getName();
    }


    public BaseDao() {
        if (getClass().getGenericSuperclass() instanceof ParameterizedType) {
            curClassType = (Class<M>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        }
    }


    /**
     * SQL参数包装
     * @param entity
     * @param pageInfo
     * @param whereSql
     * @param orderBySql
     * @return
     */
    private Map<String, Object> getMapParams(M entity, PageInfo pageInfo, String whereSql, String orderBySql) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (null != entity) {
            map.put("entity", entity);
        }
        if (null != pageInfo) {
            map.put("pageInfo", pageInfo);
        }
        if (null != whereSql) {
            map.put("whereSql", whereSql);
        }
        if (null != orderBySql) {
            map.put("orderBy", orderBySql);
        }
        return map;
    }

    public int insert(M entity) {
        return this.getSqlSession().insert(this.getMapperNameSpace() + ".insertSelective", entity);
    }

    public int update(M entity) {

        Object ret = this.getSqlSession().update(this.getMapperNameSpace() + ".updateByPrimaryKeySelective", entity);

        return ((Integer) ret).intValue();
    }

    /**
     * 如果有缓存，则先删除缓存
     * @param pk
     * @return
     */
    public int delete(T pk) {
        Object e = this.getSqlSession().delete(this.getMapperNameSpace() + ".deleteByPrimaryKey", pk);
        return ((Integer) e).intValue();
    }

    public int deleteByEntity(M entity) {
        Object e = this.getSqlSession().delete(this.getMapperNameSpace() + ".deleteByEntity", entity);
        return ((Integer) e).intValue();
    }

    public M getEntityById(T pk) {
        M returnObj = this.getSqlSession().selectOne(this.getMapperNameSpace() + ".selectByPrimaryKey", pk);
        return returnObj;
    }

    public M getEntityByObj(M entity) {
        return (M) this.getSqlSession().selectOne(this.getMapperNameSpace() + ".getListByEntityAndPageInfo", this.getMapParams(entity, (PageInfo) null, null, (String) null));
    }

    public M getEntityByObj(M entity, String where) {
        return (M) this.getSqlSession().selectOne(this.getMapperNameSpace() + ".getListByEntityAndPageInfo", this.getMapParams(entity, (PageInfo) null, where, (String) null));
    }


    public int getCountByObj(M entity) {
        Object e = this.getSqlSession().selectOne(this.getMapperNameSpace() + ".getTotalByEntity", this.getMapParams(entity, (PageInfo) null, null, (String) null));
        return ((Integer) e).intValue();
    }

    /**
     *
     * @param entity
     * @param where
     * @return
     */
    public int getCountByObj(M entity, String where) {
        Object e = this.getSqlSession().selectOne(this.getMapperNameSpace() + ".getTotalByEntity", this.getMapParams(entity, (PageInfo) null, where, (String) null));
        return ((Integer) e).intValue();
    }

    /**
     * @param entity
     * @param pageInfo
     * @param whereSql
     * @return
     */
    public PagerControl<M> getPagerByObj(M entity, PageInfo pageInfo, String whereSql) {
        return getPagerByObj(entity, pageInfo, whereSql, null);
    }

    /**
     *
     * @param entity
     * @param pageInfo
     * @param whereSql
     * @param orderBySql
     * @return
     */
    public PagerControl<M> getPagerByObj(M entity, PageInfo pageInfo, String whereSql, String orderBySql) {
        PagerControl pagerControl = new PagerControl();
        Object list = new ArrayList();
        boolean total = false;

        int total1 = this.getCountByObj(entity, whereSql);
        if (total1 > 0) {
            list = this.getListByObj(entity, pageInfo, whereSql, orderBySql);
        }
        if(null!=pageInfo){
            pageInfo.setTotalCounts(total1);
        }
        if (list != null) {
            pagerControl.setEntityList((List) list);
        }

        pagerControl.setPageInfo(pageInfo);
        return pagerControl;
    }


    public List<M> getAllEntityObj() {
        return this.getListByObj((M) null, (String) null);
    }

    /**
     *
     * @param entity
     * @return
     */
    public List<M> getListByObj(M entity) {
        return this.getListByObj(entity, (PageInfo) null, (String) null, (String) null, false);
    }

    public List<M> getListByObj(M entity, boolean isMainDS) {
        return this.getListByObj(entity, (PageInfo) null, (String) null, (String) null, isMainDS);
    }

    /**
     *
     * @param entity
     * @param whereSql
     * @return
     */
    public List<M> getListByObj(M entity, String whereSql) {
        return this.getListByObj(entity, (PageInfo) null, whereSql, (String) null, false);
    }

    /**
     *
     * @param entity
     * @param pageInfo
     * @param whereSql
     * @return
     */
    public List<M> getListByObj(M entity, PageInfo pageInfo, String whereSql) {
        return this.getListByObj(entity, pageInfo, whereSql, (String) null, false);
    }

    /**
     *
     * @param entity
     * @param pageInfo
     * @param whereSql
     * @param orderBySql
     * @return
     */
    public List<M> getListByObj(M entity, PageInfo pageInfo, String whereSql, String orderBySql) {
        return this.getListByObj(entity, pageInfo, whereSql, orderBySql, false);
    }

    /**
     *
     * @param entity
     * @param pageInfo
     * @param whereSql
     * @param orderBySql
     * @param isMainDS      是否主库标志，不使用
     * @return
     */
    public List<M> getListByObj(M entity, PageInfo pageInfo, String whereSql, String orderBySql, boolean isMainDS) {
        return this.getSqlSession().selectList(this.getMapperNameSpace() + ".getListByEntityAndPageInfo", this.getMapParams(entity, pageInfo, whereSql, orderBySql));
    }
}
