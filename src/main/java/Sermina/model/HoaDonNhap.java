package Sermina.model;

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
import javax.persistence.Table;
import java.sql.Timestamp;

import org.hibernate.jpamodelgen.xml.jaxb.TemporalType;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

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
	@JsonSerialize(using=JsonDateSerializer.class)
	private Date NgayNhap;
	
	@Column(name="tongtien")
	private Long TongTien;
	
	/*@OneToOne(mappedBy="hoadonnhap")
	private ChiTietHoaDonNhap chitiethoadonnhap;*/
	
	@ManyToOne
	@JoinColumn(name="id_nhaxuatban")
	@JsonManagedReference
	private NhaXuatBan nhaxuatban;
	
	@OneToMany(mappedBy="hoadonnhap", fetch=FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JsonBackReference
	private List<HoaDonNhap_Sach> hdnSach = new ArrayList<HoaDonNhap_Sach>();
	
	
	
	
	public List<HoaDonNhap_Sach> getHdnSach() {
		return hdnSach;
	}

	public void setHdnSach(List<HoaDonNhap_Sach> hdnSach) {
		this.hdnSach = hdnSach;
	}

	public NhaXuatBan getNhaxuatban() {
		return nhaxuatban;
	}

	public void setNhaxuatban(NhaXuatBan nhaxuatban) {
		this.nhaxuatban = nhaxuatban;
	}

	/*public ChiTietHoaDonNhap getChitiethoadonnhap() {
		return chitiethoadonnhap;
	}

	public void setChitiethoadonnhap(ChiTietHoaDonNhap chitiethoadonnhap) {
		this.chitiethoadonnhap = chitiethoadonnhap;
	}*/

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
