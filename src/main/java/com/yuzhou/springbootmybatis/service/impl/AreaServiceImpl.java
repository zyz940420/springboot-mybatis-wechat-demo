package com.yuzhou.springbootmybatis.service.impl;

import com.yuzhou.springbootmybatis.dao.AreaDao;
import com.yuzhou.springbootmybatis.entity.Area;
import com.yuzhou.springbootmybatis.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }

    @Override
    public Area getAreaById(int areaId) {
//        int a = 1 / 0;
        return areaDao.queryAreaById(areaId);
    }

    @Override
    @Transactional/*(rollbackFor = Exception.class)*/
    public boolean addArea(Area area) {
        if (!StringUtils.isEmpty(area.getAreaName())) {
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try {
                int effectNum = areaDao.insertArea(area);
                if (effectNum == 1) {
                    return true;
                } else {
                    throw new RuntimeException("插入区域信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入区域信息异常：" + e.getMessage());
            }
        } else {
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Override
    @Transactional
    public boolean modifyArea(Area area) {
        if (!Objects.isNull(area.getAreaId()) && area.getAreaId() > 0) {
            area.setLastEditTime(new Date());
            try {
                int effectedNum = areaDao.updateArea(area);
                if (effectedNum == 1) {
                    return true;
                } else {
                    throw new RuntimeException("区域信息更新失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("区域信息更新异常：" + e.getMessage());
            }
        } else {
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Override
    @Transactional
    public boolean deleteArea(int areaId) {
        if (areaId > 0) {
            try {
                int effectedNum = areaDao.deleteArea(areaId);
                if (effectedNum == 1) {
                    return true;
                } else {
                    throw new RuntimeException("区域信息删除失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("区域信息删除异常：" + e.getMessage());
            }
        } else {
            throw new RuntimeException("区域ID不能为0！");
        }
    }
}
