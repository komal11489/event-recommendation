package com.example.event.controller;

import com.example.event.model.Event;
import com.example.event.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @GetMapping("/recommend")
    public List<Event> recommend(@RequestParam String type) {
        return service.recommendByType(type);
    }

    @GetMapping
    public List<Event> getAll() {
        return service.getAll();
    }

    @GetMapping("/location/{location}")
    public List<Event> recommendByLocation(@PathVariable String location) {
        return service.recommendByLocation(location);
    }

    @PostMapping("/history")
    public List<Event> recommendByHistory(@RequestBody List<String> interests) {
        return service.recommendEventsBasedOnHistory(interests);
    }
}
