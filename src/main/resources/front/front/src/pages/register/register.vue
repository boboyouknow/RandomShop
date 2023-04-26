<template>
  <div>
    <div class="container"
         :style='{"minHeight":"100vh","alignItems":"center","background":"url(http://codegen.caihongy.cn/20220722/2f46ada029f940ea97c168e76044ca4d.png)","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"center"}'>
      <el-form v-if="pageFlag=='register'"
               :style='{"padding":"20px","boxShadow":"0px 4px 10px 0px rgba(0,0,0,0.3020)","margin":"0","borderRadius":"10px","background":"#fff","width":"500px","height":"auto"}'
               ref="rgsForm" class="rgs-form" :model="rgsForm">
        <div v-if="true"
             :style='{"padding":"10px 20px","margin":"10px 0 20px 0","color":"#000","textAlign":"center","width":"100%","lineHeight":"44px","fontSize":"24px","fontWeight":"600"}'
             class="title">基于springboot的记帐系统注册
        </div>
        <button
            :style='{"border":"0","cursor":"pointer","padding":"0 10px","boxShadow":" 0px 4px 10px 0px rgba(0,0,0,0.3020)","margin":"20px auto 5px","color":"#000","display":"block","outline":"none","borderRadius":"80px","background":"linear-gradient(180deg, #DAE0FF 0%, #FFF8E3 100%)","width":"80%","fontSize":"18px","height":"44px"}'
            type="button" class="r-btn" @click="login()">注册
        </button>
        <div
            :style='{"cursor":"pointer","padding":"0 10%","margin":"20px 0","color":"rgba(159, 159, 159, 1)","textAlign":"center","display":"inline-block","width":"100%","lineHeight":"1","fontSize":"12px","textDecoration":"underline"}'
            class="r-login" @click="close()">已有账号，直接登录
        </div>
      </el-form>

    </div>
  </div>
</template>

<script>

export default {
  data() {
    return {
      ruleForm: {},

      pageFlag: '',
      tableName: "",
      rules: {},
    };
  },
  mounted() {
    this.pageFlag = this.$storage.get("pageFlag");
    let table = this.$storage.get("loginTable");
    this.tableName = table;
  },
  created() {

  },
  destroyed() {
  },
  methods: {
    // 获取uuid
    getUUID() {
      return new Date().getTime();
    },
    close() {
      this.$router.push({path: "/login"});
    },

    // 多级联动参数


    // 注册
    login() {
      var url = this.tableName + "/register";

      this.$http({
        url: url,
        method: "post",
        data: this.ruleForm
      }).then(({data}) => {
        if (data && data.code === 0) {
          this.$message({
            message: "注册成功",
            type: "success",
            duration: 1500,
            onClose: () => {
              this.$router.replace({path: "/login"});
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>

<style lang="scss" scoped>
.container {
  position: relative;
  background: url(http://codegen.caihongy.cn/20220722/2f46ada029f940ea97c168e76044ca4d.png);

  .el-date-editor.el-input {
    width: 100%;
  }

  .rgs-form .el-input /deep/ .el-input__inner {
    border: 0;
    border-radius: 20px;
    padding: 0 10px;
    box-shadow: 0px 4px 10px 0px rgba(0, 0, 0, 0.3020);
    outline: none;
    color: rgba(64, 158, 255, 1);
    width: 100%;
    font-size: 14px;
    height: 44px;
  }

  .rgs-form .el-select /deep/ .el-input__inner {
    border: 0;
    border-radius: 80px;
    padding: 0 10px;
    box-shadow: 0px 4px 10px 0px rgba(0, 0, 0, 0.3020);
    outline: none;
    color: #333;
    width: 368px;
    font-size: 14px;
    height: 44px;
  }

  .rgs-form .el-date-editor /deep/ .el-input__inner {
    border: 0;
    border-radius: 80px;
    padding: 0 10px 0 30px;
    box-shadow: 0px 4px 10px 0px rgba(0, 0, 0, 0.3020);
    outline: none;
    color: #333;
    width: 100%;
    font-size: 14px;
    height: 44px;
  }

  .rgs-form .el-date-editor /deep/ .el-input__inner {
    border: 0;
    border-radius: 80px;
    padding: 0 10px 0 30px;
    box-shadow: 0px 4px 10px 0px rgba(0, 0, 0, 0.3020);
    outline: none;
    color: #333;
    width: 100%;
    font-size: 14px;
    height: 44px;
  }

  .rgs-form /deep/ .el-upload--picture-card {
    background: transparent;
    border: 0;
    border-radius: 0;
    width: auto;
    height: auto;
    line-height: initial;
    vertical-align: middle;
  }

  .rgs-form /deep/ .upload .upload-img {
    border: 1px dashed rgba(0, 0, 0, 0.3020);
    cursor: pointer;
    border-radius: 8px;
    color: rgba(0, 0, 0, 0.3020);
    width: 100px;
    font-size: 32px;
    line-height: 100px;
    text-align: center;
    height: 100px;
  }

  .rgs-form /deep/ .el-upload-list .el-upload-list__item {
    border: 1px dashed rgba(0, 0, 0, 0.3020);
    cursor: pointer;
    border-radius: 8px;
    color: rgba(0, 0, 0, 0.3020);
    width: 100px;
    font-size: 32px;
    line-height: 100px;
    text-align: center;
    height: 100px;
  }

  .rgs-form /deep/ .el-upload .el-icon-plus {
    border: 1px dashed rgba(0, 0, 0, 0.3020);
    cursor: pointer;
    border-radius: 8px;
    color: rgba(0, 0, 0, 0.3020);
    width: 100px;
    font-size: 32px;
    line-height: 100px;
    text-align: center;
    height: 100px;
  }
}
</style>
