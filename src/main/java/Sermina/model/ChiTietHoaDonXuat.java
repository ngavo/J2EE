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
@Table(name="chitiethoadonxuat")
public class ChiTietHoaDonXuat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="soluongxuat")
	private int SoLuongXuat; //so luong xuat cua 1 quyen sach
	
	@OneToOne
	@JoinColumn(name="id_hoadonxuat")
	private HoaDonXuat hoadonxuat;
	
	@ManyToMany(mappedBy="chitiethoadonxuat")
	private List<Sach> sach = new ArrayList<Sach>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSoLuongXuat() {
		return SoLuongXuat;
	}

	public void setSoLuongXuat(int soLuongXuat) {
		SoLuongXuat = soLuongXuat;
	}

	public HoaDonXuat getHoadonxuat() {
		return hoadonxuat;
	}

	public void setHoadonxuat(HoaDonXuat hoadonxuat) {
		this.hoadonxuat = hoadonxuat;
	}

	public List<Sach> getSach() {
		return sach;
	}

	public void setSach(List<Sach> sach) {
		this.sach = sach;
	}
	
	
	

}
