<template>
  <div class="comment">
    <nut-actionsheet @close="showActionSheet" :isVisible="isVisible">
      <div slot="custom" class="custom-wrap">
        <div class="comment-input">
          <input v-model="comment" type="text" placeholder="请输入内容" style="outline: none;" />
          <span class="input-addon">
            <button class="btn" type="button" @click="addComment"></button>
          </span>
        </div>
        <nut-scroller :type="'vertical'" @pulldown="refresh" :isLoading="isLoading">
          <div slot="list" class="nut-vert-list-panel">
            <h3>评论 {{ count }}</h3>
            <div class="single-comment" v-for="(item, index) in comments" :key="index">
              <img :src="item.user.avatar_url" />
              <div class="content">
                <div class="nickname">{{ item.user.nickname }}</div>
                <div>{{ item.content }}</div>
              </div>
            </div>
          </div>
        </nut-scroller>
      </div>
    </nut-actionsheet>
  </div>
</template>

<script>
import Vue from "vue";
import { ActionSheet, Scroller } from "@nutui/nutui";

ActionSheet.install(Vue);
Scroller.install(Vue);
export default {
  name: "comment",
  data() {
    return {
      comment: "",
      comments: null,
      isLoading: false,
      timer: null,
      count: 0
    };
  },
  props: {
    postId: {
      type: Number
    },
    isVisible: {
      type: Boolean,
      required: true
    }
  },
  components: {
    [ActionSheet.name]: ActionSheet,
    [Scroller.name]: Scroller
  },
  // mounted() {
  //   this.getComments(this.postId);
  // },
  destroyed() {
    clearTimeout(this.timer);
  },
  watch: {
    postId(id) {
      this.getComments(id);
    }
  },
  methods: {
    refresh() {
      this.isLoading = true;
      clearTimeout(this.timer);
      this.timer = setTimeout(() => {
        this.isLoading = false;
        this.getComments(this.postId);
      }, 300);
    },
    addComment() {
      this.$api
        .addComment({
          content: this.comment,
          post_id: this.postId
        })
        .then(res => {
          this.comment = "";
          console.log(res);
        })
        .catch(err => {
          console.log(err);
        });
    },
    getComments(params) {
      this.$api
        .getComments({
          params: {
            id: params
          }
        })
        .then(res => {
          let comments = res.data.data;
          this.comments = comments;
          this.count = comments.length;
        })
        .catch(err => {
          console.log(err);
        });
    },
    showActionSheet() {
      const ctx = this;
      ctx.$emit("cancel");
    }
  }
};
</script>

<style lang="scss" scoped>
.custom-wrap {
  padding: 0 15px 15px 15px;
}
.single-comment {
  padding: 5px 0;
  & > img {
    width: 40px;
    height: 40px;
    border-radius: 50%;
    float: left;
  }
  &::after {
    content: ".";
    display: block;
    height: 0;
    clear: both;
    visibility: hidden;
  }
}

.content {
  border-bottom: 1px solid #dadada;
  font-size: 0.9em;
  float: right;
  width: calc(100% - 40px);
  box-sizing: border-box;
  padding: 10px;
  color: #656565;
}
.nickname {
  margin-bottom: 10px;
}
.input-addon {
  position: relative;
  padding: 0 15px;
  background-color: #ff7b8c;
  border-radius: 0 15px 15px 0;
}
.comment-input {
  position: fixed;
  bottom: 0;
  left: 0;
  right: 0;
  background: #fff;
  display: flex;
  padding: 10px;
  z-index: 1;
  & > input {
    box-sizing: border-box;
    margin: 0;
    padding: 0;
    list-style: none;
    position: relative;
    display: inline-block;
    width: 100%;
    height: 32px;
    padding: 4px 11px;
    color: rgba(0, 0, 0, 0.65);
    font-size: 14px;
    line-height: 1.5;
    background-color: #fff;
    border: 1px solid #d9d9d9;
    border-right: none;
    border-radius: 15px 0 0 15px;
  }
}

.btn {
  background: #ff7b8c;
  border: none;
  width: 100%;
  height: 100%;
  color: #fff;
}
</style>