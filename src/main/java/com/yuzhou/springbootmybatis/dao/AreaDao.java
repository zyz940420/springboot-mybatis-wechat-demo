package com.yuzhou.springbootmybatis.dao;

import com.yuzhou.springbootmybatis.entity.Area;

import java.util.List;

public interface AreaDao {
    /**
     * 列出区域列表
     *
     * @return areaList
     */
    List<Area> queryArea();

    /**
     * 根据ID列出具体区域
     *
     * @param areaId
     * @return area
     */
    Area queryAreaById(int areaId);

    /**
     * 插入区域信息
     *
     * @param area
     * @return Integer
     */
    int insertArea(Area area);

    /**
     * 更新区域信息
     *
     * @param area
     * @return Integer
     */
    int updateArea(Area area);

    /**
     * 删除区域信息
     *
     * @param areaId
     * @return Integer
     */
    int deleteArea(int areaId);
}
