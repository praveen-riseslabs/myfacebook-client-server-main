package com.riseslabs.registration.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActivityRequestModel {

	private String title;
	private String desccription;
	private String startTimeString;
	private String endTimeString;

	public LocalTime getParsedStartTime() {
        return LocalTime.parse(startTimeString);
    }

    public LocalTime getParsedEndTime() {
        return LocalTime.parse(endTimeString);
    }
	
	private String createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
	private String[] dateTimeParts = createdAt.split(" ");
	private String datePart = dateTimeParts[0];
	private String timePart = dateTimeParts[1];

	private LocalDate localDate = LocalDate.parse(datePart, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	private LocalTime localTime = LocalTime.parse(timePart, DateTimeFormatter.ofPattern("HH:mm:ss"));

	private String userid;
}
