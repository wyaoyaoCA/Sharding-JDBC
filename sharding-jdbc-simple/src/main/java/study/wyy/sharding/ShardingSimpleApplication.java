package study.wyy.sharding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：wyy
 * @date ：Created in 2019-12-15 10:48
 * @description：启动类
 * @modified By：
 * @version: $
 */
@SpringBootApplication
@MapperScan("study.wyy.sharding.dao")
public class ShardingSimpleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShardingSimpleApplication.class);
    }
}
