package bySharko.TaskManager.dao;

import bySharko.TaskManager.dto.TaskStateDTO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskDAO {
    private final JdbcTemplate jdbcTemplate;

    public TaskDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<TaskStateDTO> getList() {
/*        return jdbcTemplate.query("SELECT task.id, task.title, task.description, task.status_id, task.priority_id, "
                + "p1.name as author_name, p2.name as assignee_name FROM Task INNER JOIN person p1 ON task.author_id = p1.id "
                + "INNER JOIN person p2 ON task.assignee_id = p2.id", new BeanPropertyRowMapper<>(TaskStateDTO.class));*/
        return jdbcTemplate.query("SELECT id, title, description, status_id, priority_id, author_id, assignee_id FROM Task ",
                new BeanPropertyRowMapper<>(TaskStateDTO.class));
    }

    public List<TaskStateDTO> getListByAssigneeId(int id) {
/*        return jdbcTemplate.query("SELECT task.id, task.title, task.description, p1.name as author_name, p2.name as "
                + "assignee_name FROM Task INNER JOIN person p1 ON task.author_id = p1.id INNER JOIN person p2 ON "
                + "task.assignee_id = p2.id where p2.id=?", new BeanPropertyRowMapper<>(TaskStateDTO.class), id);*/
        return jdbcTemplate.query("SELECT id, title, description, status_id, priority_id, author_id, assignee_id FROM Task  " +
                "where assignee_id=?", new BeanPropertyRowMapper<>(TaskStateDTO.class), id);
    }

    public List<TaskStateDTO> getListByAuthorId(int id) {
/*        return jdbcTemplate.query("SELECT task.id, task.title, task.description, p1.name as author_name, p2.name as "
                + "assignee_name FROM Task INNER JOIN person p1 ON task.author_id = p1.id INNER JOIN person p2 ON "
                + "task.assignee_id = p2.id where p1.id=?", new BeanPropertyRowMapper<>(TaskStateDTO.class), id);*/
        return jdbcTemplate.query("SELECT id, title, description, status_id, priority_id, author_id, assignee_id FROM Task  " +
                "where author_id=?", new BeanPropertyRowMapper<>(TaskStateDTO.class), id);
    }


    public void save(TaskStateDTO taskStateDTO, int id) {
                String insert = "insert into Task (title, description, status_id, priority_id, author_id, assignee_id) " +
                        "VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(insert, taskStateDTO.getTitle(), taskStateDTO.getDescription(), taskStateDTO.getStatus_id(),
                taskStateDTO.getPriority_id(), id, taskStateDTO.getAssignee_id());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM task WHERE id=?", id);
    }

    public void update(TaskStateDTO taskStateDTO, int id) {
        jdbcTemplate.update("UPDATE task SET title=?, description=? WHERE id=?", taskStateDTO.getTitle(),
                taskStateDTO.getDescription(), id);
    }

    public int getAuthorByID (int id){
        return jdbcTemplate.queryForObject("SELECT author_id FROM Task where id=?", Integer.class, id);
    }

}
