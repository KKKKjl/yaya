package com.example.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.app.model.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface PostMapper extends BaseMapper<Post> {
    List<Post> getPosts();
}
