package com.haizhang.hai.bussiness.service;

import java.util.concurrent.Future;

public interface AsyncService {

    Future<Long> queryUserMsgCount(Long userId);

    Future<Long> queryCollectCount(Long userId);
}
