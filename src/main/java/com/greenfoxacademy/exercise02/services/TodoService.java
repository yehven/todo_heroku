package com.greenfoxacademy.exercise02.services;

import com.greenfoxacademy.exercise02.models.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TodoService {

  List<Todo> getAlltodos();
  Todo getTodo(int id);
  void modifyTitle(Todo todo);
  void save (Todo todo);
  void delete(int id);

}
