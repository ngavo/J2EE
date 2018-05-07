package Sermina.model;

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
import javax.persistence.Table;

@Entity
@Table(name="hoadonnhap")
public class HoaDonNhap implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="ngaynhap")
	private Date NgayNhap;
	
	@Column(name="tongtien")
	private Long TongTien;
	
	@OneToOne(mappedBy="hoadonnhap", cascade= CascadeType.ALL)
	private ChiTietHoaDonNhap chitiethoadonnhap;
	
	@ManyToOne
	@JoinColumn(name="id_nhaxuatban")
	private NhaXuatBan nhaxuatban;
	
	
	
	
	public NhaXuatBan getNhaxuatban() {
		return nhaxuatban;
	}

	public void setNhaxuatban(NhaXuatBan nhaxuatban) {
		this.nhaxuatban = nhaxuatban;
	}

	public ChiTietHoaDonNhap getChitiethoadonnhap() {
		return chitiethoadonnhap;
	}

	public void setChitiethoadonnhap(ChiTietHoaDonNhap chitiethoadonnhap) {
		this.chitiethoadonnhap = chitiethoadonnhap;
	}

	public Date getNgayNhap() {
		return NgayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		NgayNhap = ngayNhap;
	}

	public Long getTongTien() {
		return TongTien;
	}

	public void setTongTien(Long tongTien) {
		TongTien = tongTien;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
