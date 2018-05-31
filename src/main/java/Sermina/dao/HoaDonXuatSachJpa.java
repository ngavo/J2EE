package Sermina.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Sermina.model.HoaDonXuat_Sach;

@Repository
public interface HoaDonXuatSachJpa extends CrudRepository<HoaDonXuat_Sach, Integer> {

}
