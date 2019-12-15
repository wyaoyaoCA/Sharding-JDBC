package study.wyy.sharding.pojo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author ：wyy
 * @date ：Created in 2019-12-15 15:19
 * @description：数据库order表对应实体
 * @modified By：
 * @version: $
 */
@Data
public class Order {

    private Long orderId;
    private BigDecimal price;
    private Long userId;
    private String status;
}
