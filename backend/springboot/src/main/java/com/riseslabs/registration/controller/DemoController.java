package com.riseslabs.registration.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riseslabs.registration.model.PasswordConfirmationModel;
import com.riseslabs.registration.model.ActivityModel;
import com.riseslabs.registration.service.ActivityServiceImpl;
import com.riseslabs.registration.service.RegistrationServiceImpl;

import lombok.RequiredArgsConstructor;

import com.riseslabs.registration.model.ActivityRequestModel;
import com.riseslabs.registration.model.UpdateActivityRequestModel;
import com.riseslabs.registration.model.UseridRequestModel;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/private")
public class DemoController {
	
	private final RegistrationServiceImpl registrationServiceImpl;
	private final ActivityServiceImpl activityServiceImpl;
	
	@PostMapping("/addactivity")
	public ResponseEntity<String> addActivity(@RequestBody ActivityRequestModel request){
		return activityServiceImpl.addActivity(request);
	}
	
	@PostMapping("/today")
	public List<ActivityModel> todayActivities(@RequestBody UseridRequestModel request){
		return activityServiceImpl.showAllTodayActivities(request);
	}
	
	@PostMapping("/oneweek")
	public List<ActivityModel> oneweekActivities(@RequestBody UseridRequestModel request){
		return activityServiceImpl.showLastWeekActivities(request);
	}
	
	@PostMapping("/onemonth")
	public List<ActivityModel> onemonthActivities(@RequestBody UseridRequestModel request){
		return activityServiceImpl.showLastMonthActivities(request);
	}
	
	@PostMapping("/oneyear")
	public List<ActivityModel> oneyearActivities(@RequestBody UseridRequestModel request){
		return activityServiceImpl.showLastYearActivities(request);
	}
	
	@PostMapping("/resetpassword")
	public ResponseEntity<String> resetPassword(@RequestBody PasswordConfirmationModel request){
		
		return registrationServiceImpl.resetPassword(request);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@RequestBody UseridRequestModel request){
		return activityServiceImpl.deleteActivity(request);
	}
	
	@PutMapping("/updateactivity")
	public ResponseEntity<String> update(@RequestBody UpdateActivityRequestModel request){
		return activityServiceImpl.updateActivity(request);
	}

}


