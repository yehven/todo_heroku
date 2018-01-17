package com.greenfoxacademy.exercise02;

import com.greenfoxacademy.exercise02.models.Todo;
import com.greenfoxacademy.exercise02.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exercise02Application implements CommandLineRunner{

	@Autowired
	TodoRepository todoRepository;

	public static void main(String[] args) {
		SpringApplication.run(Exercise02Application.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		todoRepository.save(new Todo(1,"daily task",false,false));
		todoRepository.save(new Todo(2,"make the beds",true,true));
		todoRepository.save(new Todo(3,"do the washing up",false,true));
		todoRepository.save(new Todo(4,"clean the bathroom and the kitchen",true,true));
		todoRepository.save(new Todo(5,"wipe all the surfaces with cloth",false,true));
		todoRepository.save(new Todo(6,"remove the grease",true,true));
		todoRepository.save(new Todo(7,"tidy up",false,false));
		todoRepository.save(new Todo(8,"throw away the rubbish",true,true));
		todoRepository.save(new Todo(9,"broom",false,true));
		todoRepository.save(new Todo(10,"sweep the floor",true,true));
		todoRepository.save(new Todo(11,"wash the floors",false,true));
		todoRepository.save(new Todo(12,"mop",true,true));
		todoRepository.save(new Todo(13,"vacuum the carpet",false,false));
		todoRepository.save(new Todo(14,"vacuuum the cleaner/hoover",true,true));
		todoRepository.save(new Todo(15,"dust the furniture",false,true));

	}
}

