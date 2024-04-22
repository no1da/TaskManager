package bySharko.TaskManager.services;

import bySharko.TaskManager.dao.CommentDAO;
import bySharko.TaskManager.dao.TaskDAO;
import bySharko.TaskManager.dto.TaskStateDTO;
import bySharko.TaskManager.util.CustomException;
import bySharko.TaskManager.util.GetUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskDAO taskDAO;
    private final CommentDAO commentDAO;
    private final GetUser getUser;

    @Autowired
    public TaskService(TaskDAO dao, CommentDAO commentDAO, GetUser getUser) {
        this.taskDAO = dao;
        this.commentDAO = commentDAO;
        this.getUser = getUser;
    }

    public List<TaskStateDTO> getAll() {
        return taskDAO.getList();
    }

    public List<TaskStateDTO> getByAuthorId(Authentication authentication) {
        return taskDAO.getListByAuthorId(getUser.getUserID(authentication));
    }

    public List<TaskStateDTO> getByAssigneeId(Authentication authentication) {
        return taskDAO.getListByAssigneeId(getUser.getUserID(authentication));
    }

    public void save(TaskStateDTO taskStateDTO, Authentication authentication) {
        int userId = getUser.getUserID(authentication);
        taskDAO.save(taskStateDTO, userId);
    }

    public void delete(int id, Authentication authentication) {
        Integer userId = getUser.getUserID(authentication);
        int authorId = taskDAO.getAuthorByID(id);
        if (userId.equals(authorId)) {
            commentDAO.deleteByTaskID(id);
            taskDAO.delete(id);
        } else {
            throw new CustomException("Ошибка доступа");
        }
    }

    public void update(TaskStateDTO taskStateDTO, int id, Authentication authentication) {
        Integer userId = getUser.getUserID(authentication);
        int authorId = taskDAO.getAuthorByID(id);
        if (userId.equals(authorId)) {
            taskDAO.update(taskStateDTO, id);
        } else {
            throw new CustomException("Ошибка доступа");
        }
    }
}
