package com.yuzhou.springbootmybatis.web;

import com.yuzhou.springbootmybatis.entity.Area;
import com.yuzhou.springbootmybatis.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/superAdmin")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "listArea", method = RequestMethod.GET)
    private Map<String, Object> listArea() {
        Map<String, Object> modelMap = new HashMap<>();
        List<Area> areaList = areaService.getAreaList();
        modelMap.put("areaList", areaList);
        return modelMap;
    }

    @RequestMapping(value = "getAreaById", method = RequestMethod.GET)
    private Map<String, Object> getAreaById(Integer areaId) {
        Map<String, Object> modelMap = new HashMap<>();
        Area area = areaService.getAreaById(areaId);
        modelMap.put("area", area);
        return modelMap;
    }

    @RequestMapping(value = "addArea", method = RequestMethod.POST)
    private Map<String, Object> addArea(@RequestBody Area area) {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("success", areaService.addArea(area));
        return modelMap;
    }

    @RequestMapping(value = "modifyArea", method = RequestMethod.POST)
    private Map<String, Object> modifyArea(@RequestBody Area area) {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("success", areaService.modifyArea(area));
        return modelMap;
    }

    @RequestMapping(value = "removeArea", method = RequestMethod.GET)
    private Map<String, Object> removeArea(Integer areaId) {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("success", areaService.deleteArea(areaId));
        return modelMap;
    }

}
