package cn.ykf.service.impl;

import cn.ykf.model.UserAddress;
import cn.ykf.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.annotation.Method;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 用户服务实现类，设置了本地存根，本地存根的初始化由消费端来完成
 *
 * @author YuKaiFan<yukf @ pvc123.com>
 * @date 2020-11-22
 */
@DubboService(timeout = 1000, methods = {
        @Method(name = "getUserAddressList", timeout = 2000)
}, version = "1.0.0", stub = "cn.ykf.service.stub.UserServiceStub")
public class UserServiceImpl implements UserService {

    private final AtomicInteger counter = new AtomicInteger();

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("version 1.0.0~~~");
        System.out.println("第" + counter.incrementAndGet() + "次调用...");
        UserAddress address1 = new UserAddress("1", "北京市昌平区宏福科技园综合楼3层", "1", "李老师", "010-56253825", true);
        UserAddress address2 = new UserAddress("2", "深圳市宝安区西部硅谷大厦B座3层（深圳分校）", "1", "王老师", "010-56253825", false);

        try {
            // 模拟调用耗时
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return Arrays.asList(address1, address2);
    }
}
