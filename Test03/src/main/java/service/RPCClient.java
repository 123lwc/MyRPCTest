package service;

import client.ClientProxy;
import common.User;

/**
 * Created by Administrator on 2021/10/26 0026
 * Description: MyRPCTest
 * Created by Administrator on 2021/10/26 0026 14:17
 */
public class RPCClient {
    public static void main(String[] args) {
        ClientProxy clientProxy = new ClientProxy("127.0.0.1",8899);
        UserService proxy = clientProxy.getProxy(UserService.class);

        User userGetById = proxy.getUserByUserId(10);
        System.out.println("userGetById = " + userGetById);
        User user1 = User.builder().userName("zhangsan").id(20).sex(true).build();
        Integer id = proxy.insertUserId(user1);
        System.out.println("id = " + id);
    }
}
