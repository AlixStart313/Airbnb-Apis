package mx.edu.utez.airbnb.Model.Rent;

import mx.edu.utez.airbnb.Model.Departament.DepartamentModel;
import mx.edu.utez.airbnb.Model.User.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface IRentRepository extends JpaRepository<RentModel,Long> {
    @Query(
            value ="Insert into rent (rent.deparent_id, rent.user_id, date) values (:departament,:user,now()) ",
            nativeQuery = true
    )
    RentModel saveRent(
            @Param("departament") DepartamentModel departament,
            @Param("user") UserModel user);

    @Query(
            value ="Update rent set description =:description where rent.id =:id",
            nativeQuery = true
    )
    RentModel updateDescription(
            @Param("description") String description,
            @Param("id") long id);

}
