package co.edu.uco.ucobet.generales.application.secondaryports.entity;

import java.util.UUID;

import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



 @Entity
 @Table(name = "State")
public final class StateEntiy {
	 
		 @Id
		 @Column(name = "id")
		private UUID  id;
		 
		 @Column(name = "name")
		private String name;
		 
		 @ManyToOne
		 @JoinColumn(name = "country")
		private CountryEntity country;
		
		StateEntiy() {
			setId(UUIDHelper.getDefault());
			setName(TextHelper.EMPTY);
			setCountry(CountryEntity.create());
		}
		
		public StateEntiy(final UUID id, final String name,final CountryEntity country) {
			setId(id);
			setName(name);
			setCountry(country);
		}
		
		public static final StateEntiy create(){
	        return new StateEntiy();
	    }
	    public static final StateEntiy create(final UUID id){
	        return new StateEntiy(id, TextHelper.EMPTY, CountryEntity.create());
	    }
	    public static final StateEntiy create(final UUID id, final String name, final CountryEntity country ){
	    	return new StateEntiy(id,name,country);
	    }

		
		public CountryEntity getCountry() {
			return country;
		}

		public void setCountry(final CountryEntity country) {
			this.country = ObjectHelper.getDefault(country, CountryEntity.create());
		}

		public UUID getId() {
			return id;
		}
		public void setId(final UUID id) {
			this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());;
		}
		public String getName() {
			return name;
		}
		public void setName(final String name) {
			this.name = name;
		}

}
