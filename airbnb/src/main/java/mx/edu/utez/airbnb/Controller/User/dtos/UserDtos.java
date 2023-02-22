package mx.edu.utez.airbnb.Controller.User.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.airbnb.Model.Person.PersonModel;
import mx.edu.utez.airbnb.Model.Rent.RentModel;
import mx.edu.utez.airbnb.Model.User.UserModel;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDtos {
    private long id;

    @NotNull
    @NotBlank
    @Length(min = 3,max = 120)
    private String email;
    private String uid;
    private String imageProfile;
    private PersonModel personModel;
    private List<RentModel> rentModel;

    public UserModel getUser(){
        return  new UserModel(
                getId(),
                getEmail(),
                getUid(),
                getImageProfile(),
                getPersonModel(),
                getRentModel()
        );
    }

    public UserModel ChangeImageProfile(){
        return  new UserModel(
                getId(),
                null,
                null,
                getImageProfile(),
                null,
                null
        );
    }

    public UserModel changeUserName(){
        return  new UserModel(
                getId(),
                null,
                null,
                null,
                getPersonModel(),
                null
        );
    }




}
