package com.example.app.task;

import com.example.app.mapper.UserLikeMapper;
import com.example.app.model.UserLike;
import com.example.app.server.LikeServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class ScheduledTasks {
    private Logger logger = Logger.getLogger(ScheduledTasks.class.getName());
    @Autowired
    LikeServer likeServer;

    @Autowired
    UserLikeMapper userLikeMapper;

    //0 0 0/1 * * ?
    @Scheduled(cron = "0 0 0/1 * * ?")
    public void redisDataToMySQL() {
        logger.info("开始执行Redis数据持久化到MySQL任务");
        for (UserLike userLike: likeServer.getLikedDataFromRedis()) {
            userLikeMapper.insert(userLike);
        }
        logger.info("结束执行Redis数据持久化到MySQL任务");
    }
}
