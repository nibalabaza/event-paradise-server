package co.simplon.eventParadise.controllers;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.eventParadise.database.DataBase;
import co.simplon.eventParadise.dtos.LocationViewDto;
import co.simplon.eventParadise.entities.Location;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @GetMapping
    public Collection<LocationViewDto> getAll() {
	Collection<Location> locations = DataBase.findAllLocations();
	Collection<LocationViewDto> views = new ArrayList<>();
	for (Location location : locations) {
	    LocationViewDto view = new LocationViewDto();
	    view.setId(location.getId());
	    view.setName(location.getName());
	    views.add(view);

	}
	return views;
    }
}
