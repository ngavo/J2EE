package Sermina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Sermina.dao.TonKhoDAO;

@Service
@Transactional
public class TonKhoServiceImpl implements TonKhoService {
	
	@Autowired
	private TonKhoDAO tonkho;
	
	
	@Override
	public int GetTenNhaXuatBanSach(int idSach)
	{
		return tonkho.GetTenNhaXuatBanSach(idSach);
	}
	@Override
	public int GetTenTheLoai(int idSach)
	{
		return tonkho.GetTenTheLoai(idSach);
	}

}
