package com.example.demo.service;

import com.example.demo.entity.ScenerySpot;
import com.example.demo.entity.SimpleSpot;


import java.util.List;

/**
 * (ScenerySpot)表服务接口
 *
 * @author makejava
 * @since 2023-05-21 13:42:24
 */
public interface ScenerySpotService {

    /**
     * 通过经纬度查询单条数据
     *
     * @param lat 纬度
     * @param lng 经度
     * @return 实例对象
     */
    ScenerySpot queryById(Double lat,Double lng);

    /**
     * 通过名称查询单条数据
     *
     * @param name 名称
     * @return 实例对象
     */
    ScenerySpot queryByName(String name);


    List<SimpleSpot> queryNameAndLocation();

    void add(ScenerySpot scenerySpot);
}
