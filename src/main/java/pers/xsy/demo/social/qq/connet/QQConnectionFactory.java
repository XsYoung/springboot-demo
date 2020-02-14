/**
 * 
 */
package pers.xsy.demo.social.qq.connet;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import pers.xsy.demo.social.qq.api.QQ;

/**
 * @author Administrator
 *
 */
public class QQConnectionFactory extends OAuth2ConnectionFactory<QQ> {

	public QQConnectionFactory(String providerId, String appId, String appSecret) {
		super(providerId, new QQServiceProvider(appId, appSecret), new QQAdapter());
	}

}
