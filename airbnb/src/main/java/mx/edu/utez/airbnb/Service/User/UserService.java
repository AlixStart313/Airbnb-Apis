package mx.edu.utez.airbnb.Service.User;

import mx.edu.utez.airbnb.Model.User.IUserRepository;
import mx.edu.utez.airbnb.Model.User.UserModel;
import mx.edu.utez.airbnb.Utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

public class UserService {

    @Autowired
    private IUserRepository userRepository;

    @Transactional(readOnly = true)
    public CustomResponse<List<UserModel>> getAll() {
        return new CustomResponse<>(
                this.userRepository.findAll(),
                false,
                200,
                "Funcionando al 100"
        );
    }

    @Transactional(readOnly = true)
    public CustomResponse<UserModel> getOne(Long id) {
        return new CustomResponse<>(
                this.userRepository.findById(id).get(),
                false, 200, "Funcionando al 100"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<UserModel> insert(UserModel userModel) {
        if (this.userRepository.existsByEmail(userModel.getEmail())) {
            return new CustomResponse<>(
                    null, false, 400, "Esta persona ya se encuentra registrada"
            );
        }
            return new CustomResponse<>(
                    this.userRepository.saveAndFlush(userModel), false, 200, "Persona registrada correctamente"
            );
    }

    @Transactional (rollbackFor = {SQLException.class})
    public CustomResponse<UserModel> updateName(UserModel userModel){
        if(!this.userRepository.existsById(userModel.getId())){
            return new CustomResponse<>(
                    null,true, 400, "Este usuario no esta registrado"
            );
        }

        return  new CustomResponse<>(
                this.userRepository.saveAndFlush(userModel),false,200,"persona modificada corerctament"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<UserModel> updateImageProfile(UserModel userModel){
        if(!this.userRepository.existsById(userModel.getId())){
            return new CustomResponse<>(
                    null,true,400,"Esta personano esta registrada"
            );
        }

        return new CustomResponse<>(
                this.userRepository.updateImageProfile(userModel.getImageProfile(), userModel.getUid()),
                false,
                200,
                "Imagen de perfil modificada correctamente"
        );
    }

}
