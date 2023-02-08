package com.codestates.todo.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class TodoController {
  private final TodoMapper mapper;
  private final TodoService todoService;

  @PostMapping
  public ResponseEntity postTodo(@RequestBody TodoDTO.Post post) {
    Todo todo = mapper.postDtoToTodo(post);
    Todo addedTodo = todoService.addTodo(todo);

    return new ResponseEntity(addedTodo, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity getTodoList() {
    List<Todo> todoList = todoService.getTodoList();

    return new ResponseEntity<>(todoList, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity getTodo(@PathVariable("id") Long id) {
    Todo todo = todoService.getTodo(id);

    return new ResponseEntity(todo, HttpStatus.OK);
  }

  @PatchMapping("/{id}")
  public ResponseEntity patchTodo(
      @PathVariable("id") Long id,
      @RequestBody TodoDTO.Patch patch
      ) {
    Todo todo = mapper.patchDtoToTodo(patch);
    todo.setId(id);

    Todo updatedTodo = todoService.updateTodo(todo);
    return new ResponseEntity(updatedTodo, HttpStatus.OK);
  }

  @DeleteMapping
  public ResponseEntity deleteTodoList() {
    todoService.deleteTodoList();
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity deleteTodo(@PathVariable Long id) {
    todoService.deleteTodo(id);
    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }
}
