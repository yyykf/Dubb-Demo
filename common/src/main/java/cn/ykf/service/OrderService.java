package cn.ykf.service;

import cn.ykf.model.UserAddress;

import java.util.List;

/**
 * 订单服务
 *
 * @author YuKaiFan<yukf @ pvc123.com>
 * @date 2020-11-22
 */
public interface OrderService {

    /**
     * 初始化用户订单
     *
     * @param userId 用户id
     * @return 用户地址集合
     */
    List<UserAddress> initOrder(String userId);
}
