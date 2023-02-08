package com.codestates.todo.todo;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TodoMapper {
  Todo postDtoToTodo(TodoDTO.Post post);
  Todo patchDtoToTodo(TodoDTO.Patch patch);
}
