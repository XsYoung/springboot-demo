/**
 * 
 */
package pers.xsy.demo.properties;

import pers.xsy.demo.social.autoconfigure.SocialProperties;


/**
 * 微信登录配置项
 * @author Administrator
 */
public class WechatProperties extends SocialProperties {
	
	/**
	 * 第三方id，用来决定发起第三方登录的url，默认是 wechat。
	 */
	private String providerId = "wechat";

	/**
	 * @return the providerId
	 */
	public String getProviderId() {
		return providerId;
	}

	/**
	 * @param providerId the providerId to set
	 */
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	

}
