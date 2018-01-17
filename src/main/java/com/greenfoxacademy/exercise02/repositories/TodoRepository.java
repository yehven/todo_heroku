package com.greenfoxacademy.exercise02.repositories;

import com.greenfoxacademy.exercise02.models.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Integer> {

}
