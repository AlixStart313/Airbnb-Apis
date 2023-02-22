package mx.edu.utez.airbnb.Model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserModel,Long> {
    boolean existsByEmail(String email);

    @Query(
            value ="UPDATE users set image_profile =: imageProfile where uid=:uid ",
            nativeQuery = true
    )
    UserModel updateImageProfile(
            @Param("imagProfile") String imageProfile,
            @Param("uid") String uid);




}
