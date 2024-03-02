package train.wagon.thomasTheTankStory.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import train.wagon.thomasTheTankStory.entity.Passenger;
import train.wagon.thomasTheTankStory.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/add")
    public ResponseEntity<String> savePassengerToDatabase(@RequestBody Passenger passenger) {
        String addEmployee = ticketService.addPassenger(passenger);
        return new ResponseEntity<>(addEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Passenger> getPassenger(@PathVariable Integer id) {
        Passenger passengerById = ticketService.getPassengerById(id);
        return new ResponseEntity<>(passengerById, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Passenger>> getAllPassengers() {
        List<Passenger> passengerList = ticketService.getAllPassengers();
        return new ResponseEntity<>(passengerList, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Passenger> updatePassenger(@RequestBody Passenger passenger, @PathVariable Integer id) {
        return new ResponseEntity<>(ticketService.updatePassengerInfoPut(passenger, id), HttpStatus.ACCEPTED);
    }

    @PatchMapping("/patch/{id}")
    public ResponseEntity<Passenger> updatePassengerByFields(@RequestBody Map<String, Object> fields,
            @PathVariable Integer id) {
        Passenger updatedPassengerByFields = ticketService.updatePassengerInfoPatch(fields, id);
        return new ResponseEntity<>(updatedPassengerByFields, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteByPassengerId(@PathVariable Integer id) {
        String message = ticketService.deletePassengerById(id);
        return new ResponseEntity<>(message, HttpStatus.NO_CONTENT);

    }
}
