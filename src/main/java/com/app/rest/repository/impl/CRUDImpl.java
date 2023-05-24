package com.app.rest.repository.impl;

import com.app.rest.repository.ICRUD;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {

  protected abstract JpaRepository<T, ID> getRepository();

  @Override
  public T save(T t) {
    return getRepository().save(t);
  }

  @Override
  public T update(T t) {
    return getRepository().save(t);
  }

  @Override
  public List listAll() {
    return getRepository().findAll();
  }

  @Override
  public T listById(ID id) {
    return getRepository().findById(id).orElse(null);
  }

  @Override
  public void delete(ID id) {
    getRepository().deleteById(id);
  }
}
