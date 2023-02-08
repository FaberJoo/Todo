package com.codestates.todo.todo;

import java.util.List;

public interface TodoService {
  public Todo addTodo(Todo todo);
  public List<Todo> getTodoList();
  public Todo getTodo(Long id);
  public Todo updateTodo(Long id);
  public void deleteTodoList();
  public void deleteTodo(Long id);
}
