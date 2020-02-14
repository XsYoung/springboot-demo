/**
 * 
 */
package pers.xsy.demo.social.wechat.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;
import pers.xsy.demo.properties.SpringSecurityProperties;
import pers.xsy.demo.properties.WechatProperties;
import pers.xsy.demo.social.autoconfigure.SocialAutoConfigurerAdapter;
import pers.xsy.demo.social.wechat.connect.WechatConnectionFactory;


/**
 * 微信登录配置
 * @author Administrator
 */
@Configuration
@ConditionalOnProperty(prefix = "xsy.security.social.wechat", name = "app-id")
public class WechatAutoConfiguration extends SocialAutoConfigurerAdapter {

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
		WechatProperties weixinConfig = securityProperties.getSocial().getWechat();
		return new WechatConnectionFactory(weixinConfig.getProviderId(), weixinConfig.getAppId(),
				weixinConfig.getAppSecret());
	}
	
	/*@Bean({"connect/weixinConnect", "connect/weixinConnected"})
	@ConditionalOnMissingBean(name = "weixinConnectedView")
	public View weixinConnectedView() {
		return new ImoocConnectView();
	}*/
	
}
