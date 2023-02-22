package mx.edu.utez.airbnb.Model.Person;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.airbnb.Model.User.UserModel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "people")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PersonModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,length = 45)
    private String name;

    @Column(nullable = false,length = 45)
    private String lastName;

    @Column(nullable = true,length = 45)
    private String surName;

    @OneToMany(mappedBy = "personModel")
    @JsonIgnore
    private List<UserModel> userModels;



}
