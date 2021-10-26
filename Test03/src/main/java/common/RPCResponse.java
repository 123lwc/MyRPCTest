package common;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Administrator on 2021/10/22 0022
 * Description: MyRPCTest
 * Created by Administrator on 2021/10/22 0022 16:08
 */
@Data
@Builder
public class RPCResponse implements Serializable {
    private int code;
    private String message;
    private Object data;
    public static RPCResponse success(Object data) {
        return RPCResponse.builder().code(200).data(data).build();
    }
    public static RPCResponse fail() {
        return RPCResponse.builder().code(500).message("服务期发生错误").build();
    }
}
