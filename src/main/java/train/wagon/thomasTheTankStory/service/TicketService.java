package train.wagon.thomasTheTankStory.service;

import java.util.List;
import java.util.Map;

import train.wagon.thomasTheTankStory.entity.Passenger;

public interface TicketService {
    public String addPassenger(Passenger passenger);

    public Passenger getPassengerById(Integer id);

    public List<Passenger> getAllPassengers();

    public Passenger updatePassengerInfoPut(Passenger passenger, Integer id);

    public Passenger updatePassengerInfoPatch(Map<String, Object> fields, Integer id);

    public String deletePassengerById(Integer id);

}
