package common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by Administrator on 2021/10/26 0026
 * Description: MyRPCTest
 * Created by Administrator on 2021/10/26 0026 14:46
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog implements Serializable {
    private Integer id;
    private Integer userId;
    private String title;
}
