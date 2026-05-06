package sardor_777.taqdimotapi.controller;

import sardor_777.taqdimotapi.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/signin")
public class SignInCont {
    @Autowired
    SignInSer signInSer;

    @GetMapping("/{id}")
    public SignIn byid(@PathVariable Long id) {
        return signInSer.byid(id);
    }

    @PostMapping
    public Result add(@RequestBody SignInDto signInDto) {
        Result result = signInSer.create(signInDto);
        return result;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Long id, @RequestBody SignInDto signInDto){
        Result result = signInSer.update(id, signInDto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result del(@PathVariable Long id) {
        return signInSer.delete(id);
    }
}
