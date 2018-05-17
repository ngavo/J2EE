package Sermina.service;

import java.util.List;

import Sermina.model.NhaXuatBan;

public interface NXBService {

	public void addNXB(NhaXuatBan NXB);
	 
    public List<NhaXuatBan> getAllNXB();
 
    public void deleteNXB(int ID);
 
    public NhaXuatBan getNXB(int ID);
 
    public NhaXuatBan updateNXB(NhaXuatBan NXB);

}
