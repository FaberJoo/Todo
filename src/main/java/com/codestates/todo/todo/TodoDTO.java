package com.codestates.todo.todo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Optional;

public class TodoDTO {
  @NoArgsConstructor
  @Getter
  public static class Post {
    private String title;
    private int todo_order;
    private boolean completed;

    @Builder
    public Post(String title, int todo_order, boolean completed) {
      this.title = title;
      this.todo_order = todo_order;
      this.completed = completed;
    }
  }

  @NoArgsConstructor
  public static class Patch {
    private Optional<String> title;
    private Optional<Integer> todo_order;
    private Optional<Boolean> completed;

    public String getTitle() {
      return title.get();
    }

    public Integer getTodo_order() {
      return todo_order.get();
    }

    public Boolean getCompleted() {
      return completed.get();
    }

    @Builder
    public Patch(Optional<String> title, Optional<Integer> todo_order, Optional<Boolean> completed) {
      this.title = title;
      this.todo_order = todo_order;
      this.completed = completed;
    }
  }

  @NoArgsConstructor
  @Getter
  public static class Response {
    private Long id;
    private String title;
    private int todo_order;
    private boolean completed;

    @Builder
    public Response(Long id, String title, int todo_order, boolean completed) {
      this.id = id;
      this.title = title;
      this.todo_order = todo_order;
      this.completed = completed;
    }
  }
}
