package codec;

/**
 * Created by Administrator on 2021/10/27 0027
 * Description: MyRPCTest
 * Created by Administrator on 2021/10/27 0027 17:31
 */
public interface Serializer {
    byte[] serialize(Object obj);
    Object deserialize(byte[] bytes, int messageType);
    int getType();
    static Serializer getSerializerByCode(int code){
        switch (code){
            case 0:
                return new ObjectSerializer();
            case 1:
                return new JsonSerializer();
            default:
                return null;
        }
    }
}
