package co.simplon.eventParadise.database;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import co.simplon.eventParadise.entities.Event;
import co.simplon.eventParadise.entities.Location;
import co.simplon.eventParadise.entities.Theme;

public class DataBase {

    private static Long eventId = 0L;
    private static Long locationId = 0L;
    private static Long themeId = 0L;

    private static final Map<Long, Event> EVENTS = new HashMap<>();
    private static final Map<Long, Location> LOCATIONS;
    private static final Map<Long, Theme> THEMES;

    static {
	LOCATIONS = new HashMap<>();
	Location paris = new Location();
	paris.setName("Paris");
	DataBase.saveLocation(paris);

	Location rennes = new Location();
	rennes.setName("Rennes");
	DataBase.saveLocation(rennes);

	Location marseille = new Location();
	marseille.setName("Marseille");
	DataBase.saveLocation(marseille);

    }

    static {
	THEMES = new HashMap<>();
	Theme eco = new Theme();
	eco.setName("Ecologie");
	DataBase.saveTheme(eco);

	Theme rH = new Theme();
	rH.setName("Resources Humaines");
	DataBase.saveTheme(rH);

	Theme tech = new Theme();
	tech.setName("Tech");
	DataBase.saveTheme(tech);
    }

    public static void saveEvent(Event event) {
	eventId++;
	event.setId(eventId);
	EVENTS.put(eventId, event);
    }

    private static void saveLocation(Location location) {
	locationId++;
	location.setId(locationId);
	LOCATIONS.put(locationId, location);
    }

    private static void saveTheme(Theme theme) {
	themeId++;
	theme.setId(themeId);
	THEMES.put(themeId, theme);
    }

    public static Collection<Event> findAll() {
	return EVENTS.values();
    }

    public static Collection<Location> findAllLocations() {
	return LOCATIONS.values();
    }

    public static Collection<Theme> findAllThemes() {
	return THEMES.values();
    }

    public static Location findOneLocation(Long id) {
	return LOCATIONS.get(id);
    }

    public static Theme findOneTheme(Long id) {
	return THEMES.get(id);
    }

}
