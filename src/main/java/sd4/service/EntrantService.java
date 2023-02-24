package sd4.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import sd4.model.Entrant;
import sd4.repository.EntrantRepository;
import org.springframework.stereotype.Service;

@Service
public class EntrantService {
    @Autowired

    private EntrantRepository entrantRepo;

    public List<Entrant> findAllEntrants(){
        return (List<Entrant>) entrantRepo.findAll();
    }

    //public List<Entrant> getFilteredCountries(String filter){
     //   return (List<Entrant>) entrantRepo.findByHostCountryContaining(filter);
   // }

    public List<Entrant> getByCountryFilter(String countryKeyword){
        return entrantRepo.getByCountryFilter(countryKeyword);
    }

    public List<Entrant> getByDateFilter(Date dateKeyword1, Date dateKeyword2){
        return entrantRepo.getEntrantByDateOfFinal(dateKeyword1, dateKeyword2);
    }

    public List<Entrant> findEntrantsByDateOfFinalBetween(Date startDate, Date endDate){
        return entrantRepo.findEntrantsByDateOfFinalBetween(startDate, endDate);
    }

}
