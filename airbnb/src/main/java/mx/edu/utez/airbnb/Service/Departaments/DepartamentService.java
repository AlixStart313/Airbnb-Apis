package mx.edu.utez.airbnb.Service.Departaments;

import mx.edu.utez.airbnb.Model.Departament.DepartamentModel;
import mx.edu.utez.airbnb.Model.Departament.IDepartamentRepository;
import mx.edu.utez.airbnb.Model.User.UserModel;
import mx.edu.utez.airbnb.Utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class DepartamentService {
    @Autowired
    private IDepartamentRepository departamentRepository;

    @Transactional(readOnly = true)
    public CustomResponse<List<DepartamentModel>> getAll(){
        return new CustomResponse<>(
                this.departamentRepository.findAll(),
                false,
                200,
                "ok"
        );
    }
    @Transactional(readOnly = true)
    public CustomResponse<DepartamentModel> getOne(Long id){
        return  new CustomResponse<>(
                this.departamentRepository.findById(id).get(),
                false,
                200,
                "OK"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public  CustomResponse<DepartamentModel> updateDescription(DepartamentModel departamentModel){
        if(!this.departamentRepository.existsById(departamentModel.getId())){
            return new CustomResponse<>(
                    null,
                    true,
                    400,
                    "Este departamento no existe"
            );
        }

        return new CustomResponse<>(
                this.departamentRepository.updateRanking(departamentModel.getRanking(),departamentModel.getId()),
                false,
                200,
                "Descripcion Actualizada correctamente"
        );
    }


}
