package sardor_777.taqdimotapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDto {
    private String firstname;
    private String lastname;
    private LocalDateTime date;
    private String email;
    private String password;
    private String role;
    private LocalDateTime createdat;
}
