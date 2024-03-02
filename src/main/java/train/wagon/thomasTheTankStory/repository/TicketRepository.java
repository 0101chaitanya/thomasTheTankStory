package train.wagon.thomasTheTankStory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import train.wagon.thomasTheTankStory.entity.Passenger;

public interface TicketRepository extends JpaRepository<Passenger, Integer> {
}