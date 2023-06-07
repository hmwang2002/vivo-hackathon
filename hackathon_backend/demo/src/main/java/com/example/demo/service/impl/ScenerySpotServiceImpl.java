package com.example.demo.service.impl;

import com.example.demo.entity.ScenerySpot;
import com.example.demo.dao.ScenerySpotDao;
import com.example.demo.entity.SimpleSpot;
import com.example.demo.service.ScenerySpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * (ScenerySpot)表服务实现类
 *
 * @author makejava
 * @since 2023-05-21 13:42:24
 */
@Service
public class ScenerySpotServiceImpl implements ScenerySpotService{
    @Autowired
    private ScenerySpotDao scenerySpotDao;

    /**
     * 通过经纬度查询单条数据
     *
     * @param lat 经度
     * @param lng 纬度
     * @return 实例对象
     */
    @Override
    public ScenerySpot queryById(Double lat,Double lng) {
        Double latMin = Double.valueOf(String.format("%.2f", lat));
        Double lngMin = Double.valueOf(String.format("%.2f", lng));
        Double latMax = latMin+0.1;
        Double lngMax = lngMin+0.1;

        return this.scenerySpotDao.queryById(latMin,latMax,lngMin,lngMax);
    }

    @Override
    public ScenerySpot queryByName(String name){
        return this.scenerySpotDao.queryByName(name);
    }

    @Override
    public List<SimpleSpot> queryNameAndLocation(){
        return this.scenerySpotDao.queryNameAndLocation();
    }
    @Override
    public void add(ScenerySpot scenerySpot){
        this.scenerySpotDao.add(scenerySpot);
    }
}
