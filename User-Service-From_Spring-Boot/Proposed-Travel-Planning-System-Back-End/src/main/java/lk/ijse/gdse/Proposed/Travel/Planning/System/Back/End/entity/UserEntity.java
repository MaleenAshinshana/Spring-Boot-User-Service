package lk.ijse.gdse.Proposed.Travel.Planning.System.Back.End.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/*@Document(collection = "users")*/
/*@Entity*/
/*@AllArgsConstructor*/
@NoArgsConstructor
@Data
/*@Document( collation = "userEntity")*/
public class UserEntity implements SuperEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String user_id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private String contact_number;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false)
    private String nic_or_passport_number;
    @Column(nullable = false)
    private String remark;
    @Lob
    @Column(nullable = false,columnDefinition = "LONGTEXT")
    private String profile_picture;

    /*@OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BillEntity> billEntities;*/



    /*@OneToMany(mappedBy = "user")
    private List<BillEntity> billEntities=new ArrayList<>();*/

    public UserEntity(String user_id, String name, String address, String email, int age, String contact_number, String password, String gender, String nic_or_passport_number, String remark, String profile_picture) {
        this.user_id = user_id;
        this.name = name;
        this.address = address;

        this.email = email;
        this.age = age;
        this.contact_number = contact_number;
        this.password = password;
        this.gender = gender;
        this.nic_or_passport_number = nic_or_passport_number;
        this.remark = remark;
        this.profile_picture = profile_picture;
    }


}
