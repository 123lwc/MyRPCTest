package loadbalance;

import java.util.List;

/**
 * Created by Administrator on 2021/10/28 0028
 * Description: MyRPCTest
 * Created by Administrator on 2021/10/28 0028 15:00
 */
public interface LoadBalance {
    String balance(List<String> addressList);
}
