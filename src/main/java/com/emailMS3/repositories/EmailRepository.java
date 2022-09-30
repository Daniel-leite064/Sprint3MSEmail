package com.emailMS3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emailMS3.models.Email;

public interface EmailRepository extends JpaRepository<Email, Long> {
	
}
