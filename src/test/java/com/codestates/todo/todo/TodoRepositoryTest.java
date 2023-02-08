package com.codestates.todo.todo;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
@DataJpaTest
public class TodoRepositoryTest {

  @Autowired
  private TodoRepository todoRepository;

  Todo todo1;

  @BeforeEach
  void beforeEach() {
    todo1 = Todo.builder()
        .title("일어나기")
        .todo_order(0)
        .completed(false)
        .build();

    Todo todo2 = Todo.builder()
        .title("식사하기")
        .todo_order(0)
        .completed(false)
        .build();

    todoRepository.save(todo1);
    todoRepository.save(todo2);
  }

  @DisplayName("할 일 저장")
  @Test
  void saveTodo() {
    Todo todo = Todo.builder()
        .title("인사하기")
        .todo_order(1)
        .completed(false)
        .build();

    Todo savedTodo = todoRepository.save(todo);
    assertNotNull(savedTodo);
    assertThat(savedTodo.getId()).isEqualTo(todo.getId());
  }

  @DisplayName("할 일 리스트 조회")
  @Test
  void findTodoList() {
    List<Todo> todoList = todoRepository.findAll();
    assertNotNull(todoList);
    assertThat(todoList.size()).isEqualTo(2);
  }

  @DisplayName("할 일 조회")
  @Test
  void findTodo() {
    Todo findedTodo = todoRepository.findById(todo1.getId()).get();
    assertNotNull(findedTodo);
    assertThat(findedTodo.getTodo_order()).isEqualTo(todo1.getTodo_order());
  }

  @DisplayName("할 일 수정")
  @Test
  void updateTodo() {
    Todo findedTodo = todoRepository.findById(todo1.getId()).get();
    assertNotNull(findedTodo);

    findedTodo.setTitle("잠자기");
    findedTodo.setTodo_order(5);
    findedTodo.setCompleted(true);

    Todo updatedTodo = todoRepository.save(findedTodo);

    assertThat(updatedTodo.getTitle()).isEqualTo(findedTodo.getTitle());
    assertThat(updatedTodo.getTodo_order()).isEqualTo(findedTodo.getTodo_order());
    assertThat(updatedTodo.isCompleted()).isEqualTo(findedTodo.isCompleted());
  }

  @DisplayName("할 일 리스트 삭제")
  @Test
  void deleteTodoList() {
    todoRepository.deleteAll();
    List<Todo> todoList = todoRepository.findAll();
    assertThat(todoList.size()).isEqualTo(0);
  }

  @DisplayName("할 일 삭제")
  @Test
  void deleteTodo() {
    Todo todo = todoRepository.findById(todo1.getId()).get();

    todoRepository.delete(todo);
    assertTrue(todoRepository.findById(todo.getId()).isEmpty());
  }
}
