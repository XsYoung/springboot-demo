/**
 * 
 */
package pers.xsy.demo.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * @author Administrator
 */
@ConfigurationProperties(prefix = "xsy.security")
@Data
public class SpringSecurityProperties {

	/**
	 * 社交登录配置
	 */
	private SocialProperties social = new SocialProperties();

	
}

