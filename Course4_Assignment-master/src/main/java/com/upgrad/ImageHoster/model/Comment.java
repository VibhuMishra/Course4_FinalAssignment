package com.upgrad.ImageHoster.model;

import javax.persistence.*;

@Entity
@Table(name="Comment")
public class Comment {

    @Id
    @Column(columnDefinition = "CommentId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentId;

    @Column(columnDefinition = "CommentDescription")
    private String commentDescription;

    @ManyToOne(fetch=FetchType.LAZY)
    private Image image;

    public String getCommentDescription() {
        return commentDescription;
    }

    public void setCommentDescription(String commentDescription) {
        this.commentDescription = commentDescription;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getCommentId() {
        return commentId;
    }

    public Comment(String commentDescription,Image image)
    {
        this.commentDescription = commentDescription;
        this.image = image;
    }

}
