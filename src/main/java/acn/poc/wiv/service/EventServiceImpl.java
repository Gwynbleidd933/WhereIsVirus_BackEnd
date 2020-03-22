package acn.poc.wiv.service;

import acn.poc.wiv.beans.GetAllEventResponse;
import acn.poc.wiv.dao.EventRepository;
import acn.poc.wiv.entity.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService{

    private EventRepository eventRepository;
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private Environment env;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository, Environment env) {
        this.eventRepository = eventRepository;
        this.env = env;
    }

    @Override
    public GetAllEventResponse findAll() {

        GetAllEventResponse eventListResponse = new GetAllEventResponse(eventRepository.findAll());

        return eventListResponse;
    }

    @Override
    public Optional<Event> findById(int id) {
        return eventRepository.findById(id);
    }

    @Override
    public void save(Event user) {
        eventRepository.save(user);
    }

    @Override
    public void deleteById(int id) {
        eventRepository.deleteById(id);
    }

    @Override
    public Optional<Event> findByLocation(Double latitude, Double longitude) {
        return eventRepository.findByLocation(latitude, longitude);
    }


}
