package com.yuzhou.springbootmybatis.service;

import com.yuzhou.springbootmybatis.entity.Area;

import java.util.List;

public interface AreaService {
    /**
     * 获取全部数据
     *
     * @return 数据集合
     */
    List<Area> getAreaList();

    /**
     * 根据ID获取区域
     *
     * @param areaId 区域ID
     * @return
     */
    Area getAreaById(int areaId);

    /**
     * 新增一个区域
     *
     * @param area 新增对象
     * @return 是否新增成功
     */
    boolean addArea(Area area);

    /**
     * 修改区域
     *
     * @param area 修改对象
     * @return 是否修改成功
     */
    boolean modifyArea(Area area);

    /**
     * 根据ID删除一个区域
     *
     * @param areaId 区域ID
     * @return 是否删除成功
     */
    boolean deleteArea(int areaId);
}
