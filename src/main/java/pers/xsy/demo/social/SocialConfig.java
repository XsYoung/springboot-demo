/**
 * 
 */
package pers.xsy.demo.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.security.SpringSocialConfigurer;
import pers.xsy.demo.properties.SpringSecurityProperties;
import pers.xsy.demo.social.qq.support.MySpringSocialConfigurer;
import pers.xsy.demo.social.qq.support.SocialAuthenticationFilterPostProcessor;

import javax.sql.DataSource;


/**
 * 社交登录配置主类
 * @author Administrator
 */
@Configuration
@EnableSocial
public class SocialConfig extends SocialConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private SpringSecurityProperties securityProperties;
	
	@Autowired(required = false)
	private ConnectionSignUp connectionSignUp;
	
	@Autowired(required = false)
	private SocialAuthenticationFilterPostProcessor socialAuthenticationFilterPostProcessor;

	/* (non-Javadoc)
	 * @see org.springframework.social.config.annotation.SocialConfigurerAdapter#getUsersConnectionRepository(org.springframework.social.connect.ConnectionFactoryLocator)
	 */
	@Override
	public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
		JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(dataSource,
				connectionFactoryLocator, Encryptors.noOpText());
		repository.setTablePrefix("sys_");
		if(connectionSignUp != null) {
			repository.setConnectionSignUp(connectionSignUp);
		}
		return repository;
	}
	
	/**
	 * 社交登录配置类，供浏览器或app模块引入设计登录配置用。
	 * @return
	 */
	@Bean
	public SpringSocialConfigurer mySocialSecurityConfig() {
		String filterProcessesUrl = securityProperties.getSocial().getFilterProcessesUrl();
		MySpringSocialConfigurer configurer = new MySpringSocialConfigurer(filterProcessesUrl);
		//configurer.signupUrl(securityProperties.getBrowser().getSignUpUrl());
		configurer.setSocialAuthenticationFilterPostProcessor(socialAuthenticationFilterPostProcessor);
		return configurer;
	}

	/**
	 * 用来处理注册流程的工具类
	 * 
	 * @param connectionFactoryLocator
	 * @return
	 */
	@Bean
	public ProviderSignInUtils providerSignInUtils(ConnectionFactoryLocator connectionFactoryLocator) {
		return new ProviderSignInUtils(connectionFactoryLocator,
				getUsersConnectionRepository(connectionFactoryLocator)) {
		};
	}
}
