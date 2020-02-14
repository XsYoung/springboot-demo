/**
 * 
 */
package pers.xsy.demo.properties;

import lombok.Data;
import pers.xsy.demo.social.autoconfigure.SocialProperties;

/**
 * QQ登录配置项
 * 
 * 
 * @author Administrator
 *
 */
@Data
public class QQProperties extends SocialProperties {
	
	/**
	 * 第三方id，用来决定发起第三方登录的url，默认是 qq。
	 */
	private String providerId = "qq";
	
}
