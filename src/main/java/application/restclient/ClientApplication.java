package application.restclient;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import javax.json.Json;
import javax.json.JsonObject;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ClientApplication {

	final static String managementUrl = "http://localhost:8080/bottle/";
	static RestTemplate restTemplate = new RestTemplate();

	public static void testConnection() {
		ResponseEntity<String> response = restTemplate.getForEntity(managementUrl, String.class);
		assertThat(response.getStatusCode(), is(HttpStatus.OK));		
	}
	
	public static void addBottle(String dateScanned, String drinkName, String bottleType){
		
		JsonObject jsonBottle = Json
				.createObjectBuilder()
				.add("dateScanned", dateScanned)
				.add("drink",
						Json.createObjectBuilder()
								.add("drinkName", drinkName).build())
				.build();

		String requestBody = jsonBottle.toString();
		System.out.println(requestBody);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity<String>(requestBody, headers);
		restTemplate.postForObject(managementUrl, entity, String.class);
	}
}