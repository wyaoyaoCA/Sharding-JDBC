package study.wyy.sharding.dao;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import study.wyy.sharding.ShardingSimpleApplication;
import study.wyy.sharding.pojo.Order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：wyy
 * @date ：Created in 2019-12-15 15:24
 * @description：
 * @modified By：
 * @version: $
 */
@Slf4j
@SpringBootTest(classes = ShardingSimpleApplication.class)
@RunWith(SpringRunner.class)
public class OrderDaoTest {

    @Autowired
    private OrderDao orderDao;
    @Test
    public void testInsertOrder(){

        Order order = new Order();
        order.setPrice(new BigDecimal(11));
        order.setUserId(1L);
        order.setStatus("SUCCESS");
        for(int i =0 ; i < 100; i++){
            int orderId = orderDao.insertOrder(order);
            log.info("新增订单id为 => {}", order.getOrderId());
        }
    }

    @Test
    public void testSelectOrderbyIds(){
        List list = new ArrayList();
        list.add(413065844453539841L);
        list.add(413065844650672128L);
        List result = orderDao.selectOrderbyIds(list);
        log.info("查询结果 => {}",result);


    }
}
