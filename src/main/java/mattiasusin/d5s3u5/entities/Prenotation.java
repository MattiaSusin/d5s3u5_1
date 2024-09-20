package mattiasusin.d5s3u5.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "prenotation")
@Setter
@Getter
@NoArgsConstructor
public class Prenotation {

    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private User user;


    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Event event;

    // COSTRUTTORI

    public Prenotation(User user, Event event) {
        this.user = user;
        this.event = event;
    }

    // TO STRING


    @Override
    public String toString() {
        return "Prenotation{" +
                "id=" + id +
                ", user=" + user +
                ", event=" + event +
                '}';
    }
}
