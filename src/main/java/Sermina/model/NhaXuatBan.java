package Sermina.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="nhaxuatban")
public class NhaXuatBan implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2620449139283948004L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="tennhaxuatban")
	private String TenNhaXuatBan;
	
	@Column(name="diachi")
	private String DiaChi;
	
	@Column(name="sodienthoai")
	private String SoDienThoai;
	
	@Column(name="email")
	private String Email;

	
	@OneToMany(mappedBy="nhaxuatban", cascade = CascadeType.ALL)
	private List<Sach> sachs = new ArrayList<Sach>();
	
	
	@OneToMany(mappedBy="nhaxuatban", cascade=CascadeType.ALL)
	private List<HoaDonNhap> hoadonhap = new ArrayList<HoaDonNhap>();
	
	
	
	public List<HoaDonNhap> getHoadonhap() {
		return hoadonhap;
	}

	public void setHoadonhap(List<HoaDonNhap> hoadonhap) {
		this.hoadonhap = hoadonhap;
	}

	public List<Sach> getSachs() {
		return sachs;
	}

	public void setSachs(List<Sach> sachs) {
		this.sachs = sachs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenNhaXuatBan() {
		return TenNhaXuatBan;
	}

	public void setTenNhaXuatBan(String tenNhaXuatBan) {
		TenNhaXuatBan = tenNhaXuatBan;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public String getSoDienThoai() {
		return SoDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		SoDienThoai = soDienThoai;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
	
	
}
