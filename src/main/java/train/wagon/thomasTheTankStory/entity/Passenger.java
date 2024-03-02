package train.wagon.thomasTheTankStory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@jakarta.persistence.Table(name = "passenger_info")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_number")
    private Integer ticketNumber;
    @Column(name = "name_of_passenger")
    private String nameOfPassenger;
    @Column(name = "gender_of_passenger")
    private String gender;
    @Column(name = "destination")
    private String destination;

}
