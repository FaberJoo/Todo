package com.codestates.todo.todo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class TodoController {
  @PostMapping
  public String postTodo() {
    return "Post";
  }

  @GetMapping
  public String getTodoList() {
    return "Get All";
  }

  @GetMapping("/{id}")
  public String getTodo(@PathVariable String id) {
    return "Get";
  }

  @PatchMapping("/{id}")
  public String postTodo(@PathVariable String id) {
    return "Patch";
  }

  @DeleteMapping
  public String deleteTodoList() {
    return "Delete All";
  }

  @DeleteMapping("/{id}")
  public String deleteTodo(@PathVariable String id) {
    return "Delete";
  }
}
