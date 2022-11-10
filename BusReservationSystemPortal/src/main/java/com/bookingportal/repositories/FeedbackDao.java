package com.bookingportal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookingportal.models.Feedback;

@Repository
public interface FeedbackDao extends JpaRepository<Feedback, Integer>{

}
