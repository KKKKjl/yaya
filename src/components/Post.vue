<template>
  <div>
    <article v-for="(post, index) in posts" :key="index">
      <div class="postinfo">
        <img class="avatar" :src="post.avatarImageUrl" />
        <div class="nickname">{{ post.nickName }}</div>
        <div class="timestamp">{{ post.timeStamp }}</div>
      </div>
      <div class="postcontent">
        <img :src="post.postImageUrl" />
        <p>{{ post.content }}</p>
        <svg-icon icon-class="heart"></svg-icon>
        <span style="font-size: 0.7em;">查看全部３条评论</span>
        <!-- <div class="heart"></div> -->
      </div>
    </article>
  </div>
</template>

<script>
export default {
  name: "post",
  data() {
    return {
      posts: [
        {
          avatarImageUrl: "https://i.loli.net/2019/10/26/bvfkZAIFSWRErKX.jpg",
          nickName: "kkkknq",
          timeStamp: "1天前",
          content:
            "分享一个周末，手机摄影无滤镜。扬州的秋天是真的美，第n次来瘦西湖，这个季节满是桂花香，与烟花三月的热闹不同，此时淡淡的清冷感别有一番意境。对了，来了扬州一定要去趣园茶社，菜品棒极了。",
          postImageUrl: "https://i.loli.net/2019/10/26/rGpXhgoIQDkAUn4.jpg"
        },
        {
          avatarImageUrl: "https://i.loli.net/2019/10/26/bvfkZAIFSWRErKX.jpg",
          nickName: "kkkknq",
          timeStamp: "29天前",
          content:
            "分享一个周末，手机摄影无滤镜。扬州的秋天是真的美，第n次来瘦西湖，这个季节满是桂花香，与烟花三月的热闹不同，此时淡淡的清冷感别有一番意境。对了，来了扬州一定要去趣园茶社，菜品棒极了。",
          postImageUrl: "https://i.loli.net/2019/10/26/rGpXhgoIQDkAUn4.jpg"
        },
        {
          avatarImageUrl: "https://i.loli.net/2019/10/26/bvfkZAIFSWRErKX.jpg",
          nickName: "kkkknq",
          timeStamp: "1年前",
          content:
            "分享一个周末，手机摄影无滤镜。扬州的秋天是真的美，第n次来瘦西湖，这个季节满是桂花香，与烟花三月的热闹不同，此时淡淡的清冷感别有一番意境。对了，来了扬州一定要去趣园茶社，菜品棒极了。",
          postImageUrl: "https://i.loli.net/2019/10/26/rGpXhgoIQDkAUn4.jpg"
        }
      ]
    };
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