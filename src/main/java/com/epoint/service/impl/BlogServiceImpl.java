package com.epoint.service.impl;

import com.epoint.core.AbstractService;
import com.epoint.dao.BlogMapper;
import com.epoint.entity.Blog;
import com.epoint.service.BlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class BlogServiceImpl extends AbstractService<Blog> implements BlogService{
    @Resource
    private BlogMapper blogMapper;

    @Override
    public List<Blog> findByTypeId(int id) {
        return blogMapper.findByTypeId(id);
    }

    @Override
    public List<Blog> findAllByCreateTimeDesc() {
        return null;
    }

    @Override
    public List<Blog> findTop5Views() {
        return null;
    }

    @Override
    public List<Blog> findAllByTypeIdAndCreateTimeDesc(int id) {
        return null;
    }

    @Override
    public List<Blog> findAllByTagIdAndCreateTimeDesc(int id) {
        return null;
    }

    @Override
    public Map<String, List<Blog>> archiveBlogList() {
        return null;
    }

    @Override
    public Integer blogCount() {
        return null;
    }

    @Override
    public List<Blog> findAllByUpdateTimeDesc() {
        return null;
    }
}