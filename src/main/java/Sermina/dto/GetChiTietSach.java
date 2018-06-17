package Sermina.dto;

import java.util.List;

import Sermina.model.TacGia;

public class GetChiTietSach {
	
	private int id;
	private String tenSach;
	private Long giaNhap;
	private Long giaBan;
	private List<TacGia> tenTacGia;
	private String tenNhaXuatBan;
	private String tenTheLoai;
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
	public List<TacGia> getTenTacGia() {
		return tenTacGia;
	}
	public void setTenTacGia(List<TacGia> tenTacGia) {
		this.tenTacGia = tenTacGia;
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
	
	
	
	
	
	

}
