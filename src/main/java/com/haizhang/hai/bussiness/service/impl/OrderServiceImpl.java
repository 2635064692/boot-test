package com.haizhang.hai.bussiness.service.impl;

import com.haizhang.hai.annotation.NeedSetFiledValue;
import com.haizhang.hai.bussiness.model.entity.Order;
import com.haizhang.hai.bussiness.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiJing
 * @ClassName: OrderServiceImpl
 * @Description: 订单Service服务类
 * @date 2019/8/9 15:33
 */
@Service
public class OrderServiceImpl implements OrderService {
//    @Autowired
//    private OrderMapper orderMapper;

    @Override
    @NeedSetFiledValue
    public List<Order> getAllOrder() {
//        List<Order> orderList = orderMapper.getAllOrder();
        List<Order> orderList = new ArrayList<>();
        Order order1 = new Order();
        order1.setId(8888L);
        order1.setName("订单:" + order1.getId());
        order1.setCustomerId(206);
        orderList.add(order1);

        Order order2 = new Order();
        order2.setId(9999L);
        order2.setName("订单:" + order2.getId());
        order2.setCustomerId(204);
        orderList.add(order2);

        return orderList;
    }

    @Override
    public List<Order> selectFutureOverTimeOrder() {
        return null;
    }

    @Override
    public void updateCloseOverTimeOrder(Long orderId) {
//        orderMapper.updateCloseOverTimeOrder(orderId);
    }
}
