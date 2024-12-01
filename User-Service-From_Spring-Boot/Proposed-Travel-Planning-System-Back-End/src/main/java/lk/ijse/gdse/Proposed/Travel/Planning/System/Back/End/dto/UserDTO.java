package lk.ijse.gdse.Proposed.Travel.Planning.System.Back.End.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class UserDTO {
    @Null(message = "User ID will auto generate")
    private String user_id;
    @NotNull(message = "user name cannot be empty")
    @Pattern(regexp = "[A-Za-z ]$")
    private String name;
    @NotNull(message = "user Address cannot be empty")
    private String address;

    @NotNull(message = "user register cannot be empty")
    private LocalDate user_registration_date=LocalDate.now();
    String date=user_registration_date.toString();
    @Email(message = "user email cannot be empty")
    private String email;
    @NotNull(message = "user contact number cannot be empty")
    private String contact_number;
    @NotNull(message = "user Age number cannot be empty")
    private String age;
    @NotNull(message = "user Gender cannot be empty")
    private String gender;
    @NotNull(message = "Admin Password cannot be empty")@Size(min = 5,max = 8)
    private String password;
    @NotNull(message = "user NIC cannot be empty")
    private String nic_or_passport_number;
    @NotNull(message = "user remark cannot be empty")
    private String remark;
    @NotNull(message = "user profile picture cannot be empty")
    private String profile_picture;


}
