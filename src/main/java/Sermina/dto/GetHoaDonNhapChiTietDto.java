package Sermina.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import Sermina.model.JsonDateSerializer;

public class GetHoaDonNhapChiTietDto {
	
	private String tenNhaXuatBan;
	
	@JsonSerialize(using=JsonDateSerializer.class)
	private Date ngayNhap;
	
	private Long tongTien;
	
	List<GetSachChoChiTietHoaDonXuat> getSachHDN = new ArrayList<GetSachChoChiTietHoaDonXuat>();

	public String getTenNhaXuatBan() {
		return tenNhaXuatBan;
	}

	public void setTenNhaXuatBan(String tenNhaXuatBan) {
		this.tenNhaXuatBan = tenNhaXuatBan;
	}

	public Date getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public Long getTongTien() {
		return tongTien;
	}

	public void setTongTien(Long tongTien) {
		this.tongTien = tongTien;
	}

	public List<GetSachChoChiTietHoaDonXuat> getGetSachHDN() {
		return getSachHDN;
	}

	public void setGetSachHDN(List<GetSachChoChiTietHoaDonXuat> getSachHDN) {
		this.getSachHDN = getSachHDN;
	}
	
	
	

}
