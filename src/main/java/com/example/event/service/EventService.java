package com.example.event.service;

import com.example.event.model.Event;
import com.example.event.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {
    private final EventRepository repository;

    public EventService(EventRepository repository) {
        this.repository = repository;
    }

    public List<Event> recommendByType(String type) {
        return repository.findByType(type);
    }

    public List<Event> getAll() {
        return repository.findAll();
    }

    public List<Event> recommendByLocation(String location) {
        // Recommend events in the same location
        return repository.findByLocationIgnoreCase(location);
    }

    public List<Event> recommendEventsBasedOnHistory(List<String> pastInterests) {
        // Recommend events matching user's past interests (e.g., types of events)
        return repository.findAll().stream()
                .filter(event -> pastInterests.contains(event.getType()))
                .collect(Collectors.toList());
    }
}
