package org.li.common.base.dao;


import org.li.common.base.page.PageInfo;
import org.li.common.base.page.PagerControl;

import java.io.Serializable;
import java.util.List;

public interface IDao<T extends Serializable, M> {


    /**
     * 插入
     * @param bean
     * @return
     */
    int insert(M bean);

    /**
     * 删除，根据ID
     * @param id
     * @return
     */
    int delete(T id);

    /**
     * 删除，根据对象
     * @param bean
     * @return
     */
    int deleteByEntity(M bean);

    /**
     * 更新
     * @param bean
     * @return
     */
    int update(M bean);

    /**
     * 根据ID获取对象
     * @param id
     * @return
     */
    M getEntityById(T id);

    /**
     * 根据对象参数查询对象
     * @param bean
     * @return
     */
    M getEntityByObj(M bean);

    /**
     * 根据对象及额外条件查询
     * @param bean
     * @param where
     * @return
     */
    M getEntityByObj(M bean, String where);

    /**
     * 根据对象参数统计数量
     * @param bean
     * @return
     */
    int getCountByObj(M bean);

    /**
     * 根据对象参数及额外条件统计数量
     * @param bean
     * @param where
     * @return
     */
    int getCountByObj(M bean, String where);

    /**
     * 根据对象参数、分页参数及额外where条件查询
     * @param bean
     * @param pageInfo
     * @param where
     * @return
     */
    PagerControl<M> getPagerByObj(M bean, PageInfo pageInfo, String where);

    /**
     * 根据对象参数、分页参数、额外where条件查询及排序条件查询
     * @param bean
     * @param pageInfo
     * @param where
     * @return
     */
    PagerControl<M> getPagerByObj(M bean, PageInfo pageInfo, String where, String order);

    /**
     * 查询全部数据
     * @return
     */
    List<M> getAllEntityObj();

    /**
     * 根据对象参数查询列表
     * @param bean
     * @return
     */
    List<M> getListByObj(M bean);

    /**
     *
     * @param bean
     * @param where
     * @return
     */
    List<M> getListByObj(M bean, String where);


    List<M> getListByObj(M bean, PageInfo var2, String where);


    List<M> getListByObj(M bean, PageInfo pageInfo, String where, String order);


}
