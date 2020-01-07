package com.example.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.app.model.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface PostMapper extends BaseMapper<Post> {
//    List<Post> getPosts();
    IPage<Post> getPosts(Page page);
    List<Post> getAllPosts(String id);
    List<Post> search(String post);
}
