package com.riseslabs.registration.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riseslabs.registration.model.ActivityModel;

public interface ActivityRepository extends JpaRepository<ActivityModel, UUID> {
	
	public List<ActivityModel> findByUserid(String str);
}
