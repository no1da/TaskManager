package bySharko.TaskManager.services;

import bySharko.TaskManager.dao.CommentDAO;
import bySharko.TaskManager.dto.CommentDTO;
import bySharko.TaskManager.util.GetUser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class CommentService {
    private final CommentDAO commentDAO;
    private final GetUser getUser;

    @Autowired
    public CommentService(CommentDAO commentDAO, GetUser getUser) {
        this.commentDAO = commentDAO;
        this.getUser = getUser;
    }


    public List<CommentDTO> getById(int id) {
        return commentDAO.getById(id);
    }

    public void save(@Valid CommentDTO comment, Authentication authentication, int id) {
        commentDAO.save(comment, getUser.getUserID(authentication), id);
    }

    public void delete(int id) {
        commentDAO.delete(id);
    }


}
