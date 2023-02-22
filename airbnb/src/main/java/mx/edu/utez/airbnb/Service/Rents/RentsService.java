package mx.edu.utez.airbnb.Service.Rents;

import mx.edu.utez.airbnb.Model.Rent.IRentRepository;
import mx.edu.utez.airbnb.Model.Rent.RentModel;
import mx.edu.utez.airbnb.Model.User.UserModel;
import mx.edu.utez.airbnb.Utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
@Transactional
public class RentsService {
    @Autowired
    private IRentRepository rentRepository;

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<RentModel> newRent(RentModel rentModel){
        if (this.rentRepository.existsById(rentModel.getId())) {
            return new CustomResponse<>(
                    null,
                    true,
                    400,
                    "Esta renta ya existe"
            );
        }
           return new CustomResponse<>(
                   this.rentRepository.saveRent(rentModel.getDepartamentModel(),rentModel.getUserModel()),
                   false,
                   200,
                   "Renta Registrado con exito"
           );

    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<RentModel> updateDescrition(RentModel rentModel){
        if(!this.rentRepository.existsById(rentModel.getId())){
            return new CustomResponse<>(
                    null,
                    true,
                    400,
                    "Este folio no esta registrado"
            );
        }

        return new CustomResponse<>(
                this.rentRepository.updateDescription(rentModel.getDescription(), rentModel.getId()),
                false,
                200,
                "Descripcion de la renta actualizada"
        );
    }


}
