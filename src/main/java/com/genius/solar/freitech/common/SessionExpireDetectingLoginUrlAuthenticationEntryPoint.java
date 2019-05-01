package com.genius.solar.freitech.common;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SessionExpireDetectingLoginUrlAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {

    public SessionExpireDetectingLoginUrlAuthenticationEntryPoint(String loginFormUrl) {
        super(loginFormUrl);
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

        if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        super.commence(request, response, authException);
    }

    @Override
    public String buildRedirectUrlToLoginPage(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) {
        String redirectUrl = super.buildRedirectUrlToLoginPage(request, response, authException);
        if (isRequestedSessionInvalid(request)) {
            redirectUrl += redirectUrl.contains("?") ? "&" : "?";
            redirectUrl += "timeout";
            request.getSession().invalidate();
        }
        return redirectUrl;
    }

    private boolean isRequestedSessionInvalid(HttpServletRequest request) {
        return request.getRequestedSessionId() != null && !request.isRequestedSessionIdValid();
    }
}