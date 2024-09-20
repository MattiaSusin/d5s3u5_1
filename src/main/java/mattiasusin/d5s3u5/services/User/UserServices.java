package mattiasusin.d5s3u5.services.User;

import mattiasusin.d5s3u5.entities.User;
import mattiasusin.d5s3u5.exceptions.BadRequestException;
import mattiasusin.d5s3u5.exceptions.NotFoundException;
import mattiasusin.d5s3u5.playloads.User.NewUserDTO;
import mattiasusin.d5s3u5.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServices {

    // IMPORTI

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private PasswordEncoder bcrypt;

    // GET ALL
    public Page<User> findALl(int page, int size, String sortBy){
        if (page > 100) page = 100;

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return this.usersRepository.findAll(pageable);
    }

    // GET ID
    public User findByUserId(UUID utenteid) {
        return this.usersRepository.findById(utenteid).orElseThrow(() -> new NotFoundException(utenteid));

    }

    // FIND EMAIL
    public User findByEmail (String email) {
        return usersRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("l'utente con l'email" + email + "non è stato trovato!!!"));
    }

    // SAVE
    public User save(NewUserDTO body) {
        this.usersRepository.findByEmail(body.email()).ifPresent(user -> {throw new BadRequestException("l'email"+ body.email() + "in uso");});
        User newUtente = new User(body.surname(),body.email(), body.name(), bcrypt.encode(body.password()),body.role());
        return this.usersRepository.save(newUtente);
    }

}
