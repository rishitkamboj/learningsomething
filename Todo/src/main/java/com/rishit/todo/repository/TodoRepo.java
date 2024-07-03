package com.rishit.todo.repository;

import com.rishit.todo.entity.Todo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface TodoRepo extends MongoRepository<Todo, ObjectId> {

}
