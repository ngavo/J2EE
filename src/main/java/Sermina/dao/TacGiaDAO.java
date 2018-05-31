package Sermina.dao;

import java.util.List;

import Sermina.model.TacGia;

public interface TacGiaDAO {
	
	public void addTacGia(TacGia employee);
	public List<TacGia> getAllTacGia();
	public void deleteTacGia(int TacGiaId);
	 
    public TacGia updateTacGia(TacGia tacgia);
 
    public TacGia getTacGia(int TacGiaid);

}
