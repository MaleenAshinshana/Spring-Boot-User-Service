package lk.ijse.gdse.Proposed.Travel.Planning.System.Back.End.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminDTO {
    @Null(message = "Admin Id will auto generate")
    private String admin_id;
    @Pattern(regexp = "[A-Za-z ]+",message = "Admin name cannot be empty")
    private String name;
    @NotNull(message = "Admin Password cannot be empty")@Size(min = 5,max = 8)
    private String password;
    /*@NotBlank(message = "Role is required")*/
    private String roleType;
    public AdminDTO(String admin_id, String name, String password) {
        this.admin_id = admin_id;
        this.name = name;
        this.password = password;
    }

    public AdminDTO(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
