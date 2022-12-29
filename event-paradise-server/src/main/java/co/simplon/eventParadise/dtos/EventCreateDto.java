package co.simplon.eventParadise.dtos;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class EventCreateDto {

    @NotNull
    private Long id;
    @NotEmpty
    @Size(max = 255, min = 0)
    private String name;
    @NotNull
    @FutureOrPresent
    private LocalDate date;
    @NotNull
    @Positive
    private Double rate;
    @NotEmpty
    private String description;
    @NotNull
    private Long locationId;
    @NotNull
    private Long themeId;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public LocalDate getDate() {
	return date;
    }

    public void setDate(LocalDate date) {
	this.date = date;
    }

    public Double getRate() {
	return rate;
    }

    public void setRate(Double rate) {
	this.rate = rate;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public Long getLocationId() {
	return locationId;
    }

    public void setLocationId(Long locationId) {
	this.locationId = locationId;
    }

    public Long getThemeId() {
	return themeId;
    }

    public void setThemeId(Long themeId) {
	this.themeId = themeId;
    }

    @Override
    public String toString() {
	return "{id=" + id + ", name=" + name + ", date=" + date + ", rate=" + rate
		+ ", description=" + description + ", locationId=" + locationId + ", themeId="
		+ themeId + "}";
    }

}
