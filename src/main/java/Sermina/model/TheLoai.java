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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="theloai")
public class TheLoai implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4638542830743122334L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="tentheloai")
	private String TenTheLoai;
	
	
	@OneToMany(mappedBy="theloai",fetch = FetchType.LAZY, cascade=CascadeType.REMOVE)
	@JsonBackReference
	private List<Sach> sachs = new ArrayList<Sach>();
	
	

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

	public String getTenTheLoai() {
		return TenTheLoai;
	}

	public void setTenTheLoai(String tenTheLoai) {
		TenTheLoai = tenTheLoai;
	}
	
	
	

}
