package Sermina.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Sermina.model.HoaDonNhap;

@Repository
public interface HoaDonNhapDAOJpa extends CrudRepository<HoaDonNhap, Integer> {

}
