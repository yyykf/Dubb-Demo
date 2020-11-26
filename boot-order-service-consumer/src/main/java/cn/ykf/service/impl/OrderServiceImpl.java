package cn.ykf.service.impl;

import cn.ykf.model.UserAddress;
import cn.ykf.service.OrderService;
import cn.ykf.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单服务实现类
 *
 * @author YuKaiFan<yukf @ pvc123.com>
 * @date 2020-11-22
 */
@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    /**
     * 1. 设置启动时不检查，优先级比 dubbo.consumer.check 高
     * 2. 设置 getUserAddressList 方法超时时间
     * 3. 关于设置的优先级:
     *  3.1 精确优先，方法级别 > 服务级别 > 消费者全局级别
     *  3.2 消费者优先，**同一级别下，** 消费者 > 提供者
     *  3.3 也就是说，reference:method > service:method > reference > service > consumer > provider
     */
    @DubboReference(check = false, methods = {
            @Method(name = "getUserAddressList",timeout = 5000)
    },timeout = 1000)
    private UserService userService;

    @Override
    public List<UserAddress> initOrder(String userId) {
        LOGGER.info("用户id：{}", userId);

        return userService.getUserAddressList(userId);
    }
}
