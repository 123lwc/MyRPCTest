package client;

import common.RPCRequest;
import common.RPCResponse;

/**
 * Created by Administrator on 2021/10/27 0027
 * Description: MyRPCTest
 * Created by Administrator on 2021/10/27 0027 11:42
 */
public interface RPCClient {
    RPCResponse sendRequest(RPCRequest response);
}
