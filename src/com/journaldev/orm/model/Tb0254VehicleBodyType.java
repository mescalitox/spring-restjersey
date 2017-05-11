package com.journaldev.orm.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb0254_vehicle_body_type database table.
 * 
 */
@Entity
@Table(name="tb0254_vehicle_body_type")
@NamedQuery(name="Tb0254VehicleBodyType.findAll", query="SELECT t FROM Tb0254VehicleBodyType t")
public class Tb0254VehicleBodyType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="vehicle_body_type_name")
	private String vehicleBodyTypeName;

	@Column(name="vehicle_body_type_status")
	private Boolean vehicleBodyTypeStatus;

	//bi-directional many-to-one association to Tb0237VehicleProject
	@ManyToOne
	@JoinColumn(name="vehicle_project_id")
	private Tb0237VehicleProject tb0237VehicleProject;

	public Tb0254VehicleBodyType() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVehicleBodyTypeName() {
		return this.vehicleBodyTypeName;
	}

	public void setVehicleBodyTypeName(String vehicleBodyTypeName) {
		this.vehicleBodyTypeName = vehicleBodyTypeName;
	}

	public Boolean getVehicleBodyTypeStatus() {
		return this.vehicleBodyTypeStatus;
	}

	public void setVehicleBodyTypeStatus(Boolean vehicleBodyTypeStatus) {
		this.vehicleBodyTypeStatus = vehicleBodyTypeStatus;
	}

	public Tb0237VehicleProject getTb0237VehicleProject() {
		return this.tb0237VehicleProject;
	}

	public void setTb0237VehicleProject(Tb0237VehicleProject tb0237VehicleProject) {
		this.tb0237VehicleProject = tb0237VehicleProject;
	}

}