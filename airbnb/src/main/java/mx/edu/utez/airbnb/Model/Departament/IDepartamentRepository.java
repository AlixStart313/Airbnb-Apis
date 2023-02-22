package mx.edu.utez.airbnb.Model.Departament;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IDepartamentRepository extends JpaRepository<DepartamentModel,Long> {
    @Query(
            value ="Update deparment set ranking =:ranking, total_ranking =total_ranking+1 " +
                    "where deparment.id =:id ",
            nativeQuery = true
    )
    DepartamentModel updateRanking(
            @Param("ranking") double ranking,
            @Param("id") long id);

}

