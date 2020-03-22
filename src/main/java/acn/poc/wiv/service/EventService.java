package acn.poc.wiv.service;

import acn.poc.wiv.beans.GetAllEventResponse;
import acn.poc.wiv.entity.Event;
import acn.poc.wiv.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EventService {

    public GetAllEventResponse findAll();

    public Optional<Event> findById(int id);

    public void save(Event user);

    public void deleteById(int id);

    public Optional<Event> findByLocation(Double latitude, Double longitude);

}
