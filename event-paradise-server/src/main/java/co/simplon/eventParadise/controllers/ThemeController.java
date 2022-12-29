package co.simplon.eventParadise.controllers;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.eventParadise.database.DataBase;
import co.simplon.eventParadise.dtos.ThemeViewDto;
import co.simplon.eventParadise.entities.Theme;

@RestController
@RequestMapping("/themes")
public class ThemeController {

    @GetMapping
    public Collection<ThemeViewDto> getAll() {
	Collection<Theme> themes = DataBase.findAllThemes();
	Collection<ThemeViewDto> views = new ArrayList<>();
	for (Theme theme : themes) {
	    ThemeViewDto view = new ThemeViewDto();
	    view.setId(theme.getId());
	    view.setName(theme.getName());
	    views.add(view);

	}
	return views;
    }
}
