package sardor_777.taqdimotapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sardor_777.taqdimotapi.dto.FieldDto;
import sardor_777.taqdimotapi.dto.SignInDto;
import sardor_777.taqdimotapi.model.Field;
import sardor_777.taqdimotapi.model.Result;
import sardor_777.taqdimotapi.model.SignIn;
import sardor_777.taqdimotapi.repo.FieldRepo;
import sardor_777.taqdimotapi.repo.SignInRepo;

import java.util.List;
import java.util.Optional;

@Service
public class FieldSer {
    @Autowired
    FieldRepo fieldRepo;

    // read
    public List<Field> getall(){
        return fieldRepo.findAll();
    }

    // read by id
    public SignIn byid(Long id){
        return fieldRepo.findById(id).get();
    }

    // create
    public Result create(FieldDto fieldDto) {
        Field field = new Field();
        field.setDescription(fieldDto.getDescription());
        field.setCatagory(fieldDto.getCatagory());
        field.setIsavailable(fieldDto.getIsavailable());

        fieldRepo.save(field);
        return new Result("Saqlandi",true);
    }

    // update
    public Result update(Long id , FieldDto fieldDto) {
        Optional<Field> fieldOptional = fieldRepo.findById(id);

        if (fieldOptional.isPresent()) {
            Field field = fieldOptional.get();
            field.setDescription(fieldDto.getDescription());
            field.setCatagory(fieldDto.getCatagory());
            field.setIsavailable(fieldDto.getIsavailable());

            fieldRepo.save(field);
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
