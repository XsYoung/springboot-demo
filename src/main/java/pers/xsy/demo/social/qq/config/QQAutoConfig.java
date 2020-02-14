/**
 *
 */
package pers.xsy.demo.social.qq.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;
import pers.xsy.demo.properties.QQProperties;
import pers.xsy.demo.properties.SpringSecurityProperties;
import pers.xsy.demo.social.autoconfigure.SocialAutoConfigurerAdapter;
import pers.xsy.demo.social.qq.connet.QQConnectionFactory;


/**
 * @author Administrator
 *
 */
@Configuration
@ConditionalOnProperty(prefix = "xsy.security.social.qq", name = "app-id")
public class QQAutoConfig extends SocialAutoConfigurerAdapter {

    @Autowired
    private SpringSecurityProperties securityProperties;

    /*
     * (non-Javadoc)
     *
     * @see
     * org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter
     * #createConnectionFactory()
     */
    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        QQProperties qqConfig = securityProperties.getSocial().getQq();
        return new QQConnectionFactory(qqConfig.getProviderId(), qqConfig.getAppId(), qqConfig.getAppSecret());
    }

}
