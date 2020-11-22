package cn.ykf.service.impl;

import cn.ykf.model.UserAddress;
import cn.ykf.service.OrderService;
import cn.ykf.service.UserService;

import java.util.List;

/**
 * 订单服务实现类
 *
 * @author YuKaiFan<yukf @ pvc123.com>
 * @date 2020-11-22
 */
public class OrderServiceImpl implements OrderService {

    private UserService userService;

    @Override
    public void initOrder(String userId) {
        final List<UserAddress> addressList = userService.getUserAddressList(userId);
        addressList.forEach(System.out::println);
    }
}
