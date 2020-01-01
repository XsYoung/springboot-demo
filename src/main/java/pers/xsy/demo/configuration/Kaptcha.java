package pers.xsy.demo.configuration;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class Kaptcha {

    @Bean
    public Producer captcha(){
        Properties properties = new Properties();

        // 图片宽
        properties.setProperty("kaptcha.image.width", "150");
        // 图片高
        properties.setProperty("kaptcha.image.height", "50");
        // 字体
        properties.setProperty("kaptcha.textproducer.font.names", "微软雅黑");
        // 字体大小
        properties.setProperty("kaptcha.textproducer.font.size", "30");
        // 字体颜色
        properties.setProperty("kaptcha.textproducer.font.color", "blue");
        // 验证码长度
        properties.setProperty("kaptcha.textproducer.char.length", "4");
        // 图片边框
        properties.setProperty("kaptcha.border", "yes");
        // 图片边框颜色
        properties.setProperty("kaptcha.border.color", "234,236,236");
        // 图片边框宽度
        properties.setProperty("kaptcha.border.thickness", "5");
        // 背景颜色
        properties.setProperty("kaptcha.background.clear.from", "white");


        Config config = new Config(properties);

        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        defaultKaptcha.setConfig(config);

        return defaultKaptcha;
    }

}
