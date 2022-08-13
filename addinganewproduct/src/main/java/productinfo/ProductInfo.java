package productinfo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class ProductInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int proid;
	@Column(length=20)
	private String name;
	@Column
	private int cost;
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getproid() {
		return proid;
	}
	public void setproid(int proid) {
		this.proid = proid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
