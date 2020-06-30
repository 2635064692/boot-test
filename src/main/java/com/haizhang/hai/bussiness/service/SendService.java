package com.haizhang.hai.bussiness.service;

import com.haizhang.hai.bussiness.model.entity.User;

public interface SendService {


    /**
     * 发送短信
     *
     * @param user
     * @return
     */
    Boolean senMsg(User user);

    /**发送邮件
     * @param user
     * @return
     */
    Boolean senEmail(User user);
}
