package mx.edu.utez.airbnb.Model.Rent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.airbnb.Model.Departament.DepartamentModel;
import mx.edu.utez.airbnb.Model.User.UserModel;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "rents")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    @Column(nullable = false,columnDefinition = "date")
    private Date  date;

    @Column(columnDefinition = "text")
    private String description;

    @ManyToOne
    @JoinColumn(name = "departament_id",nullable = false)
    private DepartamentModel departamentModel;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private UserModel userModel;

}
