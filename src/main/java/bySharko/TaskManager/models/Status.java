package bySharko.TaskManager.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "Status")
@Schema(description = "Сущность статуса")
public class Status {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Идентификатор статуса")
    private int id;
    @Column(name = "status")
    @Schema(description = "Наиманование статуса")
    private String status;

    public Status(int id, String status) {
        this.id = id;
        this.status = status;
    }

    public Status() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
