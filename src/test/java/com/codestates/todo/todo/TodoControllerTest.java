package com.codestates.todo.todo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TodoController.class)
public class TodoControllerTest {
  @Autowired
  MockMvc mockMvc;

  @DisplayName("할 일 생성")
  @Test
  void postTodo() throws Exception {
    ResultActions action = mockMvc.perform(
        post("/")
            .contentType(MediaType.APPLICATION_JSON));

    action
        .andExpect(status().isCreated());
  }

  @DisplayName("할 일 리스트 조회")
  @Test
  void getTodoList() throws Exception {
    ResultActions action = mockMvc.perform(
        get("/")
            .contentType(MediaType.APPLICATION_JSON));

    action
        .andExpect(status().isOk());
  }

  @DisplayName("할 일 조회")
  @Test
  void getTodo() throws Exception {
    long id = 1L;

    ResultActions action = mockMvc.perform(
        get("/{id}", id)
            .contentType(MediaType.APPLICATION_JSON));

    action
        .andExpect(status().isOk());
  }

  @DisplayName("할 일 수정")
  @Test
  void patchTodo() throws Exception {
    long id = 1L;

    ResultActions action = mockMvc.perform(
        patch("/{id}", id)
            .contentType(MediaType.APPLICATION_JSON));

    action
        .andExpect(status().isOk());
  }

  @DisplayName("할 일 리스트 삭제")
  @Test
  void deleteTodoList() throws Exception {
    ResultActions action = mockMvc.perform(
        delete("/")
            .contentType(MediaType.APPLICATION_JSON));

    action
        .andExpect(status().isNoContent());
  }

  @DisplayName("할 일 삭제")
  @Test
  void deleteTodo() throws Exception {
    long id = 1L;

    ResultActions action = mockMvc.perform(
        delete("/{id}", id)
            .contentType(MediaType.APPLICATION_JSON));

    action
        .andExpect(status().isNoContent());
  }
}
