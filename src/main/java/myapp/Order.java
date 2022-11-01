package myapp;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "Orders")
public class Order {

    @Id
    @GeneratedValue ( strategy = GenerationType.AUTO )
    private Long     id;

	private String seller;
	
	private String buyer;
		
	private Long price;
	
	/** For Hibernate */
    public Order () {
    
    }
	
	public String getSeller(){
		return this.seller;
	}
	
	public void setSeller(String seller){
		this.seller = seller;
	}

	public String getBuyer(){
		return this.buyer;
	}
	
	public void setBuyer(String buyer){
		this.buyer = buyer;
	}
	
	public Long getPrice(){
		return this.price;
	}
	
	public void setPrice(Long price){
		this.price = price;
	}

}
