package com.alexandre.todo.controllers.api;

import com.alexandre.todo.dto.UserDto;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.alexandre.todo.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/users")
public interface UserApi {

    @PostMapping(value = APP_ROOT + "/users/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserDto> createUser(
            @ApiParam(value = "User DTO", required = true) @RequestBody UserDto user);

    @PatchMapping(value = APP_ROOT + "/users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserDto> updateUser(
            @ApiParam(value = "User ID", required = true) Long id,
            @ApiParam(value = "User DTO", required = true) @RequestBody UserDto user);

    @GetMapping(value = APP_ROOT + "/users/all", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<UserDto>> getAllUsers();

    @GetMapping(value = APP_ROOT + "/users/{id:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserDto> getUser(
            @ApiParam(value = "The use id", required = true) Long id
    );

    @DeleteMapping(value = APP_ROOT + "/users/delete/{id:.+}")
    ResponseEntity deleteUser(
            @ApiParam(value = "The use id", required = true) Long id
    );
}
