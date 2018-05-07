package Sermina.model;

import javax.persistence.Table;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private Date NgayBan;
	
	@Column(name="tongtien")
	private Long TongTien;
	
	
	@OneToOne(mappedBy="hoadonxuat", cascade= CascadeType.ALL)
	private ChiTietHoaDonXuat chitiethoadonxuat;
	
	@ManyToOne
	@JoinColumn(name="id_khachhang")
	private KhachHang khachhang;
	
	
	
	
	
	public ChiTietHoaDonXuat getChitiethoadonxuat() {
		return chitiethoadonxuat;
	}

	public void setChitiethoadonxuat(ChiTietHoaDonXuat chitiethoadonxuat) {
		this.chitiethoadonxuat = chitiethoadonxuat;
	}

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
	
	

}
