package sardor_777.taqdimotapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserDto {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String role;
}
