package common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by Administrator on 2021/10/22 0022
 * Description: MyRPCTest
 * Created by Administrator on 2021/10/22 0022 10:52
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {
    private Integer id;
    private String userName;
    private boolean sex;
}
