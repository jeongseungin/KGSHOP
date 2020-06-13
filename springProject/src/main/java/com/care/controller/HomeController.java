package com.care.controller;

import java.util.HashMap;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.care.service.KakaoAPI;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
@Autowired
private KakaoAPI kakao;

@RequestMapping("kakaopay")
public String kakaopay() {
	return "kakaopay";
}

@RequestMapping("kakaologin")
public String kakaologin() {
	
	return "kakaologin";
}


@RequestMapping(value = "/oauth")
public String kakaoLogin(@RequestParam("code") String code, HttpSession session) {
	  String access_Token = kakao.getAccessToken(code);
	  HashMap<String, Object> userInfo = kakao.getUserInfo(access_Token);
	    //    클라이언트의 이메일이 존재할 때 세션에 해당 이메일과 토큰 등록
	    if (userInfo.get("email") != null) {
	        session.setAttribute("useremail", userInfo.get("email"));
	        session.setAttribute("usernickname", userInfo.get("nickname"));
	        session.setAttribute("access_Token", access_Token);
	       
	        
	    }
    return "logininfo";
}
@RequestMapping(value = "/kakaologout")
public String Logout(HttpSession session) {
	kakao.kakaoLogout((String)session.getAttribute("access_Token"));
    session.removeAttribute("access_Token");
    session.removeAttribute("usernickname");
    session.removeAttribute("useremail");

    return "home";
}   




}
