package ng.bq.springbootjba.controller;


import ng.bq.springbootjba.entity.Article;
import ng.bq.springbootjba.entity.Nav;
import ng.bq.springbootjba.entity.NavModel;
import ng.bq.springbootjba.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class ArticleController {
    @Autowired
    ArticleService articleService;
    @PostMapping("/api/addArticle" )
    public String insertArticle(Article article){
        article.setArticle_id(UUID.randomUUID().toString());
        boolean b = articleService.insertArticle(article);
        return "redirect:/api/queryArticleMapByPage";
    }

    @PutMapping("/api/addArticle" )
    public String editArticle(Article article) {
        boolean b = articleService.editArticle(article);
        return "redirect:/api/queryArticleMapByPage";
    }
    @DeleteMapping("/api/deleteNewsById/{id}" )
    public String deleteNewsById(@PathVariable("id") String id){
        boolean b = articleService.deleteNewsById(id);
        return "redirect:/api/queryArticleMapByPage";
    }
    @GetMapping("/api/queryArticleMapByPage" )
    public String queryArticleMapByPage(Model model) {
        List<Article> articles = articleService.queryArticleMapByPage();
        model.addAttribute("articles",articles);
        return "articleList";
    }

    //来到修改页面，查出当前员工，在页面的回显
    @GetMapping("/api/queryArticleById/{id}")
    public  String toEditPage(@PathVariable("id") String id,Model model){
        Article article = articleService.queryArticleById(id);
        List<NavModel> navs = articleService.queryNavAll();
        model.addAttribute("article",article);
        model.addAttribute("navs",navs);
        return "addArticle";
    }

    //来到添加页面
    @GetMapping("/api/toAddArticle")
    public String toAdd(Model model){
        List<NavModel> navs = articleService.queryNavAll();
        model.addAttribute("navs",navs);
        return "addArticle";
    }
}
