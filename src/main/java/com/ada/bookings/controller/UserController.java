package com.ada.bookings.controller;

import com.ada.bookings.controller.dto.UserDto;
import com.ada.bookings.entity.UserEntity;
import com.ada.bookings.service.users.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author <a href="davidh.morenoh@outlook.com">David Moreno Hernandez</a>
 * @version 1.0.0
 * @since 1.0.0
 **/
@RestController
@RequestMapping("/v1/users/")
public class UserController {

    private final IUserService userService;

    public UserController(@Autowired IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public ResponseEntity<UserDto> create(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(new UserDto(userService.save(new UserEntity(userDto))));
    }

    @GetMapping("{email}")
    public ResponseEntity<UserDto> getEmail(@PathVariable String email) {
        return ResponseEntity.status(HttpStatus.OK).body(new UserDto(userService.findByEmail(email)));
    }

}