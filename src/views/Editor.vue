<template>
  <div>
    <nut-navbar
      style="background-color:#fff; height:30px;"
      :leftShow="true"
      :rightShow="false"
      @on-click-back="back"
    ></nut-navbar>
    <div class="edit">
      <textarea class="input" maxlength="500" placeholder="说点什么吧......" v-model="content"></textarea>
      <div class="tool">
        <input id="file" @change="uploadImage" name="smfile" type="file" />
        <label for="file">
          <svg class="icon" aria-hidden="true">
            <use xlink:href="#icon-shangchuan1" />
          </svg>
        </label>
        <button class="btn" @click="addPost">发布</button>
      </div>
      <div class="previewImg" v-show="isShow">
        <img :src="img" alt />
        <svg class="icon" aria-hidden="true" @click="switchActionSheet">
          <use xlink:href="#icon-Group-" />
        </svg>
      </div>
      <!-- <nut-progress :percentage="percentage"></nut-progress> -->
    </div>
    <nut-actionsheet
      :is-visible="isVisible"
      :chooseTagValue="`确定`"
      cancelTxt="取消"
      :menu-items="menuItems"
      @choose="chooseItem"
      @close="switchActionSheet"
    >
      <span slot="title">
        <label>确定删除吗？</label>
      </span>
    </nut-actionsheet>
  </div>
</template>

<script>
import Vue from "vue";
import { Navbar, Toast, ActionSheet } from "@nutui/nutui";
Navbar.install(Vue);
Toast.install(Vue);
ActionSheet.install(Vue);

export default {
  name: "editor",
  data() {
    return {
      img: null,
      content: "",
      isShow: false,
      name: "",
      isVisible: false,
      imgUrl: "",
      menuItems: [
        {
          name: "确定"
        }
      ],
      percentage: 0,
      acceptType: ["image/jpeg", "image/png", "image/gif", "image/bmp"]
    };
  },
  components: {
    [Navbar.name]: Navbar,
    [Toast.name]: Toast,
    [ActionSheet.name]: ActionSheet
  },
  methods: {
    back() {
      this.$router.go(-1);
    },
    switchActionSheet() {
      this.isVisible = !this.isVisible;
    },
    chooseItem(itemParams) {
      if (itemParams.name == "确定") {
        this.isShow = !this.isShow;
      }
    },
    addPost() {
      this.$api
        .addPost({
          content: this.content,
          img_url: this.imgUrl
        })
        .then(res => {
          console.log(res);
        })
        .catch(err => {
          console.log(err);
        });
    },
    previewImg(file) {
      let ctx = this;
      let reader = new FileReader();

      if (this.acceptType.indexOf(file.type) == -1) {
        this.$toast.text("暂时不支持该格式文件上传");
        return;
      }
      if (!file || !window.FileReader) return;

      reader.readAsDataURL(file);
      reader.onloadend = function() {
        ctx.img = this.result;
        ctx.isShow = true;
      };
    },
    uploadImage(val) {
      let file = val.target.files[0];
      let formData = new FormData();

      formData.append("smfile", file);
      this.previewImg(file);
      this.$api
        .uploadImage(formData)
        .then(res => {
          console.log(res.data);
          this.imgUrl = res.data.data.url;
        })
        .catch(err => {
          this.$toast.text("上传失败");
          throw new Error(err);
        });
    }
  }
};
</script>

<style lang="scss" scoped>
.edit {
  padding: 10px;
  margin-top: 10px;
}
.input {
  line-height: 1.5;
  vertical-align: bottom;
  box-sizing: border-box;
  margin: 0;
  padding: 0;
  width: 100%;
  height: 150px;
  padding: 4px 11px;
  color: rgba(0, 0, 0, 0.65);
  font-size: 14px;
  line-height: 1.5;
  background-color: #fff;
  border: 1px solid #d9d9d9;
  border-radius: 4px;
  outline: none;
}
.previewImg {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 10px;
  border: 1px dotted #d9d9d9;
  border-radius: 5px;
  & > img {
    height: 80px;
    width: 80px;
    border-radius: 5px;
  }
}

.btn {
  height: auto;
  width: 50px;
  padding: 5px 10px;
  border-radius: 50px;
  background: #eee;
  border: none;
  color: rgba(0, 0, 0, 0.65);
}

.tool {
  margin: 10px 0 20px 0;
  display: flex;
  justify-content: space-between;
  & > input {
    opacity: 0;
    width: 0;
    height: 0;
    position: absolute;
  }
}
</style>