package com.upgrad.ImageHoster.common;

import com.upgrad.ImageHoster.model.Comment;
import org.hibernate.Session;

@SuppressWarnings("unchecked")
public class CommentManager extends SessionManager {
    public void saveImage(final Comment comment) {
        Session session = openSession();
        session.save(comment);
        commitSession(session);
    }

}
