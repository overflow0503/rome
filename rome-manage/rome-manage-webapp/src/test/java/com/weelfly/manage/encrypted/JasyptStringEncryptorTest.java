package com.weelfly.manage.encrypted;


import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JasyptStringEncryptorTest {

    /**
     * 前提是配置文件设置了 用于加密/解密属性的主密码
     * <pre>
     *     jasypt:
     *       encryptor:
     *         password: 你的密钥
     * </pre>
     * <p>
     * 使用示例 : ENC(加密串)
     */
    @Resource
    private StringEncryptor stringEncryptor;

    @Test
    public void name() throws Exception {
        final String username = stringEncryptor.encrypt("root");
        final String password = stringEncryptor.encrypt("root");

        System.err.println("username = " + username);
        System.err.println("password = " + password);

    }
}
