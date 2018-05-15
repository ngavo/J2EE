package Sermina.dao;

import java.util.List;

import Sermina.model.TheLoai;

public interface TheLoaiDAO {
	
	public void addTheLoai(TheLoai theLoai);
	public List<TheLoai> getAllTheLoai();
	public void deleteTheLoai(int ID);
    public TheLoai updateTheLoai(TheLoai theLoai);
    public TheLoai getTheLoai(int ID);
}
