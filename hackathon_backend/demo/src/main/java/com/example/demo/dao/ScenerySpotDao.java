package com.example.demo.dao;

import com.example.demo.entity.ScenerySpot;
import com.example.demo.entity.SimpleSpot;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (ScenerySpot)表数据库访问层
 *
 * @author makejava
 * @since 2023-05-21 13:42:23
 */
@Mapper
@Component
public interface ScenerySpotDao {

    ScenerySpot queryById(Double latMin,Double latMax,Double lngMin,Double lngMax);
    ScenerySpot queryByName(String name);
    List<SimpleSpot> queryNameAndLocation();

    void add(@Param("scenerySpot")ScenerySpot scenerySpot);
}

