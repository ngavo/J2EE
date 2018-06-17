package Sermina.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import Sermina.model.JsonDateSerializer;

public class GetHoaDonXuatChiTietDto {
	
	private String tenKhachHang;
	
	@JsonSerialize(using=JsonDateSerializer.class)
	private Date NgayBan;
	
	private Long TongTien;
	
	List<GetSachChoChiTietHoaDonXuat> getSach =new ArrayList<GetSachChoChiTietHoaDonXuat>();

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public Date getNgayBan() {
		return NgayBan;
	}

	public void setNgayBan(Date ngayBan) {
		NgayBan = ngayBan;
	}

	public Long getTongTien() {
		return TongTien;
	}

	public void setTongTien(Long tongTien) {
		TongTien = tongTien;
	}

	public List<GetSachChoChiTietHoaDonXuat> getGetSach() {
		return getSach;
	}

	public void setGetSach(List<GetSachChoChiTietHoaDonXuat> getSach) {
		this.getSach = getSach;
	}
	
	
	
	

}
