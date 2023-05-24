package com.app.rest.repository;

import java.util.List;

public interface ICRUD<T,ID> {
  T save(T t);
  T update(T t);
  List<T> listAll();
  T listById(ID id);
  void delete(ID id);

}
