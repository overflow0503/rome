package com.weelfly.manage.service.impl;

import com.weelfly.cache.client.JedisClient;
import com.weelfly.common.GlobalConstant;
import com.weelfly.manage.service.CaptchaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 */
@Service
public class CaptchaServiceImpl implements CaptchaService {
    @Resource
    private JedisClient jedisClient;

    @Override
    public boolean set(String captchaStoreKey, String captcha) {
        return "ok".equalsIgnoreCase(
                jedisClient.setEx(captchaStoreKey, captcha, GlobalConstant.CAPTCHA_TIME_OUT_SECOND)
        );
    }

    @Override
    public boolean validate(String sessionId, String inputCaptcha) {
        if (StringUtils.isEmpty(inputCaptcha)) {
            return false;
        }
        if (!inputCaptcha.equalsIgnoreCase(this.jedisClient.get(sessionId))) {
            return false;
        }
        this.clear(sessionId);
        return true;
    }

    @Override
    public boolean clear(String sessionId) {
        return jedisClient.del(sessionId) > 0;
    }
}
