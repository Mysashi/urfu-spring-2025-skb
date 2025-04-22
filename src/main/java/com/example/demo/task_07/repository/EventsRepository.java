package com.example.demo.task_07.repository;


import com.example.demo.task_07.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface EventsRepository extends JpaRepository<Event, Long> {
}
