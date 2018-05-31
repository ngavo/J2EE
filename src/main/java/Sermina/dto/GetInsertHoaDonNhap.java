package Sermina.dto;

import java.util.ArrayList;
import java.util.List;

public class GetInsertHoaDonNhap {
	
	private int idHoaDonNhap;
	private String tenNhaXuatBan ;
	
	
	
	public int getIdHoaDonNhap() {
		return idHoaDonNhap;
	}

	public void setIdHoaDonNhap(int idHoaDonNhap) {
		this.idHoaDonNhap = idHoaDonNhap;
	}

	private List<GetDataForDataGridNewSach> listResultObject = new ArrayList<GetDataForDataGridNewSach>();

	public String getTenNhaXuatBan() {
		return tenNhaXuatBan;
	}

	public void setTenNhaXuatBan(String tenNhaXuatBan) {
		this.tenNhaXuatBan = tenNhaXuatBan;
	}

	public List<GetDataForDataGridNewSach> getListResultObject() {
		return listResultObject;
	}

	public void setListResultObject(List<GetDataForDataGridNewSach> listResultObject) {
		this.listResultObject = listResultObject;
	}
	
	

}
