package ng.bq.springbootjba.controller;

import ng.bq.springbootjba.dao.UserDao;
import ng.bq.springbootjba.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller

public class LoginController {



    @Autowired
    LoginService loginService;
    @Autowired
    UserDao userDao;

//    @GetMapping(value = "/user/login")

    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                      @RequestParam("password") String password ,
                      Map<String,Object> map, HttpSession session){
        int a =loginService.countAllByUserNameAndPassword(username, password);
        String lastname=userDao.selectLastName(username);
        System.out.println(a);
//        System.out.println(lastname);
        if(a==0){
            map.put("msg","用户名密码错误");
            return "login";

        }else {
            session.setAttribute("loginUser",lastname);
//            session.setAttribute("message",a);
//            return "textajax";
            return "index";
        }



    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/hello")
    public String hello(){
        return "login";
//        return "textajax";
    }


}
