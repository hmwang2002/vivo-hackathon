<script setup>
import * as Cesium from 'cesium';
import {onMounted, reactive, ref, toRef} from "vue";
import MouseEvent from "../classes/MouseEvent.js";
import router from '../router/index';
import getLandScapes from "../hooks/getLandScapes.js";
import {useLandscapeStore} from "../store/landscape.js";

// 自己去cesium官网注册一个token就可以使用
Cesium.Ion.defaultAccessToken = ""
let viewer = null
const mouseEvent = reactive(new MouseEvent())
let list = ref([])
let msg_name = ref('Landscape Name')
const landscapeStore = useLandscapeStore();

onMounted(() => {
  viewer = new Cesium.Viewer('cesiumContainer', {
    animation: false,         //不显示轮盘
    baseLayerPicker: false,  //不显示工具栏
    selectionIndicator: false,//不显示选中指示器组件
    infoBox: false,           //不显示信息框
    timeline: false,          //不显示时间线控件
  });

  viewer._cesiumWidget._creditContainer.style.display = "none"; //去除版权信息

  viewer.scene.camera.setView({
    destination: Cesium.Cartesian3.fromDegrees(116.435314, 40.960521, 15000000.0),
  })

  mouseEvent.init(viewer);

  get();
  // add_test_label();

  viewer.screenSpaceEventHandler.setInputAction(function onLeftClick(movement) {
    var pickedObject = viewer.scene.pick(movement.position);
    if (pickedObject&&pickedObject.id) {
      console.log(pickedObject.id);
      //request 
      var city_name = pickedObject.id.label.text._value;
      console.log(pickedObject.id.label.show);
      pickedObject.id.label.show = pickedObject.id.label.show == false;
      //pickedObject.id.label.show = true;
      console.log(city_name);
      get_info(city_name);
    }
  }, Cesium.ScreenSpaceEventType.LEFT_CLICK);

})

const get = async () => {
  await getLandScapes().getLandscapes().then((res) => {
    list.value = JSON.parse(JSON.stringify(res))
  })
  add_labels();
}

const getDetail = async (name) => {
  msg_name.value = name;
  console.log(msg_name)
  await getLandScapes().getLandscapeByName(name).then((res) => {
    list.value = JSON.parse(JSON.stringify(res))
    console.log(list.value)
    landscapeStore.name = list.value.destName;
    landscapeStore.realCity = list.value.realCity;
    landscapeStore.summary = list.value.summaryDescription;
    // 正则表达式以分号为分隔符
    list.value.photos = list.value.photos.split(';');
    landscapeStore.photo = list.value.photos[0];
  })

}

function add_labels() {
  //request
  //for each city use add_label()
  for (let i = 0; i < list.value.length; i++) {
    add_label(list.value[i].lng, list.value[i].lat, list.value[i].destName)
  }

}

function get_info(city_name) {
  //request
  getDetail(city_name);
  //show info in l_sidebar

}

function add_test_label() {
  var entity = viewer.entities.add({
    position: Cesium.Cartesian3.fromDegrees(-74.0, 50.0, 10)
  });

  var label = new Cesium.LabelGraphics({
    text: "test label",
    fillColor: Cesium.Color.RED,
    distanceDisplayCondition: new Cesium.DistanceDisplayCondition(0, 1000000),
  })
  entity.label = label;    
  viewer.zoomTo(entity);
}


function add_label(longitude, latitude, name) {
  var entity = viewer.entities.add({
    position: Cesium.Cartesian3.fromDegrees(longitude, latitude, 10)
  });

  var label = new Cesium.LabelGraphics({
    text: name,
    fillColor: Cesium.Color.RED,
    show: false,
    distanceDisplayCondition: new Cesium.DistanceDisplayCondition(0, 1000000)
  })

  var point = new Cesium.PointGraphics({
    color: Cesium.Color.RED,
    pixelSize: 4
  })
  entity.label = label;
  entity.point = point;
}

function getPosition() {
  let pos = mouseEvent.getClickPosition();
  // 解析pos:proxy
  if (pos){
    pos = JSON.parse(JSON.stringify(pos));
    var pCartesian3 = Cesium.Cartesian3.fromRadians(pos.x,pos.y,pos.z);
    console.log(pCartesian3);
    var cartographic = Cesium.Cartographic.fromCartesian(pCartesian3);
    //console.log(cartographic);
    var longitude = cartographic.longitude;
    var latitude = cartographic.latitude;
    console.log(longitude,latitude);
  }
}

function goDetails() {
  if (msg_name.value == 'Landscape Name') {
    return;
  }
  router.push('./details')
}

</script>

<template>
  <el-card class="detail_card">
      <div class="card_header" >
        <span>{{ msg_name }}</span>
        <el-button class="button" text @click="goDetails">Show Details</el-button>
      </div>
  </el-card>
  <div id="cesiumContainer" @click="getPosition"></div>
</template>

<style scoped>

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: 'Poppins', sans-serif;
}

.common-layout {
  position: absolute;
  background-color: #F2EDE7;
  top: 0px;
  left: 0px;
  right: 0px;
  bottom: 0px;
}

.detail_card {
  z-index: 99;
  position: fixed;
  background-color: #DFD6C7;
  border: #444945;
  top: 10px;
  left: 10px;
  height: 75px;
  width: 400px;
  border-radius: 10px;
}

.card_header {
  border: #444945;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

#cesiumContainer {
  position: absolute;
  top: 5px;
  left: 5px;
  right: 5px;
  bottom: 10px;
}

.testot {
  font-family: farnhamdisplay-boldregular, sans-serif;
  font-size: 22px;
  line-height: 1.4;
  font-weight: 500px;
  text-align: center;
  color: #444945;
  padding-top: 10px;
}

</style>
