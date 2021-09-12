package com.dsumtsov.custom.autoconfiguration.application.controller;

import com.dsumtsov.custom.autoconfiguration.application.dao.TodoItemDAO;
import com.dsumtsov.custom.autoconfiguration.application.model.TodoItem;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/v1/todos",
        produces = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class TodoController {

    private final TodoItemDAO todoItemDAO;

    @GetMapping
    public List<TodoItem> getAllTodos() {
        return Lists.newArrayList(todoItemDAO.findAll());
    }

    @PostMapping
    public TodoItem addTodo(@RequestBody TodoItem todoItem) {
        todoItemDAO.save(todoItem);
        return todoItem;
    }
}
