package ru.qiwi.demo;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import ru.qiwi.demo.Clients.CBRClient;
import ru.qiwi.demo.Components.MainComponent;

import javax.xml.bind.JAXBException;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	MainComponent mainComponent;
	CBRClient cbrClient;

	@Test
	void connectionTest(){
		Assertions.assertEquals(cbrClient.datedCodes("02/03/2002").getStatusCode(), 200);
	}
	@Test
	//currency_rates --code=USD --date=02/03/2002
	void testCodeUSDDate02032002() throws JAXBException {
		Assertions.assertEquals(mainComponent.getCurrentRate("USD", "02/03/2002"), "USD : 30.9436");
	}
	@Test
	void invalidDataTest() throws JAXBException {
		Assertions.assertEquals(mainComponent.getCurrentRate("USD", "ddfs"), "Invalid date. Please give date in format dd/MM/yyyy");
	}
	@Test
	void invalidCode() throws JAXBException{
		Assertions.assertEquals(mainComponent.getCurrentRate("XXX", "02/03/2002"), "Valute code not found");
	}


}
