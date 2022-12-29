package co.simplon.eventParadise.controllers;

import java.util.ArrayList;
import java.util.Collection;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.eventParadise.database.DataBase;
import co.simplon.eventParadise.dtos.EventCreateDto;
import co.simplon.eventParadise.dtos.EventViewDto;
import co.simplon.eventParadise.entities.Event;

@RestController
@RequestMapping("/events")
public class EventController {

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void create(@Valid @RequestBody EventCreateDto inputs) {

	Event event = new Event();
	event.setName(inputs.getName());
	event.setDate(inputs.getDate());
	event.setRate(inputs.getRate());
	event.setDescription(inputs.getDescription());
	event.setLocation(DataBase.findOneLocation(inputs.getLocationId()));
	event.setTheme(DataBase.findOneTheme(inputs.getThemeId()));
	DataBase.saveEvent(event);

	System.out.println(inputs);
    }

    @GetMapping
    public Collection<EventViewDto> getAll() {
	Collection<Event> events = DataBase.findAll();

	Collection<EventViewDto> views = new ArrayList<>();
	for (Event event : events) {
	    EventViewDto view = new EventViewDto();
	    view.setId(event.getId());
	    view.setName(event.getName());
	    view.setDate(event.getDate());
	    view.setRate(event.getRate());
	    view.setDescription(event.getDescription());
	    view.setLocation(event.getLocation());
	    view.setTheme(event.getTheme());
	    views.add(view);

	}
	return views;
    }
}
