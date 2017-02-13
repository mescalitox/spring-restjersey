package com.journaldev.orm.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb0237_vehicle_project database table.
 * 
 */
@Entity
@Table(name="tb0237_vehicle_project")
@NamedQuery(name="Tb0237VehicleProject.findAll", query="SELECT t FROM Tb0237VehicleProject t")
public class Tb0237VehicleProject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="vehicle_project_name")
	private String vehicleProjectName;

	//bi-directional many-to-one association to Tb0254VehicleBodyType
	@OneToMany(mappedBy="tb0237VehicleProject")
	private List<Tb0254VehicleBodyType> tb0254VehicleBodyTypes;

	public Tb0237VehicleProject() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVehicleProjectName() {
		return this.vehicleProjectName;
	}

	public void setVehicleProjectName(String vehicleProjectName) {
		this.vehicleProjectName = vehicleProjectName;
	}

	public List<Tb0254VehicleBodyType> getTb0254VehicleBodyTypes() {
		return this.tb0254VehicleBodyTypes;
	}

	public void setTb0254VehicleBodyTypes(List<Tb0254VehicleBodyType> tb0254VehicleBodyTypes) {
		this.tb0254VehicleBodyTypes = tb0254VehicleBodyTypes;
	}

	public Tb0254VehicleBodyType addTb0254VehicleBodyType(Tb0254VehicleBodyType tb0254VehicleBodyType) {
		getTb0254VehicleBodyTypes().add(tb0254VehicleBodyType);
		tb0254VehicleBodyType.setTb0237VehicleProject(this);

		return tb0254VehicleBodyType;
	}

	public Tb0254VehicleBodyType removeTb0254VehicleBodyType(Tb0254VehicleBodyType tb0254VehicleBodyType) {
		getTb0254VehicleBodyTypes().remove(tb0254VehicleBodyType);
		tb0254VehicleBodyType.setTb0237VehicleProject(null);

		return tb0254VehicleBodyType;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		return this.id.toString() + this.vehicleProjectName;
	}

}