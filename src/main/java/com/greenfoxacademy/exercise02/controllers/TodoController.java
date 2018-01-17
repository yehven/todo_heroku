package com.greenfoxacademy.exercise02.controllers;

import com.greenfoxacademy.exercise02.models.Todo;
import com.greenfoxacademy.exercise02.repositories.TodoRepository;
import com.greenfoxacademy.exercise02.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping("/todo")
public class TodoController {

  @Autowired
  TodoRepository todoRepository;

  @Autowired
  TodoService todoService;

  @GetMapping(value = {"/", "/list"})
  public String list (@RequestParam(value = "isActive", required = false) Boolean isActive, Model model){
    List<Todo> listOfTodos = new ArrayList<>();
    if (isActive == null) {
      todoRepository.findAll().forEach(listOfTodos::add);
    } else if (isActive) {
      listOfTodos = StreamSupport.stream(todoRepository.findAll().spliterator(), false)
              .filter(p -> p.isDone())
              .collect(Collectors.toList());
    } else {
      listOfTodos = StreamSupport.stream(todoRepository.findAll().spliterator(), false)
              .filter(p -> !p.isDone())
              .collect(Collectors.toList());
    }
    model.addAttribute("listOfTodos",listOfTodos);
    return "todoslist";
  }

  @PostMapping(value = "/add")
  public ModelAndView addElement (Model model, @ModelAttribute Todo todo){
    todoService.save(todo);
    return new ModelAndView("redirect:/todo/");
  }

  @GetMapping("/add")
  public String addElement(Model model){
    Todo todo = new Todo();
    model.addAttribute("todo", todo);
    return "add";
  }

  @PostMapping(value = "/", params = {"delete"})
  public String deleteTodo(final HttpServletRequest request) {
    final Integer todoId = Integer.valueOf(request.getParameter("delete"));
    todoService.delete(todoId);
    return "redirect:/todo/";
  }

  @GetMapping(value = "/edit/{todoId}")
  public String showEditForm(@PathVariable(name = "todoId") int todoId, Model model) {
    Todo todo = todoService.getTodo(todoId);
    model.addAttribute("todo", todo);
    return "edit";
  }

  @PostMapping("/edit/{todoId}")
  public String editTodo(@PathVariable int todoId, @ModelAttribute Todo todo) {
    todo.setId(todoId);
    todoService.modifyTitle(todo);
    return "redirect:/todo/";
  }

}

