package mattiasusin.d5s3u5.services.User;

import mattiasusin.d5s3u5.entities.User;
import mattiasusin.d5s3u5.exceptions.BadRequestException;
import mattiasusin.d5s3u5.exceptions.NotFoundException;
import mattiasusin.d5s3u5.playloads.User.NewUserDTO;
import mattiasusin.d5s3u5.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServices {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private PasswordEncoder bcrypt;

    //Trova tramite Id
    public User findByUserId(UUID utenteid) {
        return this.usersRepository.findById(utenteid).orElseThrow(() -> new NotFoundException(utenteid));

    }
    //ALL
    public List<User> findAll() {
        return this.usersRepository.findAll(); }

    //Trova tramite email
    public User findByEmail (String email) {
        return usersRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("l'utente con l'email" + email + "non è stato trovato!!!"));
    }
    //Salvataggio
    public User save(NewUserDTO body) {
        this.usersRepository.findByEmail(body.email()).ifPresent(user -> {throw new BadRequestException("l'email"+ body.email() + "in uso");});
        User newUtente = new User(body.surname(),body.email(), body.name(), bcrypt.encode(body.password()),body.role());
        return this.usersRepository.save(newUtente);
    }
}
