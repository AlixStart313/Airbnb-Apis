package mx.edu.utez.airbnb.Model.Departament;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.airbnb.Model.Rent.RentModel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "departaments")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DepartamentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,length = 120,unique = true)
    private String name;

    @Column(nullable = false,columnDefinition ="json" )
    private String locationJson;

    @Column(nullable = false,columnDefinition = "json")
    private String imageJson;

    @Column(nullable = false,columnDefinition = "text")
    private String description;

    @Column(nullable = false,columnDefinition = "double(2,2)")
    private double ranking;

    @Column(nullable = false,columnDefinition = "int default 0")
    private int totalRankings;

    @Column(nullable = false,columnDefinition = "double(3,2)")
    private double price;


    @OneToMany(mappedBy = "departamentModel")
    @JsonIgnore
    private List<RentModel> rentModels;


}
