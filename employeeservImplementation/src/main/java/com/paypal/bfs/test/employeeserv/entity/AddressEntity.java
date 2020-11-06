package com.paypal.bfs.test.employeeserv.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "address")
public class AddressEntity {

	

	    @Id
	    @Column(name = "id")
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Long id;
	   
	    @Column(name ="line1")
	    private String line1;
	    @Column(name ="line2")
	    private String line2;
	    /**
	     * 
	     * (Required)
	     * 
	     */
	    @Column(name ="city")
	    private String city;
	    /**
	     * 
	     * (Required)
	     * 
	     */
	    @Column(name ="state")
	    private String state;
	    /**
	     * 
	     * (Required)
	     * 
	     */
	    @Column(name ="country")
	    private String country;
	    /**
	     * 
	     * (Required)
	     * 
	     */
	    @Column(name ="zip_code")
	    private String zipCode;
	 
	    @OneToOne(mappedBy = "address")
	    private EmployeeEntity employee;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getLine1() {
			return line1;
		}

		public void setLine1(String line1) {
			this.line1 = line1;
		}

		public String getLine2() {
			return line2;
		}

		public void setLine2(String line2) {
			this.line2 = line2;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getZipCode() {
			return zipCode;
		}

		public void setZipCode(String zipCode) {
			this.zipCode = zipCode;
		}

		public EmployeeEntity getEmployee() {
			return employee;
		}

		public void setEmployee(EmployeeEntity employee) {
			this.employee = employee;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((city == null) ? 0 : city.hashCode());
			result = prime * result + ((country == null) ? 0 : country.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((line1 == null) ? 0 : line1.hashCode());
			result = prime * result + ((line2 == null) ? 0 : line2.hashCode());
			result = prime * result + ((state == null) ? 0 : state.hashCode());
			result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			AddressEntity other = (AddressEntity) obj;
			if (city == null) {
				if (other.city != null)
					return false;
			} else if (!city.equals(other.city))
				return false;
			if (country == null) {
				if (other.country != null)
					return false;
			} else if (!country.equals(other.country))
				return false;
			
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (line1 == null) {
				if (other.line1 != null)
					return false;
			} else if (!line1.equals(other.line1))
				return false;
			if (line2 == null) {
				if (other.line2 != null)
					return false;
			} else if (!line2.equals(other.line2))
				return false;
			if (state == null) {
				if (other.state != null)
					return false;
			} else if (!state.equals(other.state))
				return false;
			if (zipCode == null) {
				if (other.zipCode != null)
					return false;
			} else if (!zipCode.equals(other.zipCode))
				return false;
			return true;
		}
	 
	    
	   
	
}
