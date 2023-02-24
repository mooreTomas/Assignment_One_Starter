package sd4.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Entrant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="venue_ID")
    private Integer venueID;
    
    private String logo;

    @Column(name="host_City")
    private String hostCity;

    @Temporal(TemporalType.DATE)
    @Column(name="date_Of_Final")
    private Date dateOfFinal;

    @Column(name="hostCountry")
    private String hostCountry;

    private String section;
    private String artist;
    private String song;

    @Column(name="artist_Country")
    private String artistCountry;

    @Column(name="running_Order")
    private String runningOrder;

    @Column(name="total_Points")
    private Integer totalPoints;

    private String rank;
    private String qualified;
}
