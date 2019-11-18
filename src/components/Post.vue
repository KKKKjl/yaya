<template>
  <div>
    <nut-skeleton class="my-skeleton" v-if="isShow">
      <div v-for=" i in 5" :key="i">
        <row padding="10px">
          <skeleton-circle diameter="60px"></skeleton-circle>
          <column>
            <skeleton-square width="auto" :count="2" margin="5px 10px 5px 10px"></skeleton-square>
            <skeleton-square width="100px" margin="5px 10px 5px 10px"></skeleton-square>
          </column>
        </row>
        <row padding="0 0 20px 0">
          <skeleton-square width="100%" :count="15"></skeleton-square>
        </row>
      </div>
    </nut-skeleton>

    <article v-else v-for="(post, index) in posts" :key="index">
      <div class="postinfo">
        <img class="avatar" :src="post.user.avatar_url" />
        <div class="nickname">{{ post.user.nickname }}</div>
        <timeago class="timestamp" :autoUpdate="1" :datetime="post.create_time" />
      </div>
      <div class="postcontent">
        <img :src="post.img_url" @click="previewImg(post.img_url, post.content)" />
        <p>{{ post.content }}</p>
        <span style="font-size: 0.7em;" @click="showComments(post.id)">查看全部３条评论</span>
      </div>
    </article>
    <preview :isShow="showMask" :imgUrl="imgUrl" v-on:closeMask="closeMask" :imgDesc="imgDesc"></preview>
    <comment :isVisible="isVisible" v-on:cancel="cancel" :postId="postId"></comment>
  </div>
</template>

<script>
import Vue from "vue";
import Skeleton from "@nutui/nutui";
import comment from "@/components/Comment.vue";
import preview from "@/components/Preview.vue";

Skeleton.install(Vue);

export default {
  name: "post",
  components: {
    [Skeleton.name]: Skeleton,
    comment,
    preview
  },
  data() {
    return {
      date: new Date(),
      posts: null,
      isShow: true,
      isVisible: false,
      postId: null,
      showMask: false,
      imgUrl: null,
      imgDesc: ""
    };
  },
  methods: {
    previewImg(k, v) {
      const ctx = this;
      ctx.imgUrl = k;
      ctx.imgDesc = v;
      ctx.showMask = true;
    },
    closeMask() {
      const ctx = this;
      ctx.showMask = false;
    },
    getPosts() {
      const ctx = this;
      this.$api
        .getPosts({})
        .then(res => {
          ctx.posts = res.data.data;
          this.isShow = false;
        })
        .catch(e => {
          ctx.isShow = true;
          throw new Error(e);
        });
    },
    cancel() {
      const ctx = this;
      ctx.isVisible = !ctx.isVisible;
    },
    showComments(id) {
      const ctx = this;
      ctx.postId = id;
      ctx.isVisible = true;
    }
  },
  created() {
    this.getPosts();
  }
};
</script>

<style lang="scss" scoped>
article {
  padding: 5px 10px;
  background: #ffffff;
  margin-bottom: 30px;
}
.postinfo {
  padding: 10px 0;
  &::after {
    content: ".";
    display: block;
    height: 0;
    clear: both;
    visibility: hidden;
  }
  & > img {
    height: 50px;
    width: 50px;
    float: left;
    border-radius: 50%;
  }
}

.nickname,
.timestamp {
  float: left;
  width: calc(100% - 56px);
  margin-top: 2px;
  box-sizing: border-box;
  padding: 0 10px;
  color: #656565;
}

.postcontent {
  & > img {
    width: 100%;
    height: 200px;
    border-radius: 3px;
  }
  & > p {
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 3;
    overflow: hidden;
    font-size: 0.9em;
  }
}

.vue-skeleton-row {
  display: flex;
}

.vue-skeleton-column {
  width: 100%;
}

.vue-skeleton-square-wrap {
  width: 100%;
}
</style>