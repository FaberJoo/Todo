package com.codestates.todo.todo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Todo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 30, nullable = false)
  private String title;

  @Column(nullable = false, unique = false)
  private int todo_order;

  @Column
  private boolean completed;

  @Builder
  public Todo(Long id, String title, int todo_order, boolean completed) {
    this.id = id;
    this.title = title;
    this.todo_order = todo_order;
    this.completed = completed;
  }
}
