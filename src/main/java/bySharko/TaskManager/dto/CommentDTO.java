package bySharko.TaskManager.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
@Schema(description = "Сущность комментария")
public class CommentDTO {
    @Schema(description = "Идентификатор комментария")
    private int id;
    @Size(min = 2, max = 1000)
    @NotNull(message = "Сообщение не должно быть пустым")
    @Schema(description = "Содержание комментария")
    private String description;
    @NotNull(message = "Укажите ID автора")
    @Schema(description = "Идентификатор автора комментария")
    private int author_id;
    @NotNull(message = "Укажите ID задачи")
    @Schema(description = "Идентификатор задачи")
    private int task_id;

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    @Override
    public String toString() {
        return "CommentDTO{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", authorName=" + author_id +
                '}';
    }
}
