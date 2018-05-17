package Sermina.dao;

import java.util.List;

import Sermina.model.NhaXuatBan;

public interface NXBDAO {
	public void addNXB(NhaXuatBan nxb);
	
	public List<NhaXuatBan> getAllNXB();
	
	public void deleteNXB(int ID);
	 
    public NhaXuatBan updateNXB(NhaXuatBan NXB);
 
    public NhaXuatBan getNXB(int ID);
}
