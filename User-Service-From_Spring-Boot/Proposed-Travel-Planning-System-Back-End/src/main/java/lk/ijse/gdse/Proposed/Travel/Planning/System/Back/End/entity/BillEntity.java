package lk.ijse.gdse.Proposed.Travel.Planning.System.Back.End.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BillEntity implements SuperEntity {
@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String bill_id;
    @Column(nullable = false)
    private String date;
    /*@ManyToOne
    @JoinColumn(name = "user_id")*/
    private String user_id;

}
