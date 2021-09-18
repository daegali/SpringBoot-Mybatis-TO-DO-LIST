package com.sample.todo.logic.user;

import com.sample.todo.dto.UserDto;
import com.sample.todo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    //로깅을 위한 변수
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;


    // 회원가입 페이지 이동

    @RequestMapping(value = "/join", method = RequestMethod.GET)
    public String join() {
        return "user/joinForm";
    }

    // 회원가입 처리
    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public String join(User user) {
        userService.createUser(user);
        logger.info("user sign up!");
        return "user/login";
    }

    //로그인 화면(GET)
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "user/login";
    }

    //	로그인(POST)
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, UserDto.LoginInfo user, Model model) {
        if(session.getAttribute("login") != null) {
            session.removeAttribute("login");
        }
        User loginuser = userService.loginCheck(user);
        System.out.println("loginuser" + loginuser);

        if(loginuser!=null) {				//	성공
            session.setAttribute("login",loginuser);
            model.addAttribute("viewList", userService.loginCheck(user));
            logger.info("success login");
            return "main";
        }						//	실패
        logger.info("fail login");
        return "user/login";
    }

    //	로그아웃
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate();
        logger.info("ByeBye Logout success");
        return "user/login";
    }

    //	메인화면
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main() {
        return "main";
    }

}
