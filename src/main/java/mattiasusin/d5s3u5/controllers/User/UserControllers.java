package mattiasusin.d5s3u5.controllers.User;

import mattiasusin.d5s3u5.entities.User;
import mattiasusin.d5s3u5.services.User.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserControllers {
    @Autowired
    private UserServices userServices;


    //Get By ID
    @GetMapping("/{userId}")
    public User findByUserId(@PathVariable UUID utenteId) {
        return this.userServices.findByUserId(utenteId);
    }
    //GET ALL
    @GetMapping
    public List<User> findAll() {
        return userServices.findAll();
    }
}

