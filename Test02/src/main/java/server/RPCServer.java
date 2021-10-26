package server;

import common.RPCRequest;
import common.RPCResponse;
import service.UserServiceImpl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2021/10/22 0022
 * Description: MyRPCTest
 * Created by Administrator on 2021/10/22 0022 16:30
 */
public class RPCServer {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        try {
            ServerSocket serverSocket = new ServerSocket(8899);
            System.out.println("服务端启动了");
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(() -> {
                    try {
                        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                        RPCRequest rpcRequest = (RPCRequest) ois.readObject();
                        Method method = userService.getClass().getMethod(rpcRequest.getMethodName(),rpcRequest.getParamsTypes());
                        Object invoke = method.invoke(userService,rpcRequest.getParams());
                        oos.writeObject(RPCResponse.success(invoke));
                        oos.flush();
                    } catch (IOException | ClassNotFoundException | NoSuchMethodException |InvocationTargetException |IllegalAccessException e) {
                        e.printStackTrace();
                        System.out.println("从IO中读取数据错误");
                    }
                }).start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
