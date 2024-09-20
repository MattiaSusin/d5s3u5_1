package mattiasusin.d5s3u5.services;

import mattiasusin.d5s3u5.entities.Event;
import mattiasusin.d5s3u5.exceptions.NotFoundException;
import mattiasusin.d5s3u5.playloads.NewEventDTO;
import mattiasusin.d5s3u5.playloads.NewEventRespDTO;
import mattiasusin.d5s3u5.repositories.EventsRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EventServices {
    @Autowired
    private EventsRepositoy eventsRepositoy;

    // GET ALL OK

    public Page<Event> findALl(int page, int size, String sortBy){
        if (page > 100) page = 100;

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return this.eventsRepositoy.findAll(pageable);
    }

    //POST

    public Event saveEvent(NewEventDTO body){
        Event newEvent = new Event(body.title(),body.description(),body.place_available(),body.date(),body.place());

        return this.eventsRepositoy.save(newEvent);
    }

    // GET ID
   /* public Event findByEventId(UUID eventId){
        return this.eventsRepositoy.findBy(eventId).orElseThrow(() -> new NotFoundException(eventId));
    }*/

    // DELETE

    // UPDATE
       /* newEvent.setTitle(newEvent.getTitle());
        newEvent.setDescription(newEvent.getDescription());
        newEvent.setPlace_available(newEvent.getPlace_available());
        newEvent.setDate(newEvent.getDate());
        newEvent.setPlace(newEvent.getPlace());*/

    // SAVE EVENT

}
