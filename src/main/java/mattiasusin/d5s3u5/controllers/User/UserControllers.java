package mattiasusin.d5s3u5.controllers.User;

import mattiasusin.d5s3u5.entities.Event;
import mattiasusin.d5s3u5.entities.User;
import mattiasusin.d5s3u5.services.User.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserControllers {

    // IMPORTI

    @Autowired
    private UserServices userServices;

    // GET ALL
    @GetMapping
    public Page<User> findAllUser(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "10") int size,
                                   @RequestParam(defaultValue = "id") String sortBy){
        return this.userServices.findALl(page,size,sortBy);
    }

    // GET ID
    @GetMapping("/{userId}")
    public User findByUserId(@PathVariable UUID utenteId) {
        return this.userServices.findByUserId(utenteId);
    }

}

