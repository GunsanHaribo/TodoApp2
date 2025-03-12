package com.sb02.todoapp.repository;

import com.sb02.todoapp.domain.Todo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public class TodoRepositoryImpl implements TodoRepository{
    private final Map<UUID, Todo> todos = new HashMap<>();

    public Todo save(Todo todo) {
        todos.put(todo.getId(), todo);

        return todo;
    }

    public List<Todo> findAll(){
        return todos.values()
                .stream()
                .toList();
    }
}
