package com.codestates.todo.todo;

import com.codestates.todo.Exception.CustomException;
import com.codestates.todo.Exception.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TodoServiceImpl implements TodoService{
  private final TodoRepository todoRepository;

  @Override
  public Todo addTodo(Todo todo) {
    return todoRepository.save(todo);
  }

  @Override
  public List<Todo> getTodoList() {
    return todoRepository.findAll();
  }

  @Override
  public Todo getTodo(Long id) {
    return findExistTodo(id);
  }

  @Override
  public Todo updateTodo(Todo todo) {
    findExistTodo(todo.getId());

    Optional.ofNullable(todo.getTitle())
        .ifPresent(todo::setTitle);
    Optional.ofNullable(todo.getTodo_order())
        .ifPresent(todo::setTodo_order);
    Optional.ofNullable(todo.isCompleted())
        .ifPresent(todo::setCompleted);

    return todoRepository.save(todo);
  }

  @Override
  public void deleteTodoList() {
    todoRepository.deleteAll();
  }

  @Override
  public void deleteTodo(Long id) {
    Todo findedTodo = findExistTodo(id);
    todoRepository.delete(findedTodo);
  }

  @Override
  public Todo findExistTodo(Long id) {
    Optional<Todo> optionalTodo = todoRepository.findById(id);
    Todo findedTodo = optionalTodo.orElseThrow(() ->
        new CustomException(ExceptionCode.TODO_NOT_FOUND));
    return findedTodo;
  }
}
