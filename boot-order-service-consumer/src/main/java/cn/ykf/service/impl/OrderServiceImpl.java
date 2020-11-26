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
     * 2. 设置 getUserAddressList 方法超时时间，一般推荐由提供者设置，因为提供者更清楚方法的大致调用耗时
     * 3. 关于设置的优先级:
     *  3.1 精确优先，方法级别 > 服务级别 > 消费者全局级别
     *  3.2 消费者优先，**同一级别下，** 消费者 > 提供者
     *  3.3 也就是说，reference:method > service:method > reference > service > consumer > provider
     * 4. 超时一般会搭配重试，但是只有幂等操作才可以进行重试（查询，删除，修改），而非幂等操作不要进行重试（添加，因为有可能数据添加到数据库后没
     *   来得及返回就超时了，一旦重试的话可能就会有重复记录）。
     *  4.1 如果设置 retries=3，那么算上第一次调用的话最多可能调用4次。
     *  4.2 只有当所有重试完依旧不能调用时，才会抛出超时异常。而不是第一次调用超时抛异常--》重试--》超时抛异常--》...
     */
    @DubboReference(check = false, methods = {
            @Method(name = "getUserAddressList", timeout = 2000, retries = 3)
    }, timeout = 1000)
    private UserService userService;

    @Override
    public List<UserAddress> initOrder(String userId) {
        LOGGER.info("用户id：{}", userId);

        return userService.getUserAddressList(userId);
    }
}
