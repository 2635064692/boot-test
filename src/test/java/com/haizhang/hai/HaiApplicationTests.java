package com.haizhang.hai;

import com.alibaba.fastjson.JSON;
import com.haizhang.hai.bussiness.service.OrderService;
import com.haizhang.hai.bussiness.vo.OrderVO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class HaiApplicationTests {

    @Autowired
    OrderService orderService;


    @Test
    void contextLoads() {
        List<OrderVO> allOrder = orderService.getAllOrder();

        System.out.println(JSON.toJSONString(allOrder));
    }

}
