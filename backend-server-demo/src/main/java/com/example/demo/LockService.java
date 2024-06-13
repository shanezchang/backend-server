package com.yt.wms.deliverybiz.service.impl;

import com.yt.wms.deliverybiz.BusinessException;
import com.yt.wms.deliverybiz.ErrorConstant;
import com.yt.wms.deliverybiz.service.ILockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class LockService implements ILockService {

    private final StringRedisTemplate stringRedisTemplate;

    public LockService(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public boolean distLock(String key, int timeout) {
        if (Boolean.FALSE.equals(stringRedisTemplate.opsForValue().setIfAbsent(key,
                "1", timeout, TimeUnit.SECONDS))) {
            log.info("get lock fail");
            return false;
        }
        return true;
    }

    @Override
    public boolean distLock(String key) {
        return distLock(key, 60);
    }

    @Override
    public boolean distUnLock(String key) {
        stringRedisTemplate.delete(key);
        return true;
    }

    @Override
    public Long distUnLock(List<String> keys) {
        if(keys == null || keys.isEmpty()) {
            return 0L;
        }
        return stringRedisTemplate.delete(keys);
    }

    @Override
    public void spiralLock(String key, int cntLimit) {
        this.spiralLock(key, cntLimit, ErrorConstant.ORDER_LOCKED_ERROR_CODE, ErrorConstant.ORDER_LOCKED_ERROR_MSG);
    }

    @Override
    public void spiralLock(String key, int cntLimit, int errorCode, String errorMsg) {
        int cnt = 0;
        boolean lock;
        while(cnt != cntLimit) {
            try {
                lock = distLock(key);
                if(lock) {
                    return;
                }
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            cnt++;
        }
        throw new BusinessException(errorCode, errorMsg);
    }
}
