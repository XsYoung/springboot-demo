package pers.xsy.demo.configuration;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class MyWebAuthenticationDetails extends WebAuthenticationDetails {

    private boolean imageCodeIsRight;

    public MyWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        checkCaptcha(request);
    }

    private void checkCaptcha(HttpServletRequest request) {
        String imageCode = request.getParameter("captcha");
        HttpSession session = request.getSession();
        String savedImageCode = (String) session.getAttribute("captcha");
        if (!StringUtils.isEmpty(savedImageCode)) {
            //清除验证码
            session.removeAttribute("captcha");
            if (!StringUtils.isEmpty(imageCode) && imageCode.equalsIgnoreCase(savedImageCode)) {
                this.imageCodeIsRight = true;
            }
        }
    }

    public boolean getImageCodeIsRight() {
        return this.imageCodeIsRight;
    }


}
