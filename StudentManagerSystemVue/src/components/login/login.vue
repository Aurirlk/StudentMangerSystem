<template>
  <div id="login" :style="note">
    <!-- <div class="star test"></div>
    <div class="star pink"></div>
    <div class="star blue"></div>
    <div class="star black"></div>
    <div class="star red"></div>
    <div class="star white"></div>
    <div class="star yellow"></div>
    <div class="star gray"></div>
    <div class="star orange"></div> -->
    <!-- <div class="title">
      <h2 style="color:white;">
        学生成绩管理系统
      </h2>
    </div> -->
    <div class="loginForm">
      <div style="text-align: center; padding: 7vw 0 0 0; font-size: 18px">
        <h2 style="color: white">学生成绩管理系统</h2>
      </div>
      <el-tabs
        type="border-card"
        v-model="tabName"
        @tab-click="tabClick"
        style="height: 440px"
      >
        <el-tab-pane label="学生" name="student">
          <Form class="flip" ref="student_tab"></Form>
        </el-tab-pane>
        <el-tab-pane label="教师" name="teacher">
          <Form ref="teacher_tab"></Form>
        </el-tab-pane>
        <el-tab-pane label="管理员" name="admin">
          <Form ref="admin_tab"></Form>
        </el-tab-pane>
      </el-tabs>
    </div>
  </div>
</template>

<script>
import Form from "./form";
import "../../common/css/star.css";

export default {
  data() {
    return {
      starClass: "star",
      starArr: "",
      keyLabel: "学生",
      tabName: "student",
      loading: false,
      note: {
        backgroundImage: "url(" + require("../../assets/home.jpg") + ")",
        backgroundRepeat: "no-repeat",
        backgroundSize: "100%",
      },
      starSty: "",
    };
  },
  methods: {
    tabClick(data) {
      // 点击当前tab时不翻转
      if (data.label !== this.keyLabel) {
        this.flip();
        this.keyLabel = data.label;
      }
      if (data.label === "学生") {
        this.$refs.student_tab.clearForm(2);
        this.$refs.student_tab.getCookies();
      } else if (data.label === "教师") {
        this.$refs.teacher_tab.clearForm(1);
        this.$refs.teacher_tab.getCookies();
      } else if (data.label === "管理员") {
        this.$refs.admin_tab.clearForm(0);
        this.$refs.admin_tab.getCookies();
      }
    },
    flip() {
      let flip = document.querySelector(".el-tabs");
      flip.style.transition = "0.3s";
      // 翻转90度
      flip.style.transform = "rotateY(90deg)";
      setTimeout(() => {
        flip.style.transition = "0.2s";
        flip.style.transform = "rotateY(0)";
      }, 240);
    },
  },
  components: {
    Form,
  },
};
</script>
<style>
* {
  margin: 0;
  padding: 0;
}

html,
body,
#app,
.login {
  height: 100%;
}

#login {
  height: 100%;
  width: 100%;
  padding-left: 33%;
}
</style>
<style scoped>
.el-tabs {
  /*3d效果*/
  transform-style: preserve-3d;
  -webkit-perspective: 1000px;
  transition: 0.8s;
}

.loginForm {
  width: 400px;
  /* margin: 0 580px 0 580px; */
}
.title {
  padding: 10px 10px;
}
.oblique {
  background-color: #d5d5d5;
  transform: rotate(120deg);
  box-sizing: border-box;
}
</style>
