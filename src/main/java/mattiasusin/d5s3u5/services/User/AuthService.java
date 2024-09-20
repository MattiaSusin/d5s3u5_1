package mattiasusin.d5s3u5.services.User;

import mattiasusin.d5s3u5.entities.User;
import mattiasusin.d5s3u5.exceptions.UnauthorizedException;
import mattiasusin.d5s3u5.playloads.User.UserLoginDTO;
import mattiasusin.d5s3u5.security.JWTTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserServices userServices;

    @Autowired
    private JWTTools jwtTools;

    @Autowired
    private PasswordEncoder bcrypt;

    public String checkAndGenerate(UserLoginDTO body) {

        User found = this.userServices.findByEmail(body.email());
        if (bcrypt.matches(body.password(), found.getPassword())) {

            return jwtTools.createToken(found);
        } else {

            throw new UnauthorizedException("Credenziali errate!");
        }
};
}
