package Sermina.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="sach")
public class Sach implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	public List<HoaDonXuat_Sach> getHdxSach() {
		return hdxSach;
	}

	public void setHdxSach(List<HoaDonXuat_Sach> hdxSach) {
		this.hdxSach = hdxSach;
	}

	@Column(name="tensach")
	private String TenSach;
	
	@Column(name="gianhap")
	private Long GiaNhap;
	
	@Column(name="giaban")
	private Long GiaBan;
	
	@Column(name="soluong")
	private Long SoLuong;
	
	
	
	
	public Long getSoLuong() {
		return SoLuong;
	}

	public void setSoLuong(Long soLuong) {
		SoLuong = soLuong;
	}

	public Long getGiaNhap() {
		return GiaNhap;
	}

	public void setGiaNhap(Long giaNhap) {
		GiaNhap = giaNhap;
	}

	public Long getGiaBan() {
		return GiaBan;
	}

	public void setGiaBan(Long giaBan) {
		GiaBan = giaBan;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_nhaxuatban")
	@JsonManagedReference
	private NhaXuatBan nhaxuatban;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_theloai")
	@JsonManagedReference
	private TheLoai theloai;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name="tacgia_sach",
			joinColumns= @JoinColumn(name="sach_id"),
			inverseJoinColumns = @JoinColumn(name="tacgia_id")
			)
	@JsonManagedReference
	private List<TacGia> tacgia = new ArrayList<TacGia>();
	
	
	@OneToMany(mappedBy="sach",fetch=FetchType.LAZY,cascade = CascadeType.REMOVE)
	@JsonManagedReference
	private List<HoaDonNhap_Sach> hdnSach = new ArrayList<HoaDonNhap_Sach>();
	
	
	
	
	public List<HoaDonNhap_Sach> getHdnSach() {
		return hdnSach;
	}

	public void setHdnSach(List<HoaDonNhap_Sach> hdnSach) {
		this.hdnSach = hdnSach;
	}

	
	
	
	@OneToMany(mappedBy="sach",fetch=FetchType.LAZY,cascade = CascadeType.REMOVE)
	@JsonBackReference
	private List<HoaDonXuat_Sach> hdxSach = new ArrayList<HoaDonXuat_Sach>();
	

	public List<TacGia> getTacgia() {
		return tacgia;
	}

	public void setTacgia(List<TacGia> tacgia) {
		this.tacgia = tacgia;
	}

	public TheLoai getTheloai() {
		return theloai;
	}

	public void setTheloai(TheLoai theloai) {
		this.theloai = theloai;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenSach() {
		return TenSach;
	}

	public void setTenSach(String tenSach) {
		TenSach = tenSach;
	}

	public NhaXuatBan getNhaxuatban() {
		return nhaxuatban;
	}

	public void setNhaxuatban(NhaXuatBan nhaxuatban) {
		this.nhaxuatban = nhaxuatban;
	}
	
	
	

}
