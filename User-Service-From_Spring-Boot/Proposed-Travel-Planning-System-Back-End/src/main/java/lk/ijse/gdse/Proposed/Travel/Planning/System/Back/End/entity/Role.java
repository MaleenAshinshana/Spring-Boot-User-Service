package lk.ijse.gdse.Proposed.Travel.Planning.System.Back.End.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Role implements SuperEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String roleID;
    @Column(name = "role",columnDefinition = "ENUM ('USER_ROLE','VEHICLE_ROLE','HOTEL_ROLE','GUIDE_ROLE','AREA_ROLE') NOT NULL")
    //columnDefinition = "ENUM ('ROLE_USER','ROLE_ADMIN','ROLE_HOTEL','ROLE_GUIDE','ROLE_VEHICLE','ROLE_BOOKING') NOT NULL")
    private String role;
}
