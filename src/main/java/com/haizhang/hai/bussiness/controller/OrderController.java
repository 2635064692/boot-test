package com.haizhang.hai.bussiness.controller;

import com.haizhang.hai.bussiness.dto.SaveOrderDTO;
import com.haizhang.hai.bussiness.model.entity.Order;
import com.haizhang.hai.bussiness.service.OrderService;
import com.haizhang.hai.bussiness.vo.OrderVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin_z by 2020/6/30
 * @ClassName TestController
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public String createOrder(@RequestBody SaveOrderDTO saveOrderDTO) {

        Order order = orderService.saveOrder(saveOrderDTO);
        OrderVO orderVO = new OrderVO();
        BeanUtils.copyProperties(orderVO, order);

        return "启动用户模块成功~~~~~~~~";
    }

}
