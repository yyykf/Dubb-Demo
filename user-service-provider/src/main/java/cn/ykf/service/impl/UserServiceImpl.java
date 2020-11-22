package cn.ykf.service.impl;

import cn.ykf.model.UserAddress;
import cn.ykf.service.UserService;

import java.util.Arrays;
import java.util.List;

/**
 * 用户服务实现类
 *
 * @author YuKaiFan<yukf @ pvc123.com>
 * @date 2020-11-22
 */
public class UserServiceImpl implements UserService {

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        UserAddress address1 = new UserAddress("1", "北京市昌平区宏福科技园综合楼3层", "1", "李老师", "010-56253825", true);
        UserAddress address2 = new UserAddress("2", "深圳市宝安区西部硅谷大厦B座3层（深圳分校）", "1", "王老师", "010-56253825", false);

        return Arrays.asList(address1, address2);
    }
}
