package com.example.demo;

import com.example.demo.dao.ScenerySpotDao;
import com.example.demo.entity.ScenerySpot;
import com.example.demo.entity.SimpleSpot;
import com.example.demo.service.ScenerySpotService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ScenerySpotServiceTest {

    @Autowired
    ScenerySpotService scenerySpotService;

    @Autowired
    ScenerySpotDao dao;


    @Test
    public void testQuerybyid(){
        ScenerySpot scenerySpot = new ScenerySpot();
        scenerySpot.setDestId(19532949);
        ScenerySpot sS1 = scenerySpotService.queryById(30.5811231335d,113.3422197537d);
        Assert.assertEquals(scenerySpot.getDestId(),sS1.getDestId());
    }

    @Test
    public void testQuerybyName(){
        ScenerySpot scenerySpot = new ScenerySpot();
        scenerySpot.setDestName("一品画廊");
        scenerySpot.setLat(30.5811231335d);
        ScenerySpot sS1 = scenerySpotService.queryByName("一品画廊");
        Assert.assertEquals(scenerySpot.getLat(),sS1.getLat());

    }

    @Test
    public void testQueryAll(){
        List<SimpleSpot> simpleSpot = scenerySpotService.queryNameAndLocation();
        Assert.assertEquals(1011,simpleSpot.size());
    }

    @Test
    public void testAdd(){
        ScenerySpot scenerySpot = new ScenerySpot();
        scenerySpot.setDestName("巨石阵");
        scenerySpot.setLat(51.17889d);
        scenerySpot.setLng(-1.82649);
        scenerySpot.setPhotos("http://kiyotakawang.oss-cn-hangzhou.aliyuncs.com/img/stonehenge.jpg");
        scenerySpot.setSummaryDescription("英国伦敦西南100多千米的索巨石阵，又称索尔兹伯里石环、环状列石、太阳神庙、史前石桌、斯通亨治石栏、斯托肯立石圈等名，是欧洲著名的史前时代文化神庙遗址，位于英格兰威尔特郡索尔兹伯里平原，约建于公元前4000～2000年（2008年3月至4月，英国考古学家研究发现，巨石阵的比较准确的建造年代在公元前2300年左右）的索尔兹伯里平原上，一些巍峨巨石呈环形屹立在绿色的旷野间，这就是英伦三岛最著名、最神秘的史前遗迹—巨石阵。");
        scenerySpotService.add(scenerySpot);
        ScenerySpot sS1 = scenerySpotService.queryByName("巨石阵");
        Assert.assertEquals(sS1.getLat(),scenerySpot.getLat());
        Assert.assertEquals(sS1.getLng(),scenerySpot.getLng());

    }
}
