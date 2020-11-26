package cn.ykf.service.impl;

import cn.ykf.model.UserAddress;
import cn.ykf.service.OrderService;
import cn.ykf.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
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

    /** 启动时不检查，优先级比 dubbo.consumer.check 高 */
    @DubboReference(check = false)
    private UserService userService;

    @Override
    public List<UserAddress> initOrder(String userId) {
        LOGGER.info("用户id：{}", userId);

        return userService.getUserAddressList(userId);
    }
}
