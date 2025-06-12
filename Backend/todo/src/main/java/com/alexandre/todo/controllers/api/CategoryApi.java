package com.alexandre.todo.controllers.api;

import com.alexandre.todo.dto.CategoryDto;
import com.alexandre.todo.dto.TodoDto;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

import static com.alexandre.todo.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/categories")
public interface CategoryApi {

    @PostMapping(value = APP_ROOT + "/categories/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CategoryDto> createCategory(
            @ApiParam(value = "Category DTO", required = true) @RequestBody CategoryDto categoryDto);

    @PatchMapping(value = APP_ROOT + "/categories/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CategoryDto> updateCategory(
            @ApiParam(value = "Category DTO", required = true) @RequestBody CategoryDto user);

    @GetMapping(value = APP_ROOT + "/categories/all", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<CategoryDto>> getAllCategories();

    @GetMapping(value = APP_ROOT + "/categories/todos/{id:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<TodoDto>> getAllTodoByCategoriesId(
            @ApiParam(value = "Category ID", required = true) Long id
    );

    @GetMapping(value = APP_ROOT + "/categories/todos/today/{userId:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<TodoDto>> getAllTodoByCategoriesForToday(
            @ApiParam(value = "User ID", required = true) @PathParam("userId") Long userId
    );

    @GetMapping(value = APP_ROOT + "/categories/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<CategoryDto>> getAllCategoriesByUserId(
            @ApiParam(value = "User ID", required = true) Long id
    );

    @GetMapping(value = APP_ROOT + "/categories/{id:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CategoryDto> getCategory(
            @ApiParam(value = "The category id", required = true) @PathParam(value = "id") Long id
    );

    @DeleteMapping(value = APP_ROOT + APP_ROOT + "/categories/delete/{id:.+}")
    ResponseEntity deleteCategory(
            @ApiParam(value = "The category id", required = true) Long id
    );
}
