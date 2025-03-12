package com.sb02.todoapp.service;

import com.sb02.todoapp.application.TodoCreationDto;
import com.sb02.todoapp.application.TodoDto;
import com.sb02.todoapp.application.TodosDto;
import com.sb02.todoapp.domain.Todo;
import com.sb02.todoapp.repository.TodoRepositoryImpl;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService{
    private final TodoRepositoryImpl todoRepositoryImpl;

    public TodoServiceImpl(TodoRepositoryImpl todoRepositoryImpl) {
        this.todoRepositoryImpl = todoRepositoryImpl;
    }

    public TodoDto createTodo(TodoCreationDto todoCreationDto) {
        Todo todo = new Todo(todoCreationDto.name(), todoCreationDto.description());
        return TodoDto.fromEntity(todoRepositoryImpl.save(todo));
    }

    public TodosDto findAll() {
        List<TodoDto> todos = todoRepositoryImpl.findAll()
                .stream()
                .map(TodoDto::fromEntity)
                .toList();

        return TodosDto.fromEntity(todos);
    }
}
