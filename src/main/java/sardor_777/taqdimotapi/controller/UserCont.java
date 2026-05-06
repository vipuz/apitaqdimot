package sardor_777.taqdimotapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sardor_777.taqdimotapi.model.Result;
import sardor_777.taqdimotapi.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserCont {
        @Autowired
        UserService userService;

        @GetMapping("/{id}")
        public sardor_777.taqdimotapi.model.User byid(@PathVariable Long id) {
            return userService.byid(id);
        }

        @PostMapping
        public Result add(@RequestBody sardor_777.taqdimotapi.dto.UserDto userDto) {
            Result result = userService.create(userDto);
            return result;
        }

        @PutMapping("/{id}")
        public sardor_777.taqdimotapi.model.Result edit(@PathVariable Long id, @RequestBody sardor_777.taqdimotapi.dto.UserDto userDto){
            sardor_777.taqdimotapi.model.Result result = userService.update(id, userDto);
            return result;
        }

        @DeleteMapping("/{id}")
        public sardor_777.taqdimotapi.model.Result del(@PathVariable Long id){
            return userService.delete(id);
        }
}
