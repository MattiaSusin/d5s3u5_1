package mattiasusin.d5s3u5.playloads.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record NewUserDTO( @NotEmpty(message = "Inserisci il nome")
                          @Size (min = 6, max = 10, message = "Il nome deve essere compreso tra 6 e 10 caratteri")
                          String name,
                          @NotEmpty(message = "Inserisci il cognome")
                          @Size(min = 6, max = 15, message = "Il cognome deve essere compreso tra 6 e 15 caratteri")
                          String surname,
                          @NotEmpty(message = "Inserisci una password valida")
                          @Size(min = 6, max = 15, message = "la password deve essere compresa tra 6 e 15 caratteri")
                          String password,
                          @NotEmpty(message = "Devi inserire l'email")
                          @Email(message = "L'email inserita non è valida")
                          String email,
                          @NotEmpty(message = "Inserisci un ruolo valido")
                          @Size(min = 6, max = 15, message = "Il ruolo può essere UTENTE_NORMALE o ORGANIZZATORE")
                          String role) {

}
