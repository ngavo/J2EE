package Sermina.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="chitiethoadonnhap")
public class ChiTietHoaDonNhap implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="soluongnhap")
	private int SoLuongNhap; //so luong nhap cua 1 quyen sach
	
	@OneToOne
	@JoinColumn(name="id_hoadonnhap")
	private HoaDonNhap hoadonnhap;
	
	@ManyToMany(mappedBy="chitiethoadonnhap")
	private List<Sach> sach = new ArrayList<Sach>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSoLuongNhap() {
		return SoLuongNhap;
	}

	public void setSoLuongNhap(int soLuongNhap) {
		SoLuongNhap = soLuongNhap;
	}

	public HoaDonNhap getHoadonnhap() {
		return hoadonnhap;
	}

	public void setHoadonnhap(HoaDonNhap hoadonnhap) {
		this.hoadonnhap = hoadonnhap;
	}

	public List<Sach> getSach() {
		return sach;
	}

	public void setSach(List<Sach> sach) {
		this.sach = sach;
	}
	
	

}
