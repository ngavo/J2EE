package Sermina.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Sermina.model.Sach;

@Repository
public interface SachDAOJpa extends CrudRepository<Sach, Integer> {

}
