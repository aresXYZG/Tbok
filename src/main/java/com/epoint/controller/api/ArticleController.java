package com.epoint.controller.api;

import com.epoint.model.dto.ArticleDTO;
import com.epoint.model.entity.Article;
import com.epoint.model.enums.ArticleType;
import com.epoint.model.params.ArticleParam;
import com.epoint.model.vo.ArticleCondition;
import com.epoint.service.ArticleService;
import com.epoint.utils.MapResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/articles")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    /*
    根据条件获取文章列表
     */
    @GetMapping
    public Map<String, Object> articles(@RequestParam(defaultValue = "1",value = "currentPage") Integer pageNumber, @RequestParam(defaultValue = "10") Integer pageSize,ArticleCondition condition) {
        PageHelper.startPage(pageNumber, pageSize);
        PageInfo<Article> list = new PageInfo<>(articleService.findArticlesByCondtion(condition));
        return MapResult.ArticleResult(articleService.convertTo(list.getList()),list.getTotal());
    }

    /*
    显示文章的类型列表以及数量
     */
    @GetMapping("articleGroup")
    public List<Integer> getGroupByType() {
        return articleService.getGroupByType();
    }

    @PutMapping
    public void update(@RequestBody ArticleParam articleParam) {

        Article article = articleParam.convertTo();
        articleService.update(article);
    }


    @DeleteMapping
    public void delete(@RequestParam("ids") String ids) {
        articleService.deleteByIds(ids);
    }

}
