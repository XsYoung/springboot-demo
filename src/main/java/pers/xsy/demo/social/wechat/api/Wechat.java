/**
 * 
 */
package pers.xsy.demo.social.wechat.api;

/**
 * 微信API调用接口
 * 
 * @author Administrator
 *
 */
public interface Wechat {

	/* (non-Javadoc)
	 * @see com.ymt.pz365.framework.security.social.api.SocialUserProfileService#getUserProfile(java.lang.String)
	 */
	WechatUserInfo getUserInfo(String openId);
	
}
