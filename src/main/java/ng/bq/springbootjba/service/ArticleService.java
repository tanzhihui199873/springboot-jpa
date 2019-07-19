package ng.bq.springbootjba.service;


import ng.bq.springbootjba.entity.Article;
import ng.bq.springbootjba.entity.Nav;
import ng.bq.springbootjba.entity.NavModel;

import java.util.List;

/**
 * @ProjectName: demo
 * @Package: com.springboot.demo.service
 * @apiDescription
 * @Author: 智慧
 * @Date: 2019/7/17 20:33
 * @Version: 1.0
 **/

public interface ArticleService {
     boolean insertArticle(Article article);
     Article queryArticleById(String article_id);
     boolean editArticle(Article article);
     boolean deleteNewsById(String article_id);
     List<Article> queryArticleMapByPage() ;
     List<NavModel> queryNavAll();
}
