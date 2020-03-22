package acn.poc.wiv.dao;

import acn.poc.wiv.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Integer> {
    @Query(value = "SELECT * FROM events e where e.latitude = :latitude and e.longitude = :longitude", nativeQuery = true)
    public Optional<Event> findByLocation(@Param("latitude") Double latitude, @Param("longitude") Double longitude);
}
