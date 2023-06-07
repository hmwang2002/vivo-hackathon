package com.example.demo.controller;

import com.example.demo.entity.ScenerySpot;
import com.example.demo.entity.SimpleSpot;
import com.example.demo.service.ScenerySpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * (ScenerySpot)表控制层
 *
 * @author makejava
 * @since 2023-05-21 13:42:21
 */
@RestController
@RequestMapping("scenerySpot")
public class ScenerySpotController {
    /**
     * 服务对象
     */
    @Autowired
    private ScenerySpotService scenerySpotService;


    /**
     * 通过经纬度查询单条数据
     *
     * @param lat 纬度
     * @param lng 经度
     * @return 单条数据
     */
    @RequestMapping("/queryByLoc")
    @ResponseBody
    @CrossOrigin
    public ResponseEntity<ScenerySpot> queryById(@RequestParam("lat") Double lat,@RequestParam("lng") Double lng) {
        return ResponseEntity.ok(this.scenerySpotService.queryById(lat, lng));
    }

    /**
     * 通过景点名称查询单条数据
     *
     * @param name 景点名称
     * @return 单条数据
     */
    @RequestMapping("/queryByName")
    @ResponseBody
    @CrossOrigin
    public ResponseEntity<ScenerySpot> queryByName(@RequestParam("name")String name) {
        return ResponseEntity.ok(this.scenerySpotService.queryByName(name));
    }

    /**
     *
     * @return 所有数据的名称和经纬度
     */
    @RequestMapping("/queryNameAndLocation")
    @ResponseBody
    @CrossOrigin
    public ResponseEntity<List<SimpleSpot>> queryNameAndLocation(){
        return ResponseEntity.ok(this.scenerySpotService.queryNameAndLocation());
    }


    @RequestMapping("/add")
    @ResponseBody
    @CrossOrigin
    public void add(String name,Double lat,Double lng,String summary){
        ScenerySpot scenerySpot = new ScenerySpot();
        scenerySpot.setLat(lat);
        scenerySpot.setLng(lng);
        scenerySpot.setDestName(name);
        scenerySpot.setSummaryDescription(summary);
        this.scenerySpotService.add(scenerySpot);
    }
}

