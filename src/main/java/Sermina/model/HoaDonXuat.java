package Sermina.model;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Table(name="hoadonxuat")
public class HoaDonXuat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="ngayban")
	@JsonSerialize(using=JsonDateSerializer.class)
	private Date NgayBan;
	
	@Column(name="tongtien")
	private Long TongTien;
	
	
	@ManyToOne
	@JoinColumn(name="id_khachhang")
	@JsonManagedReference
	private KhachHang khachhang;
	
	@OneToMany(mappedBy="hoadonxuat",fetch=FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JsonBackReference
	private List<HoaDonXuat_Sach> hoadonxuat_sach = new ArrayList<HoaDonXuat_Sach>(); 
	
	public KhachHang getKhachhang() {
		return khachhang;
	}

	public void setKhachhang(KhachHang khachhang) {
		this.khachhang = khachhang;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<HoaDonXuat_Sach> getHoadonxuat_sach() {
		return hoadonxuat_sach;
	}

	public void setHoadonxuat_sach(List<HoaDonXuat_Sach> hoadonxuat_sach) {
		this.hoadonxuat_sach = hoadonxuat_sach;
	}

	
	
	
	

}
