package com.riseslabs.registration.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.riseslabs.registration.model.ActivityModel;
import com.riseslabs.registration.repository.ActivityRepository;
import com.riseslabs.registration.model.ActivityRequestModel;
import com.riseslabs.registration.model.UpdateActivityRequestModel;
import com.riseslabs.registration.model.UseridRequestModel;

@Service
public class ActivityServiceImpl {

	@Autowired
	private ActivityRepository activateRepository;

	public ResponseEntity<String> addActivity(ActivityRequestModel request) {
		var activity = ActivityModel.builder().title(request.getTitle()).description(request.getDesccription())
				.startTime(request.getParsedStartTime()).endTime(request.getParsedEndTime())
				.time(request.getLocalTime()).date(request.getLocalDate()).userid(request.getUserid()).build();

		ActivityModel actEntity = activateRepository.save(activity);

		if (actEntity != null)
			return ResponseEntity.status(HttpStatus.OK).body("{\"status\": true}");
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"status\": false}");

	}

	public List<ActivityModel> showAllTodayActivities(UseridRequestModel request) {

		List<ActivityModel> activityModels = activateRepository.findByUserid(request.getUserid());

		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = currentDate.format(formatter);

		List<ActivityModel> todayActivities = activityModels.stream()
				.filter(activity -> activity.getDate().toString().equals(formattedDate)).collect(Collectors.toList());

		return todayActivities;
	}

	public List<ActivityModel> showLastWeekActivities(UseridRequestModel request) {
		// Get all activities for the user
		List<ActivityModel> activityModels = activateRepository.findByUserid(request.getUserid());

		// Get today's date
		LocalDate currentDate = LocalDate.now().minusDays(1);

		// Compute the start date for the last one week (7 days ago)
		LocalDate startDate = currentDate.minusDays(7);

		// Filter activities within the date range (from 7 days ago to yesterday at
		// 11:59 PM)
		List<ActivityModel> lastWeekActivities = activityModels.stream().filter(activity -> {
			LocalDate activityDate = activity.getDate();
			return (!activityDate.isBefore(startDate) && !activityDate.isAfter(currentDate));
		}).collect(Collectors.toList());

		return lastWeekActivities;
	}

	public List<ActivityModel> showLastMonthActivities(UseridRequestModel request) {
		// Get all activities for the user
		List<ActivityModel> activityModels = activateRepository.findByUserid(request.getUserid());

		// Get today's date
		LocalDate currentDate = LocalDate.now().minusDays(1);

		// Compute the start date for the last one week (30 days ago)
		LocalDate startDate = currentDate.minusDays(30);

		// Filter activities within the date range (from 30 days ago to yesterday at
		// 11:59 PM)
		List<ActivityModel> lastWeekActivities = activityModels.stream().filter(activity -> {
			LocalDate activityDate = activity.getDate();
			return (!activityDate.isBefore(startDate) && !activityDate.isAfter(currentDate));
		}).collect(Collectors.toList());

		return lastWeekActivities;
	}

	public List<ActivityModel> showLastYearActivities(UseridRequestModel request) {
		// Get all activities for the user
		List<ActivityModel> activityModels = activateRepository.findByUserid(request.getUserid());

		// Get today's date
		LocalDate currentDate = LocalDate.now().minusDays(1);

		// Compute the start date for the last one week (365 days ago)
		LocalDate startDate = currentDate.minusDays(365);

		// Filter activities within the date range (from 365 days ago to yesterday at
		// 11:59 PM)
		List<ActivityModel> lastWeekActivities = activityModels.stream().filter(activity -> {
			LocalDate activityDate = activity.getDate();
			return (!activityDate.isBefore(startDate) && !activityDate.isAfter(currentDate));
		}).collect(Collectors.toList());

		return lastWeekActivities;
	}

	public ResponseEntity<String> deleteActivity(UseridRequestModel request) {
		UUID uuid = UUID.fromString(request.getUserid());
		ActivityModel actEntity = activateRepository.findById(uuid).get();
		activateRepository.delete(actEntity);
		return ResponseEntity.status(HttpStatus.OK).body("{\"status\": true}");
	}
	
	public ResponseEntity<String> updateActivity(UpdateActivityRequestModel request){
		var activity = ActivityModel.builder().title(request.getTitle()).description(request.getDesccription())
				.startTime(request.getParsedStartTime()).id(UUID.fromString(request.getId())).endTime(request.getParsedEndTime())
				.time(request.getLocalTime()).date(request.getLocalDate()).userid(request.getUserid()).build();

		ActivityModel actEntity = activateRepository.save(activity);

		if (actEntity != null)
			return ResponseEntity.status(HttpStatus.OK).body("{\"status\": true}");
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"status\": false}");
	}

}
