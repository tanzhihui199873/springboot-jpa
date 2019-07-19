package ng.bq.springbootjba.controller;

import ng.bq.springbootjba.dao.NavDao;
import ng.bq.springbootjba.entity.Nav;
import ng.bq.springbootjba.service.NavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class NavController {
    @Autowired
    NavService navService;
    @Autowired
    NavDao navDao;
    @GetMapping("/ulist1")
    public String showPage(Model model){
        List<Nav> list=navService.findAllByOrderByIdDesc();
        model.addAttribute("nav",list);
        return "tables1";
    }
    //来到添加页面
    @GetMapping("/nav")
    public String toAdd(Model model){
//        List<User> list=userService.findAll();
//        model.addAttribute("users",list);
        return "add1";
    }
    //添加操作
    @RequestMapping(value = "/addnav",method = RequestMethod.POST)
    public String insertNav(Nav nav1,Map<String,Object> map){
        navDao.save(nav1);
        map.put("msg","添加成功!!!");
        return "redirect:/ulist1";
    }
    //删除
    @DeleteMapping("/ulist1/{id}")
    public String delete(Nav nav1){
        navDao.delete(nav1);
        System.out.println("删除数据");
        return  "redirect:/ulist1";
    }

    //来到修改页面，查出当前员工，在页面的回显
    @GetMapping("/ulist1/{id}")
    public  String toEditPage(@PathVariable("id") Integer id,Model model){
        Nav nav1=navDao.getNavById(id);
        model.addAttribute("nav",nav1);
        return "add1";
    }

    //员工修改,需要提交员工id
    @PutMapping("/addnav")
    public String updateNav(Nav nav1, Map<String,Object> map){
        navDao.save(nav1);
        map.put("msg","修改成功");
        System.out.println("修改数据");
        return "redirect:/ulist1";

    }



}
