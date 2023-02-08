package com.codestates.todo.todo;

import java.util.List;

public interface TodoService {
  public Todo addTodo(Todo todo);
  public List<Todo> getTodoList();
  public Todo getTodo(Long id);
  public Todo updateTodo(Todo todo);
  public void deleteTodoList();
  public void deleteTodo(Long id);

  public Todo findExistTodo(Long id);
}
