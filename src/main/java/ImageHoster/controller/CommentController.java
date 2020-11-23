package ImageHoster.controller;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Controller
public class CommentController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(value="/image/{imageId}/{imageTitle}/comments", method = RequestMethod.POST)
    public String uploadComment(@RequestParam("comment") String comment, @PathVariable("imageId") Integer imageId , @PathVariable("imageTitle") String imageTitle ,HttpSession session){
        User user = (User) session.getAttribute("loggeduser");
        Image image = imageService.getImageByTitle(imageId, imageTitle);
        Comment newComment = new Comment();
        newComment.setImage(image);
        newComment.setUser(user);
        newComment.setText(comment);
        newComment.setCreatedDate(LocalDate.now());
        commentService.uploadComment(newComment);
        return "redirect:/images/" + newComment.getImage().getId() + "/" + newComment.getImage().getTitle();
    }
}
