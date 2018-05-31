package Sermina.dto;

import java.util.List;

public class GetInsertSach {
	
	private int idSach;
	private String tenSach;
	private Long giaNhap;
	private Long giaBan;
	private String tenNhaXuatBan;
	private List<Integer> listIdTacGia;
	private String theLoai;
	
	
	
	public int getIdSach() {
		return idSach;
	}
	public void setIdSach(int idSach) {
		this.idSach = idSach;
	}
	public String getTheLoai() {
		return theLoai;
	}
	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
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
	public String getTenNhaXuatBan() {
		return tenNhaXuatBan;
	}
	public void setTenNhaXuatBan(String tenNhaXuatBan) {
		this.tenNhaXuatBan = tenNhaXuatBan;
	}
	public List<Integer> getListIdTacGia() {
		return listIdTacGia;
	}
	public void setListIdTacGia(List<Integer> listIdTacGia) {
		this.listIdTacGia = listIdTacGia;
	}
	
	

}
