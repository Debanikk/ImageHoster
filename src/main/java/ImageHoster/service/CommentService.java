package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.model.User;
import ImageHoster.repository.CommentRepository;
import ImageHoster.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public void uploadComment(Comment comment) {
        commentRepository.uploadComment(comment);
    }

}
