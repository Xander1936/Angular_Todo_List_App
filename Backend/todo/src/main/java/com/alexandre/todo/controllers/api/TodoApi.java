package com.alexandre.todo.controllers.api;

import com.alexandre.todo.dto.TodoDto;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

import static com.alexandre.todo.utils.Constants.APP_ROOT;


@Api(APP_ROOT + "/todos")
public interface TodoApi {

    @PostMapping(value = APP_ROOT + "/todos/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<TodoDto> createTodo(
            @ApiParam(value = "Todo DTO", required = true) @RequestBody TodoDto todoDto);

    @PatchMapping(value = APP_ROOT + "/todos/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<TodoDto> updateTodo(
            @ApiParam(value = "Todo DTO", required = true) @RequestBody TodoDto user);

    @GetMapping(value = APP_ROOT + "/todos/all", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<TodoDto>> getAllTodos();

    @GetMapping(value = APP_ROOT + "/todos/{todoId:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<TodoDto> getTodo(
            @ApiParam(value = "The Todo id", required = true) @PathParam(value = "todoId") Long todoId
    );

    @DeleteMapping(value = APP_ROOT + "/todos/delete/{id:.+}")
    ResponseEntity deleteTodo(
            @ApiParam(value = "The Todo id", required = true) Long id
    );
}
