package cn.ykf.service.stub;

import cn.ykf.model.UserAddress;
import cn.ykf.service.UserService;

import java.util.Collections;
import java.util.List;

/**
 * 用户接口的本地存根
 *
 * @author YuKaiFan<yukf @ pvc123.com>
 * @date 2020-11-26
 */
public class UserServiceStub implements UserService {

    /** 客户端生成的代理对象，用于RPC调用远程服务 */
    private final UserService userService;

    /**
     * 必须要有该构造器，由Dubbo来自动注入代理对象
     *
     * @param userService 用于调用远程服务的代理对象
     */
    public UserServiceStub(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("UserService本地存根被调用了...");

        // 可以进行自定义的操作，因为是在客户端执行，所以可以做一些参数校验、ThreadLocal缓存等操作
        if (userId == null || "".equals(userId)) {
            return Collections.emptyList();
        }

        // 校验通过再调用，减少不必要的网络开销
        return userService.getUserAddressList(userId);
    }
}
