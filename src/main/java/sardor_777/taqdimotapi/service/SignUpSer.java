package sardor_777.taqdimotapi.service;

import sardor_777.taqdimotapi.dto.SignUpDto;
import sardor_777.taqdimotapi.model.Result;
import sardor_777.taqdimotapi.model.SignUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sardor_777.taqdimotapi.repo.SignUpRepo;


import java.util.List;
import java.util.Optional;

@Service
public class SignUpSer {
    @Autowired
    SignUpRepo signUpRepo;

    // read
    public List<SignUp> getall(){
        return signUpRepo.findAll();
    }

    // read by id
    public SignUp byid(Long id){
        return signUpRepo.findById(id).get();
    }

    // create
    public Result create(SignUpDto signUpDto) {
        SignUp signUp = new SignUp();
        signUp.setFirstname(signUpDto.getFirstname());
        signUp.setLastname(signUpDto.getLastname());
        signUp.setDate(signUpDto.getDate());
        signUp.setEmail(signUpDto.getEmail());
        signUp.setPassword(signUpDto.getPassword());

        signUpRepo.save(signUp);
        return new Result("Saqlandi",true);
    }

    // update
    public Result update(Long id , SignUpDto signUpDto) {
        Optional<SignUp> signUpOptional = signUpRepo.findById(id);

        if (signUpOptional.isPresent()) {
            SignUp signUp = signUpOptional.get();
            signUp.setFirstname(signUpDto.getFirstname());
            signUp.setLastname(signUpDto.getLastname());
            signUp.setDate(signUpDto.getDate());
            signUp.setEmail(signUpDto.getEmail());
            signUp.setPassword(signUpDto.getPassword());

            signUpRepo.save(signUp);

            return new Result("0'zgartirildi",true);
        }
        return new Result("Id topilmadi", true);
    }

    // delete
    public Result delete(Long id) {
        Optional<SignUp> signUpOptional = signUpRepo.findById(id);
        if (signUpOptional.isPresent()) {
            SignUp signUp = signUpOptional.get();
            signUpRepo.delete(signUp);
            return new Result("Deleted", true);
        }
        return new Result("Id topilmadi", false);
    }
}
