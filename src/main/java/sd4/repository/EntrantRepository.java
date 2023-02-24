package sd4.repository;

import org.springframework.data.repository.query.Param;
import sd4.model.Entrant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository

public interface EntrantRepository extends CrudRepository<Entrant, Long> {

    List<Entrant> findEntrantsById(Long id);

    List<Entrant> findEntrantsByArtistCountry(String artistCountry);

    // @Query("SELECT e from Entrant e WHERE " + "e.hostCountry like  %?1%")
    // List<Entrant> findByHostCountryContaining(@Param("name") String name);


    @Query("select e from Entrant e where e.hostCountry like %?1%")
    List<Entrant> getByCountryFilter(String countryKeyword);

    @Query("select e from Entrant e where e.dateOfFinal between :start AND :end")
    List<Entrant> getEntrantByDateOfFinal(@Param("start") Date start, @Param("end") Date end);

    List<Entrant> findEntrantsByDateOfFinalBetween(Date startDate, Date endDate);

}
