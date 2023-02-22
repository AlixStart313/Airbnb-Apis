package mx.edu.utez.airbnb.Model.User;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.airbnb.Model.Person.PersonModel;
import mx.edu.utez.airbnb.Model.Rent.RentModel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,length = 25,unique = true)
    private String email;


    @Column(nullable = false,length = 120)
    private  String uid;

    @Column(
            columnDefinition = "text")
    private String imageProfile;

    @ManyToOne
    @JoinColumn(name = "person_id",nullable = false)
    private PersonModel personModel;

    @OneToMany(mappedBy = "userModel")
    @JsonIgnore
    private List<RentModel> rentModels;

}
