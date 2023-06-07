<template>
  <section @click="gotoPage">
    <h3>Wonder World</h3>
    <h4>~ find the beauty of our world ~</h4>
    <h5>click anywhere to start</h5>
    <div class="set">
      <div><img src="../assets/leaves/leaves1.png"></div>
      <div><img src="../assets/leaves/leaves2.png"></div>
      <div><img src="../assets/leaves/leaves3.png"></div>
      <div><img src="../assets/leaves/leaves4.png"></div>
      <div><img src="../assets/leaves/leaves1.png"></div>
      <div><img src="../assets/leaves/leaves2.png"></div>
      <div><img src="../assets/leaves/leaves3.png"></div>
      <div><img src="../assets/leaves/leaves4.png"></div>
    </div>

    <div class="set set2">
      <div><img src="../assets/leaves/leaves1.png"></div>
      <div><img src="../assets/leaves/leaves2.png"></div>
      <div><img src="../assets/leaves/leaves3.png"></div>
      <div><img src="../assets/leaves/leaves4.png"></div>
      <div><img src="../assets/leaves/leaves1.png"></div>
      <div><img src="../assets/leaves/leaves2.png"></div>
      <div><img src="../assets/leaves/leaves3.png"></div>
      <div><img src="../assets/leaves/leaves4.png"></div>
    </div>

    <div class="set set3">
      <div><img src="../assets/leaves/leaves1.png"></div>
      <div><img src="../assets/leaves/leaves2.png"></div>
      <div><img src="../assets/leaves/leaves3.png"></div>
      <div><img src="../assets/leaves/leaves4.png"></div>
      <div><img src="../assets/leaves/leaves1.png"></div>
      <div><img src="../assets/leaves/leaves2.png"></div>
      <div><img src="../assets/leaves/leaves3.png"></div>
      <div><img src="../assets/leaves/leaves4.png"></div>
    </div>
  </section>
</template>

<script>
import router from '../router/index';

export default {
  methods: {
    gotoPage() {
      router.push('/main')
    }
  },
  name: "start"
}
</script>

<style lang="less" scoped>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: 'Poppins', sans-serif;
}

section {
  position: relative;
  width: 100%;
  height: 100vh;
  overflow: hidden;
  display: flex;
  justify-content: center;
  align-items: center;
  background-image: url("../background.jpg");
  background-size: cover;
}

/* 2.修改标题文字样式 */
section h3 {
  color: #fff;
  font-size: 6em;
  text-transform: uppercase;
  position: absolute;
  top: 40%;
  z-index: 99;
}

section h4 {
  color: #fff;
  font-size: 1.5em;
  text-transform: uppercase;
  position: absolute;
  top: 55%;
  z-index: 99;
}

section h5 {
  color: #0c0c0c;
  font-size: 1em;
  text-transform: uppercase;
  position: absolute;
  top: 95%;
  z-index: 99;
}

/* 3.设置枫叶盒子的基本样式 */

section .set {
  position: absolute;
  width: 100%;
  height: 100%;
  top: 0;
  left: 0;
  pointer-events: none;
}

/* 4.对第二个枫叶盒子单独设置样式 */

.set2 {
  transform: scale(2) rotateY(180deg);
  filter: blur(2px);
}

/* 5.对第三个枫叶盒子单独设置样式 */

.set3 {
  transform: scale(0.8) rotateX(180deg);
  filter: blur(4px);
}

/* 6.对枫叶图片外侧盒子做样式 */

section .set div {
  position: absolute;
  display: block;
}

/* 7.对每一个单独的枫叶盒子做动画和样式修改 */
section .set div:nth-child(1) {
  left: 20%;
  animation: animate 15s linear infinite;
  animation-delay: -7s;
}

section .set div:nth-child(2) {
  left: 50%;
  animation: animate 20s linear infinite;
  animation-delay: -5s;
}

section .set div:nth-child(3) {
  left: 70%;
  animation: animate 20s linear infinite;
  animation-delay: 0s;
}

section .set div:nth-child(4) {
  left: 0;
  animation: animate 15s linear infinite;
  animation-delay: -5s;
}

section .set div:nth-child(5) {
  left: 85%;
  animation: animate 18s linear infinite;
  animation-delay: -10s;
}

section .set div:nth-child(6) {
  left: 0;
  animation: animate 12s linear infinite;
  animation-delay: 0s;
}

section .set div:nth-child(7) {
  left: 15%;
  animation: animate 14s linear infinite;
  animation-delay: 0s;
}

section .set div:nth-child(8) {
  left: 90%;
  animation: animate 18s linear infinite;
  animation-delay: -1s;
}
/* 这里面修改的数值不用纠结，只是为了达到效果，其实不用严格按照我这个数来 */

/* 8.定义动画 */

@keyframes animate {
  0% {
    opacity: 0;
    top: -10%;
    transform: translateX(20px) rotate(0deg);
  }
  10% {
    opacity: 1;
  }
  20% {
    transform: translateX(-20px) rotate(45deg);
  }
  40% {
    transform: translateX(-20px) rotate(90deg);
  }
  60% {
    transform: translateX(20px) rotate(180deg);
  }
  80% {
    transform: translateX(-20px) rotate(180deg);
  }
  100% {
    top: 110%;
    transform: translateX(-20px) rotate(226deg);
  }
}


</style>