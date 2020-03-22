package acn.poc.wiv.beans;

import acn.poc.wiv.entity.Event;

import java.io.Serializable;
import java.util.List;

public class GetAllEventResponse implements Serializable {

    private List<Event> allEvents;

    public GetAllEventResponse() {}

    public GetAllEventResponse(List<Event> allEvents) {
        this.allEvents = allEvents;
    }

    public List<Event> getAllEvents() {
        return allEvents;
    }

    public void setAllEvents(List<Event> allEvents) {
        this.allEvents = allEvents;
    }
}
