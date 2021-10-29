package register;

import java.net.InetSocketAddress;

/**
 * Created by Administrator on 2021/10/28 0028
 * Description: MyRPCTest
 * Created by Administrator on 2021/10/28 0028 13:58
 */
// 服务注册接口，两大基本功能，注册：保存服务与地址。 查询：根据服务名查找地址
public interface ServiceRegister {
    void register(String serviceName, InetSocketAddress serverAddress);
    InetSocketAddress serviceDiscovery(String serviceName);
}
