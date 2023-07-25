package ru.qiwi.demo.Clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "cbr", url = "https://www.cbr.ru/scripts/")
public interface CBRClient {
    @RequestMapping(method = RequestMethod.GET, value = "XML_daily.asp?date_req={date}")
    ResponseEntity<String> datedCodes(@PathVariable("date") String date);
}
