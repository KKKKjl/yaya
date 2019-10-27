<template>
  <div>
    <nut-skeleton class="my-skeleton" v-if="isShow">
      <row padding="0 10px 20px">
        <column>
          <skeleton-square width="auto" :count="6" margin="5px 10px 5px 10px"></skeleton-square>
          <skeleton-square width="200px" margin="5px 10px 5px 10px"></skeleton-square>
        </column>
      </row>
    </nut-skeleton>

    <article v-else v-for="(post, index) in posts" :key="index">
      <div class="postinfo">
        <img class="avatar" :src="post.avatarImageUrl" />
        <div class="nickname">{{ post.nickName }}</div>
        <div class="timestamp">{{ post.timeStamp }}</div>
      </div>
      <div class="postcontent">
        <img :src="post.postImageUrl" />
        <p>{{ post.content }}</p>
        <span style="font-size: 0.7em;">查看全部３条评论</span>
        <!-- <div class="heart"></div> -->
      </div>
    </article>
  </div>
</template>

<script>
import Vue from "vue";
import Skeleton from "@nutui/nutui";

Skeleton.install(Vue);

export default {
  name: "post",
  components: {
    [Skeleton.name]: Skeleton
  },
  data() {
    return {
      posts: null,
      isShow: true
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

// .heart {
//   width: 100px;
//   height: 100px;
//   transform: translate(-50%, -50%);
//   background: url(https://cssanimation.rocks/images/posts/steps/heart.png)
//     no-repeat;
//   background-position: 0 0;
//   cursor: pointer;
//   animation: fave-heart 1s steps(28);
//   &:hover {
//     background-position: -2800px 0;
//     transition: background 1s steps(28);
//   }
// }

// @keyframes fave-heart {
//   0% {
//     background-position: 0 0;
//   }
//   100% {
//     background-position: -2800px 0;
//   }
// }
</style>