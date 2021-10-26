package service;

import common.User;

import java.util.Random;
import java.util.UUID;

/**
 * Created by Administrator on 2021/10/22 0022
 * Description: MyRPCTest
 * Created by Administrator on 2021/10/22 0022 10:58
 */
public class UserServiceImpl implements UserService{
    @Override
    public User getUserByUserId(Integer id) {
        System.out.println("客户端查询le："+id +"用户");
        Random random = new Random();
        User user = User.builder().userName(UUID.randomUUID().toString())
                .id(id)
                .sex(random.nextBoolean()).build();

        return user;
    }
}
