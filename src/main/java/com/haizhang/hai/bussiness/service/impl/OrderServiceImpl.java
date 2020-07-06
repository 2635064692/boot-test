package com.haizhang.hai.bussiness.service.impl;

import com.haizhang.hai.annotation.NeedSetFiledValue;
import com.haizhang.hai.bussiness.dto.SaveOrderDTO;
import com.haizhang.hai.bussiness.model.entity.Order;
import com.haizhang.hai.bussiness.model.repository.OrderRepository;
import com.haizhang.hai.bussiness.service.OrderService;
import com.haizhang.hai.bussiness.vo.OrderVO;
import com.haizhang.hai.utils.UniqueCodeUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    private OrderRepository orderRepository;

    @Override
    @NeedSetFiledValue
    public List<OrderVO> getAllOrder() {
        List<Order> orders = orderRepository.findAll();
        return orders.parallelStream().map(item->{
            OrderVO orderVO = new OrderVO();
            BeanUtils.copyProperties(item,orderVO);

            return orderVO;
        }).collect(Collectors.toList());
    }

    @Override
    public List<Order> selectFutureOverTimeOrder() {
        return null;
    }

    @Override
    public void updateCloseOverTimeOrder(Long orderId) {
//        orderMapper.updateCloseOverTimeOrder(orderId);
    }

    @Override
    public Order saveOrder(SaveOrderDTO saveDTO) {
        Order order = new Order();
        BeanUtils.copyProperties(saveDTO, order);
        order.setOrderNo(UniqueCodeUtils.generateUniqueCode(4));

       return orderRepository.save(order);
    }
}
