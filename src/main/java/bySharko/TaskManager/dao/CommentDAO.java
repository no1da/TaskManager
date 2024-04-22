package bySharko.TaskManager.dao;

import bySharko.TaskManager.dto.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CommentDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<CommentDTO> getById(int id) {
        return jdbcTemplate.query("Select id, description, author_id, task_id from comment where task_id = ?",
                new BeanPropertyRowMapper<>(CommentDTO.class), id);
    }

    public void save(CommentDTO comment, int userID, int id) {
        String insert = "insert into Comment (description, author_id, task_id) VALUES (?, ?, ?)";
        jdbcTemplate.update(insert, comment.getDescription(), userID, id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM comment WHERE id=?", id);
    }

    public void deleteByTaskID(int id) {
        jdbcTemplate.update("DELETE FROM comment WHERE task_id=?", id);}

}
