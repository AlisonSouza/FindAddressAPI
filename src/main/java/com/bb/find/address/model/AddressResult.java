package com.bb.find.address.model;

import java.io.Serializable;

import com.google.code.geocoder.model.LatLng;

public class AddressResult implements Serializable {

	private static final long serialVersionUID = 1L;

	private String formattedAddress;

	private LatLng location;
	
	public String getFormattedAddress() {
		return formattedAddress;
	}

	public void setFormattedAddress(String formattedAddress) {
		this.formattedAddress = formattedAddress;
	}

	public LatLng getLocation() {
		return location;
	}

	public void setLocation(LatLng location) {
		this.location = location;
	}
}
