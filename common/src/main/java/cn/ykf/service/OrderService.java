package cn.ykf.service;

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
     */
    void initOrder(String userId);
}
