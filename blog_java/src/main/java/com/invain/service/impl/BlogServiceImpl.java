package com.invain.service.impl;

import com.invain.entity.Blog;
import com.invain.mapper.BlogMapper;
import com.invain.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author invain
 * @since 2022-01-26
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
