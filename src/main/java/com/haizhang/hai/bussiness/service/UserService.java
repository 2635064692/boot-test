package com.haizhang.hai.bussiness.service;

import com.haizhang.hai.bussiness.dto.UserDTO;
import com.haizhang.hai.bussiness.model.entity.User;
import com.haizhang.hai.bussiness.vo.UserVO;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserService {


    /**
     * 查询用户
     *
     * @param userId
     * @return
     */
    Optional<User> selectById(Long userId);

    /**
     * 更新用户
     *
     * @param userDTO
     * @return
     */
    User updateById(UserDTO userDTO);

    /**
     * 获取粉丝数
     *
     * @param userId 用户id
     * @return 粉丝数
     */
    long countFansCountByUserId(Long userId);

    /**
     * 获取消息数
     *
     * @param userId 用户id
     * @return 消息数
     */
    long countMsgCountByUserId(Long userId);

    /**
     * 获取收藏总数
     *
     * @param userId 用户id
     * @return 收藏总数
     */
    long countCollectCountByUserId(Long userId);

    /**
     * 获取关注数
     *
     * @param userId 用户id
     * @return 关注数
     */
//    long countFollowCountByUserId(Long userId);

    /**
     * 获取红包总数
     *
     * @param userId 用户id
     * @return 红包总数
     */
    long countRedBagCountByUserId(Long userId);

    /**
     * 获取优惠卡券总数
     *
     * @param userId 用户id
     * @return 优惠卡券总数
     */
    long countCouponCountByUserId(Long userId);

    /**
     * 保存用户
     *
     * @param userVO
     * @return
     */
    int save(UserVO userVO);

    /**
     * 注册用户
     *
     * @param userDTO
     * @return
     */
    User save(UserDTO userDTO);

    @Async
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void send(User user);

    /**
//     * 发送短信
//     *
//     * @param user
//     * @return
////     */
    void senMsg(User user);

    /**发送邮件
     * @param user
     * @return
     */
    void senEmail(User user);


    void delete(Long userId);
}
