/**
 * 
 */
package pers.xsy.demo.social.qq.support;

import org.springframework.social.security.SocialAuthenticationFilter;

/**
 * SocialAuthenticationFilter后处理器，用于在不同环境下个性化社交登录的配置
 * 
 * @author Administrator
 *
 */
public interface SocialAuthenticationFilterPostProcessor {
	
	/**
	 * @param socialAuthenticationFilter
	 */
	void process(SocialAuthenticationFilter socialAuthenticationFilter);

}
