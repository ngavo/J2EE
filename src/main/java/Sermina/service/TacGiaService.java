package Sermina.service;

import java.util.List;

import Sermina.model.TacGia;

public interface TacGiaService {
	public void addTacGia(TacGia tacgia);
	 
    public List<TacGia> getAllTacGia();
 
    public void deleteTacGia(int tacgiaId);
 
    public TacGia getTacGia(int tacgiaid);
 
    public TacGia updateTacGia(TacGia tacgia);


}
