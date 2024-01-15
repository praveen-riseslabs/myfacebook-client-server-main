package com.riseslabs.registration.demo;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riseslabs.registration.auth.MailTokenRequest;
import com.riseslabs.registration.service.ActivityServiceImpl;
import com.riseslabs.registration.service.RegistrationServiceImpl;

import lombok.RequiredArgsConstructor;
import com.riseslabs.registration.entity.ActivityEntity;
import com.riseslabs.registration.requests.ActivityRequest;
import com.riseslabs.registration.requests.UpdateActivityRequest;
import com.riseslabs.registration.requests.UseridRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/mainController")
public class DemoController {
	
	private final RegistrationServiceImpl registrationServiceImpl;
	private final ActivityServiceImpl activityServiceImpl;
	
	@PostMapping("/addActivity")
	public ResponseEntity<String> addActivity(@RequestBody ActivityRequest request){
		return activityServiceImpl.addActivity(request);
	}
	
	@PostMapping("/today")
	public List<ActivityEntity> todayActivities(@RequestBody UseridRequest request){
		return activityServiceImpl.showAllTodayActivities(request);
	}
	
	@PostMapping("/oneweek")
	public List<ActivityEntity> oneweekActivities(@RequestBody UseridRequest request){
		return activityServiceImpl.showLastWeekActivities(request);
	}
	
	@PostMapping("/onemonth")
	public List<ActivityEntity> onemonthActivities(@RequestBody UseridRequest request){
		return activityServiceImpl.showLastMonthActivities(request);
	}
	
	@PostMapping("/oneyear")
	public List<ActivityEntity> oneyearActivities(@RequestBody UseridRequest request){
		return activityServiceImpl.showLastYearActivities(request);
	}
	
	@GetMapping("/sample")
	public String hello(){
		return "hello world";
	}
	
	@PostMapping("/resetPassword")
	public ResponseEntity<String> resetPassword(@RequestBody MailTokenRequest request){
		
		return registrationServiceImpl.resetPassword(request);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@RequestBody UseridRequest request){
		return activityServiceImpl.deleteActivity(request);
	}
	
	@PutMapping("/updateActivity")
	public ResponseEntity<String> update(@RequestBody UpdateActivityRequest request){
		return activityServiceImpl.updateActivity(request);
	}

}


