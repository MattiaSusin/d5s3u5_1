package mattiasusin.d5s3u5.services.Prenotation;

import mattiasusin.d5s3u5.entities.Prenotation;
import mattiasusin.d5s3u5.exceptions.NotFoundException;
import mattiasusin.d5s3u5.repositories.PrenotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PrenotationService {

    //IMPORTI
    @Autowired
    private PrenotationRepository prenotationRepository;


    // GET ALL

    public Page<Prenotation> findAll(int page, int size, String sortBy){
        if (page > 100) page = 100;

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return this.prenotationRepository.findAll(pageable);
    }

    // GET ID


    public Prenotation findByPrenotationId(UUID prenotationId){
        return this.prenotationRepository.findById(prenotationId).orElseThrow(() -> new NotFoundException(prenotationId));
    }

                                        // Non sono riuscito a finire per mancanza di tempo


}
