package com.bb.find.address.bean;

import org.apache.camel.Exchange;
import org.apache.camel.Header;

import com.bb.find.address.model.AddressResponse;
import com.bb.find.address.model.AddressResult;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderResult;

public class ParserBean {

	public void parserToNewTemplate(Exchange exchange, @Header("address") String address) {
		GeocodeResponse response = (GeocodeResponse) exchange.getIn().getBody();
		
		AddressResponse addressResponse = new AddressResponse();
		if(response.getResults().size() > 0) {
			
			for(GeocoderResult result : response.getResults()) {
				AddressResult addressResult = new AddressResult();
				addressResult.setFormattedAddress(result.getFormattedAddress());
				addressResult.setLocation(result.getGeometry().getLocation());
				addressResponse.getResults().add(addressResult);
			}
		}
		exchange.getIn().setBody(addressResponse);
	}
}
