package mattiasusin.d5s3u5.services;

import mattiasusin.d5s3u5.entities.Event;
import mattiasusin.d5s3u5.exceptions.NotFoundException;
import mattiasusin.d5s3u5.playloads.NewEventDTO;
import mattiasusin.d5s3u5.repositories.EventsRepository;
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
    private EventsRepository eventsRepository;

    // GET ALL OK

    public Page<Event> findALl(int page, int size, String sortBy){
        if (page > 100) page = 100;

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return this.eventsRepository.findAll(pageable);
    }

    //POST
    public Event saveEvent(NewEventDTO body){
        Event newEvent = new Event(body.title(),body.description(),body.place_available(),body.date(),body.place());

        return this.eventsRepository.save(newEvent);
    }

    // GET ID
    public Event findByEventId(UUID eventId){
        return this.eventsRepository.findById(eventId).orElseThrow(() -> new NotFoundException(eventId));
    }




    // PUT
    public Event findByEventIdAndUpdate(UUID eventId,Event newUserData){

        Event found = this.findByEventId(eventId);
        found.setTitle(newUserData.getTitle());
        found.setDescription(newUserData.getDescription());
        found.setPlace_available(newUserData.getPlace_available());
        found.setDate(newUserData.getDate());
        found.setPlace(newUserData.getPlace());

        return this.eventsRepository.save(found);
    }

    // DELETE

    public Event findByEventIdAndDelete(UUID eventId){
        Event found = this.findByEventId(eventId);
        this.eventsRepository.delete(found);
        return found;
    }



}
