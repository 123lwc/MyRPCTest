package server;

import service.BlogService;
import service.BlogServiceImpl;
import service.UserService;
import service.UserServiceImpl;

/**
 * Created by Administrator on 2021/10/28 0028
 * Description: MyRPCTest
 * Created by Administrator on 2021/10/28 0028 15:19
 */
public class TestServer2 {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        BlogService blogService = new BlogServiceImpl();

//        Map<String, Object> serviceProvide = new HashMap<>();
//        serviceProvide.put("com.ganghuan.myRPCVersion2.service.UserService",userService);
//        serviceProvide.put("com.ganghuan.myRPCVersion2.service.BlogService",blogService);
        ServiceProvider serviceProvider = new ServiceProvider("127.0.0.1", 8890);
        serviceProvider.provideServiceInterface(userService);
        serviceProvider.provideServiceInterface(blogService);

        RPCServer RPCServer = new NettyRPCServer(serviceProvider);
        RPCServer.start(8890);
    }
}
