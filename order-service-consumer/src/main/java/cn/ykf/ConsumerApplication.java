package cn.ykf;

import cn.ykf.service.OrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * 消费端主程序
 * @author YuKaiFan<yukf @ pvc123.com>
 * @date 2020-11-24
 */
public class ConsumerApplication {

    public static void main(String[] args) throws IOException {
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        final OrderService orderService = context.getBean("orderServiceImpl", OrderService.class);
        orderService.initOrder("1");
        System.out.println("调用结束...");

        System.in.read();
    }
}
