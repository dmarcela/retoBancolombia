package com.app.rest.repository;

import com.app.rest.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ILogsRepository extends JpaRepository<Log, Integer>{

}
