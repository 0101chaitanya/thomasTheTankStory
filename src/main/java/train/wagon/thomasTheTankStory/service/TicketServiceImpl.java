package train.wagon.thomasTheTankStory.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import train.wagon.thomasTheTankStory.entity.Passenger;
import train.wagon.thomasTheTankStory.exception.TicketException;
import train.wagon.thomasTheTankStory.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public String addPassenger(Passenger passenger) {
        Passenger passengerObj = ticketRepository.save(passenger);
        if (passengerObj.getTicketNumber() != null && passenger != null) {
            return "passenger created Successfully";
        } else {
            return "passenger not created";
        }
    }

    @Override
    public Passenger getPassengerById(Integer id) {

        ticketRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Passenger not found"));
        return ticketRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Passenger not found"));

    }

    @Override
    public List<Passenger> getAllPassengers() {
        return ticketRepository.findAll();
    }

    @Override
    public Passenger updatePassengerInfoPut(Passenger passenger, Integer id) {
        Passenger existingPassenger = ticketRepository.findById(id).get();
        existingPassenger.setNameOfPassenger(passenger.getNameOfPassenger());
        existingPassenger.setGender(passenger.getGender());
        existingPassenger.setDestination(passenger.getDestination());
        return ticketRepository.save(existingPassenger);
    }

    @Override
    public Passenger updatePassengerInfoPatch(Map<String, Object> fields, Integer id) {
        Optional<Passenger> existingPassenger = ticketRepository.findById(id);
        existingPassenger.ifPresent(t -> {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findRequiredField(Passenger.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, existingPassenger.get(), value);
            });

            ticketRepository.save(existingPassenger.get());
        });
        return existingPassenger.get();
    }

    @Override
    public String deletePassengerById(Integer id) {
        String status = "Failed to delete passenger record with id: " + id + " it doesn't seem to exist in records";

        if (!ticketRepository.findById(id).isEmpty()) {

            ticketRepository.deleteById(id);
            status = "Passenger record deleted successfully";
        } else {
            throw new TicketException(status);
        }

        return status;
    }

}