package study.wyy.sharding.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import study.wyy.sharding.pojo.Order;

import java.util.List;
import java.util.Map;

public interface OrderDao {


    /**
     * 新增订单
     * @param order
     * @return
     */
    // 注意这里的表名就是配置的逻辑表名t_order
    @Insert("insert into t_order(price,user_id,status)values(#{price},#{userId},#{status})")
    @Options(useGeneratedKeys = true,keyColumn = "order_id",keyProperty = "orderId")
    int insertOrder(Order order);

    /**
     * 根据id列表查询多个订单
     * @param orderIds 订单id列表
     * @return
     */
    @Select({"<script>" +
            "select " +
            " * " +
            " from t_order t" +
            " where t.order_id in " +
            "<foreach collection='orderIds' item='id' open='(' separator=',' close=')'>" +
            " #{id} " +
            "</foreach>"+
            "</script>"})
    List<Map> selectOrderbyIds(@Param("orderIds") List<Long> orderIds);
}
