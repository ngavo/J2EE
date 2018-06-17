package Sermina.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Sermina.model.TheLoai;

@Repository
public interface TheLoaiJpa extends CrudRepository<TheLoai, Integer> {

}
