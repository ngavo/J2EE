package Sermina.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="hoadonnhap_sach")
public class HoaDonNhap_Sach implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idhdn")
	@JsonManagedReference
	private HoaDonNhap hoadonnhap;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idsach")
	@JsonBackReference
	private Sach sach;
	
	@Column(name="soluong")
	private Long SoLuong;
	
	

	public Long getSoLuong() {
		return SoLuong;
	}

	public void setSoLuong(Long soLuong) {
		SoLuong = soLuong;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HoaDonNhap getHoadonnhap() {
		return hoadonnhap;
	}

	public void setHoadonnhap(HoaDonNhap hoadonnhap) {
		this.hoadonnhap = hoadonnhap;
	}

	public Sach getSach() {
		return sach;
	}

	public void setSach(Sach sach) {
		this.sach = sach;
	}

	
	
	
	
	
	
	

}
