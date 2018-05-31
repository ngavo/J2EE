package Sermina.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Sermina.model.HoaDonXuat;

@Repository
public interface HoaDonXuatDAOJpa extends CrudRepository<HoaDonXuat, Integer> {

}
