package sardor_777.taqdimotapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sardor_777.taqdimotapi.dto.UserDto;
import sardor_777.taqdimotapi.model.Result;
import sardor_777.taqdimotapi.model.User;
import sardor_777.taqdimotapi.repo.UserRepo;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    // read
    public List<User> getall() {
        return userRepo.findAll();
    }

    // read by id
    public User byid(Long id) {
        return userRepo.findById(id).get();
    }

    // create
    public Result create(UserDto userDto) {
        User user = new User();
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());

        userRepo.save(user);
        return new Result("Saqlandi", true);
    }

    // update
    public Result update(Long id, UserDto userDto) {
        Optional<User> userOptional = userRepo.findById(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setFirstname(userDto.getFirstname());
            user.setLastname(userDto.getLastname());
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());
            user.setRole(userDto.getRole());

            userRepo.save(user);

            return new Result("0'zgartirildi", true);
        }
        return new Result("Id topilmadi", true);
    }

    // delete
    public Result delete(Long id) {
        Optional<User> userOptional = userRepo.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            userRepo.delete(user);
            return new Result("Deleted", true);
        }
        return new Result("Id topilmadi", false);
    }
}
