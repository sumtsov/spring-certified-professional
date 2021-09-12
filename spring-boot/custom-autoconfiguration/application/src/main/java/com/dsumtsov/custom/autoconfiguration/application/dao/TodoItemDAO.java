package com.dsumtsov.custom.autoconfiguration.application.dao;

import com.dsumtsov.custom.autoconfiguration.application.model.TodoItem;
import org.springframework.data.repository.CrudRepository;

public interface TodoItemDAO extends CrudRepository<TodoItem, Long> {
}
