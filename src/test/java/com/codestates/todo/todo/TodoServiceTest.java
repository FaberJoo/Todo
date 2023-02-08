package com.codestates.todo.todo;

import com.codestates.todo.Exception.CustomException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {
  @Mock
  private TodoRepository todoRepository;

  @InjectMocks
  private TodoServiceImpl todoService;

  @DisplayName("할 일 추가")
  @Test
  void addTodo() {
    Todo todo = Todo.builder()
        .id(1L)
        .title("일어나기")
        .todo_order(0)
        .completed(false)
        .build();

    when(todoRepository.save(Mockito.any())).thenReturn(todo);

    Todo addedTodo = todoService.addTodo(todo);

    assertThat(addedTodo.getId()).isEqualTo(todo.getId());
  }

  @DisplayName("할 일 리스트 가져오기")
  @Test
  void getTodoList() {
    List<Todo> todoList = new ArrayList<>();

    Todo todo1 = Todo.builder()
        .id(1L)
        .title("일어나기")
        .todo_order(0)
        .completed(false)
        .build();

    Todo todo2 = Todo.builder()
        .id(2L)
        .title("식사하기")
        .todo_order(1)
        .completed(false)
        .build();

    todoList.add(todo1);
    todoList.add(todo2);

    when(todoRepository.findAll()).thenReturn(todoList);

    List<Todo> todos = todoService.getTodoList();

    assertThat(todos.size()).isEqualTo(todoList.size());
  }

  @DisplayName("할 일 가져오기")
  @Test
  void getTodo() {
    Todo todo = Todo.builder()
        .id(1L)
        .title("일어나기")
        .todo_order(0)
        .completed(false)
        .build();
    Optional<Todo> optionalTodo = Optional.of(todo);

    when(todoRepository.findById(Mockito.anyLong())).thenReturn(optionalTodo);

    Todo findedTodo = todoService.getTodo(1L);

    assertThat(findedTodo.getId()).isEqualTo(todo.getId());
  }

  @DisplayName("할 일 변경")
  @Test
  void updateTodo() {
    Todo todo = Todo.builder()
        .id(1L)
        .title("운동하기")
        .todo_order(1)
        .completed(true)
        .build();

    when(todoRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(todo));
    when(todoRepository.save(Mockito.any())).thenReturn(todo);

    Todo updatedTodo = todoService.updateTodo(todo);

    assertThat(updatedTodo.getTitle()).isEqualTo(todo.getTitle());
  }

  @DisplayName("할 일 초기화")
  @Test
  void deleteTodoList() {
    todoService.deleteTodoList();
    verify(todoRepository, times(1)).deleteAll();
  }

  @DisplayName("할 일 삭제")
  @Test
  void deleteTodo() {
    Todo todo = Todo.builder()
        .id(1L)
        .title("일어나기")
        .todo_order(0)
        .completed(false)
        .build();

    when(todoRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(todo));

    todoService.deleteTodo(todo.getId());

    verify(todoRepository).delete(todo);
  }
}
