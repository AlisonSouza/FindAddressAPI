package com.bb.find.address;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.code.geocoder.model.GeocodeResponse;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApplicationTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void shouldReturnAmsterdamLocation() {
		ResponseEntity<GeocodeResponse> response = restTemplate.exchange("/camel/find?address=Amsterdam",
				HttpMethod.GET, null, new ParameterizedTypeReference<GeocodeResponse>() {
				});
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		GeocodeResponse res = response.getBody();
		assertThat(res.getResults()).isNotEmpty();
		assertThat(res.getResults()).element(0).hasFieldOrPropertyWithValue("formattedAddress",
				"Amsterdam, Netherlands");
	}
}