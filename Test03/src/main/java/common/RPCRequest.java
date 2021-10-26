package common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by Administrator on 2021/10/22 0022
 * Description: MyRPCTest
 * Created by Administrator on 2021/10/22 0022 16:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RPCRequest implements Serializable {
    private String interfaceName;
    private String methodName;
    private Object[] params;
    private Class<?>[] paramsTypes;
}
