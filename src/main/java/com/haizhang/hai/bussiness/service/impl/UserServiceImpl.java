package com.haizhang.hai.bussiness.service.impl;


import com.haizhang.hai.bussiness.dto.UserDTO;
import com.haizhang.hai.bussiness.model.entity.User;
import com.haizhang.hai.bussiness.model.repository.SysUserEntityRepository;
import com.haizhang.hai.bussiness.model.repository.UserRepository;
import com.haizhang.hai.bussiness.service.SendService;
import com.haizhang.hai.bussiness.service.UserService;
import com.haizhang.hai.bussiness.vo.UserVO;
import com.haizhang.hai.utils.BeanCopyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    SysUserEntityRepository sysUserEntityRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    SendService sendService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public User save(UserDTO userDTO) {
        User user = new User();
        BeanCopyUtils.copy(userDTO, user);
        user = userRepository.save(user);
        System.out.println("User 保存用户成功:" + user);
//        UserService currentProxy = UserService.class.cast(AopContext.currentProxy());
        sendService.senMsg(user);
        sendService.senEmail(user);
//        int i = 1 / 0;
        return user;
    }

    @Override
    public void send(User user) {

    }

    @Override
    public void senMsg(User user) {

    }

    @Override
    public void senEmail(User user) {

    }

    @Override
    public User selectById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.orElse(null);
    }

    @Override
    @Transactional
    public User updateById(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        return userRepository.save(user);
    }


    @Override
    public long countFansCountByUserId(Long userId) {
        try {
            Thread.sleep(10000);
            System.out.println("获取FansCount===睡眠:" + 10 + "s");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("UserService获取FansCount的线程  " + Thread.currentThread().getName());
        return 520;
    }

    @Override
    public long countMsgCountByUserId(Long userId) {
        System.out.println("UserService获取MsgCount的线程  " + Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
            System.out.println("获取MsgCount===睡眠:" + 10 + "s");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 618;
    }

    @Override
    public long countCollectCountByUserId(Long userId) {
        System.out.println("UserService获取CollectCount的线程  " + Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
            System.out.println("获取CollectCount==睡眠:" + 10 + "s");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 6664;
    }

//    @Override
//    public long countFollowCountByUserId(Long userId) {
//        System.out.println("UserService获取FollowCount的线程  " + Thread.currentThread().getName());
//        try {
//            Thread.sleep(10000);
//            System.out.println("获取FollowCount===睡眠:" + 10 + "s");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return userMapper.countFollowCountByUserId(userId);
//    }

    @Override
    public long countRedBagCountByUserId(Long userId) {
        System.out.println("UserService获取RedBagCount的线程  " + Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(4);
            System.out.println("获取RedBagCount===睡眠:" + 4 + "s");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 99;
    }

    @Override
    public long countCouponCountByUserId(Long userId) {
        System.out.println("UserService获取CouponCount的线程  " + Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(8);
            System.out.println("获取CouponCount===睡眠:" + 8 + "s");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 66;
    }

    @Override
    @Transactional
    public int save(UserVO userVO) {
        User user = new User();
        user.setSex(userVO.getSex());
        user.setUsername(userVO.getUsername());
        user.setPassword(userVO.getPassword());
        user.setMobile(userVO.getMobile());
        user.setEmail(userVO.getMobile());
        userRepository.save(user);
        System.out.println("userVO 保存用户成功:" + userVO);
        return 1;
    }


    @Override
    @Transactional
    public void delete(Long userId) {
       userRepository.deleteById(userId);
    }


}
