package mattiasusin.d5s3u5.controllers.Prenotation;

import mattiasusin.d5s3u5.entities.Prenotation;
import mattiasusin.d5s3u5.services.Prenotation.PrenotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/prenotations")
public class PrenotationControllers {

    // IMPORTI

    @Autowired
    private PrenotationService prenotationService;

    // QUERY

    // GET ALL

    @GetMapping
    public Page<Prenotation> findAll(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10") int size,
                                     @RequestParam(defaultValue = "id") String sortBy) {
        return this.prenotationService.findAll(page,size,sortBy);
    }


    // GET ID
    @GetMapping("/{userId}")
    public Prenotation findByPrenotationId(@PathVariable UUID prenotationId) {
        return this.prenotationService.findByPrenotationId(prenotationId);
    }


                                // Non ho finito per mancanza di tempo

}
