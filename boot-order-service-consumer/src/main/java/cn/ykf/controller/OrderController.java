package cn.ykf.controller;

import cn.ykf.model.UserAddress;
import cn.ykf.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单控制器
 *
 * @author YuKaiFan<yukf @ pvc123.com>
 * @date 2020/11/25
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/init/{uid}")
    public List<UserAddress> initOrder(@PathVariable String uid) {
        return orderService.initOrder(uid);
    }
}
