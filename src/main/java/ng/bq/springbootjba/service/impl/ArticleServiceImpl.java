package ng.bq.springbootjba.service.impl;


import ng.bq.springbootjba.dao.ArticleDao;
import ng.bq.springbootjba.entity.Article;
import ng.bq.springbootjba.entity.Nav;
import ng.bq.springbootjba.entity.NavModel;
import ng.bq.springbootjba.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @ProjectName: demo
 * @Package: com.springboot.demo.service.impl
 * @apiDescription
 * @Author: 智慧
 * @Date: 2019/7/17 20:33
 * @Version: 1.0
 **/
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleDao articleMapper;
    public boolean insertArticle(Article article){
        boolean b = articleMapper.insertArticle(article);
        return b;
    }
    public Article queryArticleById(String article_id){
        Article article = articleMapper.queryArticleById(article_id);
        return article;
    }
    public boolean editArticle(Article article) {
        boolean b = articleMapper.editArticle(article);
        return b;
    }
    public boolean deleteNewsById(String article_id){
        boolean b = articleMapper.deleteNewsById(article_id);
        return b;
    }
    public List<Article> queryArticleMapByPage() {
        List<Article> articles = articleMapper.queryArticleMapByPage();
        return articles;
    }

    @Override
    public List<NavModel> queryNavAll() {
        List<NavModel> navs = articleMapper.queryNavAll();
        return navs;
    }
}
