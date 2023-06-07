<script setup>
import {useLandscapeStore} from "../store/landscape.js";

const landscapeStore = useLandscapeStore();
console.log(localStorage.photo)
const url = "https://img1.qunarzz.com/travel/poi/1712/cd/6546b7c141f45d37.jpg";
</script>

<template>
  <div class="full_page">
    <header id="header" class="dark_grey">
      <div style="position: relative; z-index:5">
        <p class="main_title" style="border-top-width:14px;	border-bottom-width:14px;">Wonder World</p>
        <p class="subtitle" style="color:#F2EDE7">~ find the beauty of our world ~</p>
        <p id="greca_ondina_2"></p>
        <p class="fonte" style="color:#DFD6C7; background:none; margin-top:7px;"><i>wonder world</i> developed during Vivo hackathon 2023-5</p>
      </div>
      <div style="position:relative; bottom:339px; z-index:0; text-align:center; opacity:.7"><img src=""></div>
    </header>
    <div>
      <el-container>
        <el-aside class="l_img_container">
          <el-image style="width: 600px; height: 600px; margin:45px 45px 45px 45px" :src="landscapeStore.photo" :fit="contain">

          </el-image>
        </el-aside>
        <el-main class="r_txt_container">
          <h2 class="title">
            Scenic Spots
          </h2>
          <el-card class="ctx_card">
            <p class="testot">
              景点名称:{{ landscapeStore.name }}
            </p>
            <p class="testot">
              景点位置:{{ landscapeStore.realCity }}
            </p>
            <p class="testo">
              景点介绍:{{ landscapeStore.summary }}
            </p>
          </el-card>

        </el-main>
      </el-container>
    </div>
  </div>
  

</template>

<style scoped>

.full_page {
  height: 100vh;
  overflow: scroll;
}

.dark_grey {
  background-color: #444945;
  padding: 20px 0 20px 0;
  border-radius: 10px;
}

.main_title {
  display: block;
  margin: auto auto;
  font-family: apercubold, sans-serif;
  font-weight: 600;
  text-align: center;
  width: 600px;
  padding: 40px 0px 14px 0px;
  color: #F2EDE7;
  text-transform: uppercase;
  font-size: 54px;
  border-top: solid;
  border-color: #F2EDE7;
  border-bottom: solid;
  letter-spacing: 7px;
}

.subtitle {
  text-align: center;
  font-family: apercubold, sans-serif;
  font-size: 18px;
  font-weight: 500;
  margin-top: 15px;
}

.fonte {
  font-family: farnhamdisplay-regularregular, sans-serif;
  color: #444945;
  font-size: 11px;
  font-style: italic;
  font-weight: 400;
  text-align: center;
  background-color: #9f9f9f;
  width: 330px;
  display: block;
  margin: auto auto;
  margin-top: -20px;
  padding-top: 3px;
  height: 20px;
}

.l_img_container {
  background-color: rgb(97, 103, 104);
  margin: 5px;
  top: 290px;
  left: 5px;
  width: 700px;
  height: 700px;
  border-radius: 10px;
}

.r_txt_container {
  background-color: #DFD6C7;
  margin: 5px;
  top: 290px;
  left: 710px;
  width: 928px;
  height: 700px;
  border-radius: 10px;
}

.title {
  display: block;
  margin: auto auto;
  text-align: center;
  font-family: apercubold, sans-serif;
  font-size: 31px;
  font-weight: 700px;
  text-transform: uppercase;
  width: 500px;
  padding: 10px 0 10px 0;
  border-color: rgb(97, 103, 104);
  border-top: solid;
  border-top-width: 7px;
  border-bottom: solid;
  border-bottom-width: 7px;
  margin-top: 25px;
  letter-spacing: 1.5px;
}

.ctx_card {
  background-color: #F2EDE7;
  margin-top: 45px;
  margin-left: 35px;
  margin-right: 35px;
  margin-bottom: 25px;
  height: 490px;
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

.testo {
  font-family: farnhamdisplay-boldregular, sans-serif;
  font-size: 18px;
  line-height: 1.4;
  font-weight: 500px;
  text-align: center;
  color: #444945;
  padding-top: 10px;
}
</style>