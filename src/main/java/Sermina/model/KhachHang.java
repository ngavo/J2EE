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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="khachhang")
public class KhachHang implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="hoten")
	private String HoTen;
	
	@Column(name="diachi")
	private String DiaChi;
	
	@Column(name="email")
	private String Email;
	
	@Column(name="sodienthoai")
	private String SoDienThoai;
	
	@OneToMany(mappedBy="khachhang",cascade= CascadeType.REMOVE)
	@JsonBackReference
	private List<HoaDonXuat> hoadonxuat = new ArrayList<HoaDonXuat>();

	public List<HoaDonXuat> getHoadonxuat() {
		return hoadonxuat;
	}

	public void setHoadonxuat(List<HoaDonXuat> hoadonxuat) {
		this.hoadonxuat = hoadonxuat;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHoTen() {
		return HoTen;
	}

	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getSoDienThoai() {
		return SoDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		SoDienThoai = soDienThoai;
	}
	
	 

}
