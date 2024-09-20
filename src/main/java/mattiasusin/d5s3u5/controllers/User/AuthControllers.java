package mattiasusin.d5s3u5.controllers.User;

import mattiasusin.d5s3u5.exceptions.BadRequestException;
import mattiasusin.d5s3u5.playloads.User.NewUserDTO;
import mattiasusin.d5s3u5.playloads.User.NewUserRespDTO;
import mattiasusin.d5s3u5.playloads.User.UserLoginDTO;
import mattiasusin.d5s3u5.playloads.User.UserLoginRespDTO;
import mattiasusin.d5s3u5.services.User.AuthService;
import mattiasusin.d5s3u5.services.User.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthControllers {

    // IMPORTI

    @Autowired
    private UserServices userServices;
    @Autowired
    private AuthService authService;

    //QUERRY

    // POST

    @PostMapping("/login")

    public UserLoginRespDTO login(@RequestBody UserLoginDTO payload) {
        return new UserLoginRespDTO (this.authService.checkAndGenerate(payload));}

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public NewUserRespDTO save(@RequestBody @Validated NewUserDTO body, BindingResult validationResult) {

        if (validationResult.hasErrors()) {

            String messages = validationResult.getAllErrors().stream()
                    .map(objectError -> objectError.getDefaultMessage())
                    .collect(Collectors.joining(". "));

            throw new BadRequestException("Ci sono stati errori nel payload. " + messages);
        } else {


            return new NewUserRespDTO(this.userServices.save(body).getId());
        }

    }}

