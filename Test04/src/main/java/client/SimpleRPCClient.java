package client;

import common.RPCRequest;
import common.RPCResponse;
import lombok.AllArgsConstructor;
import register.ServiceRegister;
import register.ZkServiceRegister;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by Administrator on 2021/10/27 0027
 * Description: MyRPCTest
 * Created by Administrator on 2021/10/27 0027 11:42
 */
@AllArgsConstructor
public class SimpleRPCClient implements RPCClient{
    private String host;
    private int port;
    private ServiceRegister serviceRegister;
    public SimpleRPCClient() {
        // 初始化注册中心，建立连接
        this.serviceRegister = new ZkServiceRegister();
    }
    @Override
    public RPCResponse sendRequest(RPCRequest request) {
        InetSocketAddress address = serviceRegister.serviceDiscovery(request.getInterfaceName());
        host = address.getHostName();
        port = address.getPort();
        try {
            // 发起一次Socket连接请求
            Socket socket = new Socket(host, port);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

            System.out.println(request);
            objectOutputStream.writeObject(request);
            objectOutputStream.flush();

            RPCResponse response = (RPCResponse) objectInputStream.readObject();

            //System.out.println(response.getData());
            return response;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println();
            return null;
        }
    }
}
