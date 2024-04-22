package bySharko.TaskManager.models;

public class Comment {
    private int id;
    private String description;
    private Person author_id;
    private Task task_id;

    public Comment(int id, String description, Person author_id, Task task_id) {
        this.id = id;
        this.description = description;
        this.author_id = author_id;
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

    public Person getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Person author_id) {
        this.author_id = author_id;
    }

    public Task getTask_id() {
        return task_id;
    }

    public void setTask_id(Task task_id) {
        this.task_id = task_id;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", author_id=" + author_id +
                ", task_id=" + task_id +
                '}';
    }
}
