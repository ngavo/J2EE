package Sermina.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Sermina.model.HoaDonNhap_Sach;

@Repository
public interface HoaDonNhapSachDAOJpa extends CrudRepository<HoaDonNhap_Sach, Integer> {

}
