package Sermina.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Sermina.model.NhaXuatBan;

@Repository
public interface NhaXuatBanJpa extends CrudRepository<NhaXuatBan, Integer> {

}
