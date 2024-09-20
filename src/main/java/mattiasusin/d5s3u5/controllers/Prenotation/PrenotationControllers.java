package mattiasusin.d5s3u5.controllers.Prenotation;

import mattiasusin.d5s3u5.services.User.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prenotations")
public class PrenotationControllers {

    @Autowired
    private UserServices userServices;


}
