<template>
  <div>
    <nut-skeleton class="my-skeleton" v-if="isShow">
      <row padding="0 10px 20px" v-for=" i in 5" :key="i">
        <column>
          <skeleton-square width="auto" :count="6" margin="5px 10px 5px 10px"></skeleton-square>
          <skeleton-square width="200px" margin="5px 10px 5px 10px"></skeleton-square>
        </column>
      </row>
    </nut-skeleton>

    <article v-else v-for="(post, index) in posts" :key="index">
      <div class="postinfo">
<!--         <img class="avatar" src="https://i.loli.net/2019/11/07/5tzAhG3RiPrevlU.jpg" /> -->
        <img class="avatar" :src="post.user.avatar_url" />
        <div class="nickname">{{ post.user.nickname }}</div>
        <div class="timestamp">3小时前</div>
        <!--         <div class="timestamp">{{ post.create_time }}</div> -->
      </div>
      <div class="postcontent">
        <img :src="post.img_url" />
        <p>{{ post.content }}</p>
        <span style="font-size: 0.7em;" @click="showComments(post.id)">查看全部３条评论</span>
      </div>
    </article>
    <comment :isVisible="isVisible" v-on:cancel="cancel" :postId="postId"></comment>
  </div>
</template>

<script>
import Vue from "vue";
import Skeleton from "@nutui/nutui";
import comment from "@/components/Comment.vue";

Skeleton.install(Vue);

export default {
  name: "post",
  components: {
    [Skeleton.name]: Skeleton,
    comment
  },
  data() {
    return {
      posts: null,
      isShow: true,
      isVisible: false,
      postId: null
    };
  },
  methods: {
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
</style>