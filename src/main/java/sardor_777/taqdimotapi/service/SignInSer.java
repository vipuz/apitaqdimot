package sardor_777.taqdimotapi.service;

import sardor_777.taqdimotapi.dto.SignInDto;
import sardor_777.taqdimotapi.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sardor_777.taqdimotapi.model.SignIn;
import sardor_777.taqdimotapi.repo.SignInRepo;

import java.util.List;
import java.util.Optional;

@Service
public class SignInSer {
    @Autowired
    SignInRepo signInRepo;

    // read
    public List<SignIn> getall(){
        return signInRepo.findAll();
    }

    // read by id
    public SignIn byid(Long id){
        return signInRepo.findById(id).get();
    }

    // create
    public Result create(SignInDto signInDto) {
        SignIn signIn = new SignIn();
        signIn.setEmail(signInDto.getEmail());
        signIn.setPassword(signInDto.getPassword());

        signInRepo.save(signIn);
        return new Result("Saqlandi",true);
    }

    // update
    public Result update(Long id , SignInDto signInDto) {
        Optional<SignIn> signInOptional = signInRepo.findById(id);

        if (signInOptional.isPresent()) {
            SignIn signIn = signInOptional.get();
            signIn.setEmail(signInDto.getEmail());
            signIn.setPassword(signInDto.getPassword());

            signInRepo.save(signIn);

            return new Result("0'zgartirildi",true);
        }
        return new Result("Id topilmadi", true);
    }

    // delete
    public Result delete(Long id) {
        Optional<SignIn> signInOptional = signInRepo.findById(id);
        if (signInOptional.isPresent()) {
            SignIn signIn = signInOptional.get();
            signInRepo.delete(signIn);
            return new Result("Deleted", true);
        }
        return new Result("Id topilmadi", false);
    }
}
