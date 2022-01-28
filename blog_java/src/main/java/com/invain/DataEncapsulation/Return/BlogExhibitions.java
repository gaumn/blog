package com.invain.DataEncapsulation.Return;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.invain.entity.Blog;
import com.invain.entity.Blogcomment;
import lombok.Data;

import java.util.Stack;

/**
 * @autor invain
 * @date 2022/1/28
 **/
@Data
public class BlogExhibitions {

    private Blog blogDate;
    private IPage blogCommentPage;
    static BlogExhibitions blogExhibitions =new BlogExhibitions();
    public static BlogExhibitions returnBlogExhibitions(Blog blogDate, IPage blogCommentPage){
        blogExhibitions.setBlogDate(blogDate);
        blogExhibitions.setBlogCommentPage(blogCommentPage);
        return blogExhibitions;
    }
    public static BlogExhibitions returnBlogComments ( IPage blogCommentPage){
        blogExhibitions.setBlogCommentPage(blogCommentPage);
        return blogExhibitions;
    }
}
