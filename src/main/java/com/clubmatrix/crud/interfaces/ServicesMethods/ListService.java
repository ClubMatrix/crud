package com.clubmatrix.crud.interfaces.ServicesMethods;

import java.util.ArrayList;
import java.util.Map;

public interface ListService<T> {
  ArrayList<T> list(Map<String, Object> filters, Map<String, String> sort, int page, int size);
}
