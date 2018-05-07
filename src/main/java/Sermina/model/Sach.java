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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	
	@Column(name="tensach")
	private String TenSach;
	
	@Column(name="gianhap")
	private Long GiaNhap;
	
	@Column(name="giaban")
	private Long GiaBan;
	
	
	
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

	@ManyToOne
	@JoinColumn(name="id_nhaxuatban")
	private NhaXuatBan nhaxuatban;

	@ManyToOne
	@JoinColumn(name="id_theloai")
	private TheLoai theloai;
	
	@ManyToMany(mappedBy="sach")
	private List<TacGia> tacgia = new ArrayList<TacGia>();
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name="sach_chitiethoadonnhap",
			joinColumns= @JoinColumn(name="sach_id"),
			inverseJoinColumns = @JoinColumn(name="chitiethoadonnhap_id")
			)
	private List<ChiTietHoaDonNhap> chitiethoadonnhap = new ArrayList<ChiTietHoaDonNhap>();
	
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name="sach_chitiethoadonxuat",
			joinColumns=@JoinColumn(name="sach_id"),
			inverseJoinColumns = @JoinColumn(name="chitiethoadonxuat_id")
			)
	private List<ChiTietHoaDonXuat> chitiethoadonxuat = new ArrayList<ChiTietHoaDonXuat>();
	
	
	public List<ChiTietHoaDonNhap> getChitiethoadonnhap() {
		return chitiethoadonnhap;
	}

	public void setChitiethoadonnhap(List<ChiTietHoaDonNhap> chitiethoadonnhap) {
		this.chitiethoadonnhap = chitiethoadonnhap;
	}

	public List<ChiTietHoaDonXuat> getChitiethoadonxuat() {
		return chitiethoadonxuat;
	}

	public void setChitiethoadonxuat(List<ChiTietHoaDonXuat> chitiethoadonxuat) {
		this.chitiethoadonxuat = chitiethoadonxuat;
	}

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
