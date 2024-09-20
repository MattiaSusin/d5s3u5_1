package mattiasusin.d5s3u5.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mattiasusin.d5s3u5.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "events")
@Setter
@Getter
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;

    private String Title;
    private String Description;
    private int place_available;
    private Date date;
    private String place;




    // ONE TO MANY --> PRENOTAZIONE
    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private User user;


    // COSTRUTTORI

    public Event(String title, String description, int place_available, Date date, String place) {
        Title = title;
        Description = description;
        this.place_available = place_available;
        this.date = date;
        this.place = place;
    }


    // TO STRING

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", Title='" + Title + '\'' +
                ", Description='" + Description + '\'' +
                ", place_available=" + place_available +
                ", date=" + date +
                ", place='" + place + '\'' +
                '}';
    }

}
