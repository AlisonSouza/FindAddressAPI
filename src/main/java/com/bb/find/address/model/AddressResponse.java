package com.bb.find.address.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AddressResponse implements Serializable {
	private static final long serialVersionUID = 1L;

    private List<AddressResult> results = new ArrayList<AddressResult>();

    public AddressResponse() {
    }

	public List<AddressResult> getResults() {
		return results;
	}

	public void setResults(List<AddressResult> results) {
		this.results = results;
	}

}
