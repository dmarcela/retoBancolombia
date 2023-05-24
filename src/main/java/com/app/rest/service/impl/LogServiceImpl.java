package com.app.rest.service.impl;

import com.app.rest.model.Log;
import com.app.rest.repository.ILogsRepository;
import com.app.rest.repository.impl.CRUDImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class LogServiceImpl extends CRUDImpl<Log, Integer> {

  @Autowired
  private ILogsRepository logsRepository;


  @Override
  protected JpaRepository<Log, Integer> getRepository() {
    return null;
  }
}
