package cn.ykf.service;

import cn.ykf.model.UserAddress;

import java.util.List;

/**
 * 用户服务
 *
 * @author YuKaiFan<yukf @ pvc123.com>
 * @date 2020-11-21
 */
public interface UserService {

    /**
     * 根据用户id查询收货地址集合
     *
     * @param userId 用户id
     * @return 收货地址集合
     */
    List<UserAddress> getUserAddressList(String userId);
}
