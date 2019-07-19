package ng.bq.springbootjba.dao;


import ng.bq.springbootjba.entity.Article;
import ng.bq.springbootjba.entity.Nav;
import ng.bq.springbootjba.entity.NavModel;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @ProjectName: demo
 * @Package: com.springboot.demo.mapper
 * @apiDescription
 * @Author: 智慧
 * @Date: 2019/7/17 20:32
 * @Version: 1.0
 **/
@Component()
public interface ArticleDao {
    List<Article> queryArticleMapByPage() ;
    boolean insertArticle(Article article);
    Article queryArticleById(String article_id);
    boolean editArticle(Article article);
    boolean deleteNewsById(String article_id);
    List<NavModel> queryNavAll();
}
