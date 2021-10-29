package server;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2021/10/26 0026
 * Description: MyRPCTest
 * Created by Administrator on 2021/10/26 0026 15:12
 */
public class ServiceProvider {
    private Map<String,Object> interfaceProvider;
    public ServiceProvider() {
        this.interfaceProvider = new HashMap<>();
    }
    public void provideServiceInterface(Object service) {
        Class<?>[] interfaces = service.getClass().getInterfaces();
        for (Class anInterface : interfaces) {
            interfaceProvider.put(anInterface.getName(),service);
        }
    }
    public Object getService(String interfaceName) {
        return interfaceProvider.get(interfaceName);
    }
}
