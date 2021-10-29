package com.lwc.junit4;


import client.ClientProxy;
import common.Blog;
import common.User;
import org.junit.Test;
import server.RPCServer;
import server.ServiceProvider;
import server.SimpleRPCRPCServer;
import service.BlogService;
import service.BlogServiceImpl;
import service.UserService;
import service.UserServiceImpl;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 2021/10/27 0027
 * Description: MyRPCTest
 * Created by Administrator on 2021/10/27 0027 11:19
 */
public class HelloWorldTest {

    @Test
    public void firstTest() {
        UserService userService = new UserServiceImpl();
        BlogService blogService = new BlogServiceImpl();

//        Map<String, Object> serviceProvide = new HashMap<>();
//        serviceProvide.put("com.ganghuan.myRPCVersion2.service.UserService",userService);
//        serviceProvide.put("com.ganghuan.myRPCVersion2.service.BlogService",blogService);
        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.provideServiceInterface(userService);
        serviceProvider.provideServiceInterface(blogService);

        RPCServer RPCServer = new SimpleRPCRPCServer(serviceProvider);
        RPCServer.start(8899);
    }


    @Test
    public void rpcclientTest(){
        ClientProxy clientProxy = new ClientProxy("127.0.0.1",8899);
        UserService proxy = clientProxy.getProxy(UserService.class);

        User userGetById = proxy.getUserByUserId(10);
        System.out.println("userGetById = " + userGetById);
        User user1 = User.builder().userName("zhangsan").id(20).sex(true).build();
        Integer id = proxy.insertUserId(user1);
        System.out.println("id = " + id);
        // 客户中添加新的测试用例
        BlogService blogService = clientProxy.getProxy(BlogService.class);
        Blog blogById = blogService.getBlogById(10);
        System.out.println("从服务端得到的blog为：" + blogById);
    }
}
