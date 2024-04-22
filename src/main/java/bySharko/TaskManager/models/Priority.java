package bySharko.TaskManager.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "Priority")
@Schema(description = "Сущность приоритета")
public class Priority {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Идентификатор приоритета")
    private int id;
    @Column(name = "priority")
    @Schema(description = "Наименование приоритета")
    private String priority;

    public Priority() {
    }

    public Priority(int id, String priority) {
        this.id = id;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

}
