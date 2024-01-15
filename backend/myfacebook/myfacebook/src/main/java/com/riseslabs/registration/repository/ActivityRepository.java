package com.riseslabs.registration.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riseslabs.registration.entity.ActivityEntity;

public interface ActivityRepository extends JpaRepository<ActivityEntity, UUID> {
	
	public List<ActivityEntity> findByUserid(String str);
}
