package pers.xsy.demo.exception;


import org.springframework.security.core.AuthenticationException;

public class VerficationCodeExcetion extends AuthenticationException {

    public VerficationCodeExcetion() {
        super("图形验证码校验失败");
    }
}
