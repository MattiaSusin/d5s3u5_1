package mattiasusin.d5s3u5.playloads.Event;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record NewEventDTO(
        @NotEmpty(message = "Il titolo è obbligatorio")
        @Size(min = 5, max = 15, message = "Il titolo proprio deve essere compreso tra 5 e 15 caratteri")
        String title,
        @NotEmpty(message = "La descrizione è obbligatoria")
        @Size(min = 5, max = 30, message = "La descrizione deve essere compresa tra 5 e 30 caratteri")
        String description,
        int place_available
,        LocalDate date,
        @NotEmpty(message = "La città è obbligatoria")
        @Size(min = 3, message = "La città deve avere almeno 4 caratteri")
        String place){}
