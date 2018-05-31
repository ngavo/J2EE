package Sermina.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Sermina.model.KhachHang;

@Repository
public interface KhachHangDAOJpa extends CrudRepository<KhachHang, Integer> {

}
