package mx.edu.utez.airbnb.Controller.User;


import mx.edu.utez.airbnb.Controller.User.dtos.UserDtos;
import mx.edu.utez.airbnb.Model.User.UserModel;
import mx.edu.utez.airbnb.Service.User.UserService;
import mx.edu.utez.airbnb.Utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api-airbnb/user/")
@CrossOrigin(origins = {"*"})
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<UserModel>>> getAll(){
        return new ResponseEntity<>(
                this.userService.getAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public  ResponseEntity<CustomResponse<UserModel>> getOne(@PathVariable("id") Long id){
        return  new ResponseEntity<>(
                this.userService.getOne(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public  ResponseEntity<CustomResponse<UserModel>> saveUser(@Valid @RequestBody UserDtos userDtos, BindingResult result){
        if (result.hasFieldErrors()){
            return new ResponseEntity<>(
                    null,
                    HttpStatus.BAD_REQUEST
            );
        }
        return new ResponseEntity<>(
                this.userService.insert(userDtos.getUser()),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<CustomResponse<UserModel>> updateImageProfile(
            @Valid @RequestBody UserDtos userDtos,
            BindingResult result
    ){
        return new ResponseEntity<>(
                this.userService.updateImageProfile(userDtos.ChangeImageProfile()),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<CustomResponse<UserModel>> updateName
}
