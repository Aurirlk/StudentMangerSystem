<!--
 * @Description: 
 * @Author: Rabbiter
 * @Date: 2023-05-18 12:19:02
-->
// 验证码模块
<template>
  <el-row>
    <el-col :span="12">
      <el-input v-model="inputText" placeholder="验证码"></el-input>
    </el-col>
    <el-col :span="12">
      <div
        class="ValidCode disabled-select"
        :style="`width:${width}; height:${height}`"
        @click="refreshCode"
        style="border: 1px black solid;"
      >
        <span
          v-for="(item, index) in codeList"
          :key="index"
          :style="getStyle(item)"
          >{{ item.code }}</span
        >
      </div>
    </el-col>
  </el-row>
</template>

<script>
export default {
  props: {
    width: {
      type: String,
      default: "100px",
    },
    height: {
      type: String,
      default: "40px",
    },
    length: {
      type: Number,
      default: 4,
    },
  },
  data() {
    return {
      codeList: [],
      inputText: "",
    };
  },
  mounted() {
    this.createdCode();
  },
  methods: {
    check() {
        // 检查验证码是否正确
        var realCode = "";
        for(var i = 0; i < this.codeList.length; ++i) {
            realCode += this.codeList[i].code;
        }
        return realCode.toLowerCase() == this.inputText.toLowerCase();
    },
    refreshCode() {
        // 刷新验证码
      this.createdCode();
    },
    createdCode() {
      const len = this.length;
      const codeList = [];
      const chars = "ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz0123456789";
      const charsLen = chars.length;
      // 生成
      for (let i = 0; i < len; i++) {
        const rgb = [
          Math.round(Math.random() * 220),
          Math.round(Math.random() * 240),
          Math.round(Math.random() * 200),
        ];
        codeList.push({
          code: chars.charAt(Math.floor(Math.random() * charsLen)),
          color: `rgb(${rgb})`,
          fontSize: `1${[Math.floor(Math.random() * 10)]}px`,
          padding: `${[Math.floor(Math.random() * 10)]}px`,
          transform: `rotate(${
            Math.floor(Math.random() * 90) - Math.floor(Math.random() * 90)
          }deg)`,
        });
      }
      // 指向
      this.codeList = codeList;
      // 将当前数据派发出去
      this.$emit("update:value", codeList.map((item) => item.code).join(""));
    },
    getStyle(data) {
      return `color: ${data.color}; font-size: ${data.fontSize}; padding: ${data.padding}; transform: ${data.transform}`;
    },
  },
};
</script>

<style scoped>
.ValidCode {
  display: flex;
  justify-content: center;
  align-items: center;
  cursor: pointer;
}
</style>