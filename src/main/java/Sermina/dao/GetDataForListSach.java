package Sermina.dao;

import java.util.ArrayList;
import java.util.List;

public class GetDataForListSach {
	
	private int id;
	private String tenSach;
	private String tenNhaXuatBan;
	private String tenTheLoai;
	private Long giaNhap;
	private Long giaBan;
	
	private List<String> listTenTacGia = new ArrayList<String>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public String getTenNhaXuatBan() {
		return tenNhaXuatBan;
	}

	public void setTenNhaXuatBan(String tenNhaXuatBan) {
		this.tenNhaXuatBan = tenNhaXuatBan;
	}

	public String getTenTheLoai() {
		return tenTheLoai;
	}

	public void setTenTheLoai(String tenTheLoai) {
		this.tenTheLoai = tenTheLoai;
	}

	public Long getGiaNhap() {
		return giaNhap;
	}

	public void setGiaNhap(Long giaNhap) {
		this.giaNhap = giaNhap;
	}

	public Long getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(Long giaBan) {
		this.giaBan = giaBan;
	}

	public List<String> getListTenTacGia() {
		return listTenTacGia;
	}

	public void setListTenTacGia(List<String> listTenTacGia) {
		this.listTenTacGia = listTenTacGia;
	}
	
	
	

}
