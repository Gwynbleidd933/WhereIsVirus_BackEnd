package acn.poc.wiv.rest;


import acn.poc.wiv.beans.GeoLocation;
import acn.poc.wiv.beans.GetAllEventResponse;
import acn.poc.wiv.entity.Event;
import acn.poc.wiv.service.EventService;
import acn.poc.wiv.utils.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class EventRestController {

	private EventService eventService;
	private Validator validator;
	Logger logger = LoggerFactory.getLogger(EventRestController.class);

	@Autowired
	public EventRestController(EventService eventService, Validator validator) {
		this.eventService = eventService;
		this.validator = validator;
	}


	@GetMapping("/events")
	public GetAllEventResponse findAll() {
		return eventService.findAll();
	}

	@GetMapping("/events/{id}")
	public Optional<Event> findById(@PathVariable int id) {

		Optional<Event> event = eventService.findById(id);

		if (event == null) {
			throw new RuntimeException("Event id not found - " + id);
		}

		return event;
	}


	@PutMapping("/events")
	public Event addEvent(@RequestBody Event event, @RequestHeader("userId") int userId) {

		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update

		event.setId(userId);

		eventService.save(event);

		//todo get user with id and append incoming event to created_events and save user

		return event;
	}



	@PostMapping("/events")
	public Event updateEvent(@RequestBody Event event) {

		eventService.save(event);

		return event;
	}


	@DeleteMapping("/events/{id}")
	public String deleteEventById(@PathVariable int id) {

		Optional<Event> tempEvent = eventService.findById(id);

		// throw exception if null

		if (tempEvent == null) {
			throw new RuntimeException("Event id not found - " + id);
		}

		eventService.deleteById(id);

		return "Deleted event with id: " + id;
	}

	public Event findByLocation(GeoLocation geoLocation) {

		Optional<Event> eventOptional = eventService.findByLocation(geoLocation.getLatitude(), geoLocation.getLongitude());

		return eventOptional.orElse(null);
	}

	@PostMapping("/events/confirm")
	public Boolean confirmEventByLocation(@RequestBody GeoLocation geoLocation) {

		Event event = findByLocation(geoLocation);

		if (Objects.nonNull(event)) {
			event.setConfirmedBySanepid(true);

			eventService.save(event);
			return Boolean.TRUE;
		}
		logger.info("Event with given geoLocation does not exist!");
		return Boolean.FALSE;
	}

}










