package mattiasusin.d5s3u5.controllers;

import mattiasusin.d5s3u5.entities.Event;
import mattiasusin.d5s3u5.exceptions.BadRequestException;
import mattiasusin.d5s3u5.playloads.NewEventDTO;
import mattiasusin.d5s3u5.playloads.NewEventRespDTO;
import mattiasusin.d5s3u5.services.EventServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/events")
public class EventControllers {

    @Autowired
    private EventServices eventServices;

    // GET ALL
    @GetMapping
    public Page<Event> findAll(@RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "10") int size,
                                    @RequestParam(defaultValue = "id") String sortBy){
        return this.eventServices.findALl(page, size, sortBy);
    }

    // POST

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NewEventRespDTO saveUser(@RequestBody @Validated NewEventDTO body, BindingResult validationResult){            // @Validated serve per 'attivare' le regole di validazione descritte nel DTO
        // BindingResult mi permette di capire se ci sono stati errori e quali errori ci sono stati
        if (validationResult.hasErrors()){
            String messages = validationResult.getAllErrors().stream()
                    .map(objectError -> objectError.getDefaultMessage())
                    .collect(Collectors.joining(". "));
            throw new BadRequestException("Ci sono stati errori nel payload" + messages);
        }else {
            return new NewEventRespDTO(this.eventServices.saveEvent(body).getId());
        }
    }

    // GET ID
    @GetMapping("/{eventId}")
    public Event findByEventId(@PathVariable UUID eventId){return this.eventServices.findByEventId(eventId);}

    // PUT

    @PutMapping("/{eventId}")
    public Event findByEventIdAndUpdate(@PathVariable UUID eventId,@RequestBody Event body){
        return this.eventServices.findByEventIdAndUpdate(eventId,body);
    }
    // DELETE
    @DeleteMapping("/{eventId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Event findByEventIdAndDelete(@PathVariable UUID eventId){
        this.eventServices.findByEventIdAndDelete(eventId);
        return null;
    }

}

