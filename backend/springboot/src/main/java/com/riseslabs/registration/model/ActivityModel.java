package com.riseslabs.registration.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="Activity_table")
public class ActivityModel {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="UUID")
	@Column(nullable=false,updatable=false)
	private UUID id;
	private String title;
	private String description;
	private LocalTime startTime;
	private LocalTime endTime;
	private LocalTime time;
	private LocalDate date;
	private String userid; 
}
