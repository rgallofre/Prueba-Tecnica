package Prueba_Tecnica;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
class Prices {
	
  private @Id
  @GeneratedValue Long id;
  private String PRODUCT_ID;
  private String BRAND_ID;
  private LocalDateTime START_DATE;
  private LocalDateTime END_DATE;
  private String PRICE_LIST;
  private Integer PRIORITY;
  private Float PRICE;
  private String CURR;
  

  Prices() {}

  Prices(String PRODUCT_ID, String BRAND_ID, LocalDateTime START_DATE, LocalDateTime END_DATE, String PRICE_LIST, 
		  Integer PRIORITY, Float PRICE, String CURR) {
	
	this.PRODUCT_ID = PRODUCT_ID;
    this.BRAND_ID = BRAND_ID;
    this.START_DATE = START_DATE;
    this.END_DATE = END_DATE;
    this.PRICE_LIST = PRICE_LIST;
    this.PRIORITY = PRIORITY;
    this.PRICE = PRICE;
    this.CURR = CURR;
    
    
  }
  public Long getId() {
	    return this.id;
	  }
  public void setId(Long id) {
	    this.id = id;
	  }
 

  public String getBRAND_ID() {
	return this.BRAND_ID;
}

public void setBRAND_ID(String BRAND_ID) {
	this.BRAND_ID = BRAND_ID;
}

public LocalDateTime getSTART_DATE() {
	return this.START_DATE;
}

public void setSTART_DATE(LocalDateTime START_DATE) {
	this.START_DATE = START_DATE;
}

public LocalDateTime getEND_DATE() {
	return this.END_DATE;
}

public void setEND_DATE(LocalDateTime END_DATE) {
	this.END_DATE = END_DATE;
}

public String getPRICE_LIST() {
	return this.PRICE_LIST;
}

public void setPRICE_LIST(String PRICE_LIST) {
	this.PRICE_LIST = PRICE_LIST;
}

public String getPRODUCT_ID() {
	return this.PRODUCT_ID;
}

public void setPRODUCT_ID(String PRODUCT_ID) {
	this.PRODUCT_ID = PRODUCT_ID;
}

public Integer getPRIORITY() {
	return this.PRIORITY;
}

public void setPRIORITY(Integer PRIORITY) {
	this.PRIORITY = PRIORITY;
}

public Float getPRICE() {
	return this.PRICE;
}

public void setPRICE(Float PRICE) {
	this.PRICE = PRICE;
}

public String getCURR() {
	return this.CURR;
}

public void setCURR(String CURR) {
	this.CURR = CURR;
}

@Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Prices))
      return false;
    Prices prices = (Prices) o;
    return     Objects.equals(this.id, prices.id) && Objects.equals(this.PRODUCT_ID,prices.PRODUCT_ID) && Objects.equals(this.BRAND_ID,prices.BRAND_ID) && Objects.equals(this.START_DATE, prices.START_DATE) && 
    		   Objects.equals(this.END_DATE,prices.END_DATE) && Objects.equals(this.PRODUCT_ID, prices.PRODUCT_ID) &&
    		   Objects.equals(this.PRIORITY, prices.PRIORITY) && Objects.equals(this.PRICE, prices.PRICE) &&
    		   Objects.equals(this.CURR, prices.CURR);	
    
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id,this.PRODUCT_ID, this.BRAND_ID, this.START_DATE, this.START_DATE, this.END_DATE, this.PRODUCT_ID, this.PRIORITY, this.PRICE, this.CURR);
  }

  @Override
  public String toString() {
    return "Employee{" + "id=" + this.id +" "+  "BRAND_ID=" + this.BRAND_ID + ", START_DATE='" + this.START_DATE + '\'' + ", END_DATE='" + this.END_DATE + '\'' + 
    				"PRODUCT_ID=" + this.PRODUCT_ID + ", PRIORITY='" + this.PRIORITY + '\'' +
    				"PRICE=" + this.PRICE + ", CURR='" + this.CURR + '\'' +'}';
  }
}