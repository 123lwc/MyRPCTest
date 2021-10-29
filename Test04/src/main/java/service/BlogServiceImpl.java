package service;

import common.Blog;

/**
 * Created by Administrator on 2021/10/26 0026
 * Description: MyRPCTest
 * Created by Administrator on 2021/10/26 0026 14:50
 */
public class BlogServiceImpl implements BlogService{
    @Override
    public Blog getBlogById(Integer id) {
        Blog blog = Blog.builder().id(id).title("我的博客").userId(22).build();
        System.out.println("客户端查询了"+id+"博客");
        return blog;
    }
}
