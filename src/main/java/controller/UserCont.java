package controller;

import dto.UserDto;
import model.Result;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserCont {
        @Autowired
        UserService userService;

        @GetMapping("/{id}")
        public User byid(@PathVariable Long id) {
            return userService.byid(id);
        }

        @PostMapping
        public Result add(@RequestBody UserDto userDto) {
            Result result = userService.create(userDto);
            return result;
        }

        @PutMapping("/{id}")
        public Result edit(@PathVariable Long id, @RequestBody UserDto userDto){
            Result result = userService.update(id, userDto);
            return result;
        }

        @DeleteMapping("/{id}")
        public Result del(@PathVariable Long id){
            return userService.delete(id);
        }
}
