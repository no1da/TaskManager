package bySharko.TaskManager.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;

@Schema(description = "Сущность задачи")
public class TaskStateDTO {
    @Null(message = "ID генерируется автоматически")
    @Schema(description = "Идентефикатор задачи")
    private int id;
    @Size(min = 2, max = 50)
    @NotNull(message = "Название не должно быть пустым")
    @Schema(description = "Название задачи")
    private String title;
    @Size(min = 2, max = 2000)
    @NotNull(message = "Описание не должно быть пустым")
    @Schema(description = "Описание задачи")
    private String description;
    @NotNull(message = "Укажите ID статуса")
    @Schema(description = "Идентефикатор статуса")
    private int status_id;
    @NotNull(message = "ID автора берётся из контекста")
    @Schema(description = "Идентефикатор автора")
    private int author_id;
    @NotNull(message = "Укажите ID приоритета")
    @Schema(description = "Идентефикатор приоритета")
    private int priority_id;
    @NotNull(message = "Укажите ID исполнителя")
    @Schema(description = "Идентефикатор исполнителя")
    private int assignee_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getAssignee_id() {
        return assignee_id;
    }

    public void setAssignee_id(int assignee_id) {
        this.assignee_id = assignee_id;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public int getPriority_id() {
        return priority_id;
    }

    public void setPriority_id(int priority_id) {
        this.priority_id = priority_id;
    }

    @Override
    public String toString() {
        return "TaskStateDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status_id=" + status_id +
                ", author_id=" + author_id +
                ", priority_id=" + priority_id +
                ", assignee_id=" + assignee_id +
                '}';
    }
}

