package Sermina.model;

import javax.persistence.Table;

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

@Entity
@Table(name="tacgia")
public class TacGia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="tentacgia")
	private String TenTacGia;
	
	@ManyToMany(cascade= CascadeType.ALL)
	@JoinTable(
			name="tacgia_sach",
			joinColumns= @JoinColumn(name="tacgia_id"),
			inverseJoinColumns = @JoinColumn(name="sach_id")
			)
	List<Sach> sach = new ArrayList<Sach>();
	
	

	public List<Sach> getSach() {
		return sach;
	}

	public void setSach(List<Sach> sach) {
		this.sach = sach;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenTacGia() {
		return TenTacGia;
	}

	public void setTenTacGia(String tenTacGia) {
		TenTacGia = tenTacGia;
	}
	
	
	

}
