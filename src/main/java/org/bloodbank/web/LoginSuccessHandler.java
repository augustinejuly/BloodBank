package org.bloodbank.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{

	@Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                   Authentication authentication) throws ServletException, IOException {
       
		
		System.out.println(">>>>>>>>>>> Authentication Handler <<<<<<<<<<<<<<<<<");
		HttpSession session = request.getSession(false);
		session.setAttribute("username",authentication.getName());
        super.onAuthenticationSuccess(request, response, authentication);
     }

}
