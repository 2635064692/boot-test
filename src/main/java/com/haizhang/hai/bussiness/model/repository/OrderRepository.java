package com.haizhang.hai.bussiness.model.repository;

import com.haizhang.hai.bussiness.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author admin_z by 2020/6/30
 * @ClassName UserRepository
 */
@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

}
