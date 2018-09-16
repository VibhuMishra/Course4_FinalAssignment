package com.upgrad.ImageHoster.controller;

import com.upgrad.ImageHoster.common.ImageManager;
import com.upgrad.ImageHoster.model.Comment;
import com.upgrad.ImageHoster.model.Image;
import com.upgrad.ImageHoster.service.CommentService;
import com.upgrad.ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private ImageService imageService;


    @RequestMapping(value = "/image/{id}/{title}/comments/create",method = RequestMethod.POST)
    public String saveComment(@RequestParam("comment") String commentDescription,
                            @PathVariable("id") int imageId)
    {
        Image image = imageService.getById(imageId);
        Comment comment = new Comment(commentDescription,image);
        commentService.save(comment);
        return "redirect:/images/" + image.getId() + "/" + image.getTitle();
    }
}
