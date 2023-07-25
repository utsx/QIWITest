package ru.qiwi.demo.Components;

import org.bouncycastle.util.Times;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.xml.sax.InputSource;
import org.yaml.snakeyaml.reader.StreamReader;
import ru.qiwi.demo.Clients.CBRClient;
import ru.qiwi.demo.Contexts.ValCurs;
import ru.qiwi.demo.Contexts.Valute;

import javax.swing.text.DateFormatter;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.util.StreamReaderDelegate;
import java.io.File;
import java.io.FileReader;
import java.io.StringReader;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

@Component
public class MainComponent {

    private final CBRClient cbrClient;

    @Autowired
    public MainComponent(CBRClient cbrClient) {
        this.cbrClient = cbrClient;
    }
    public String getCurrentRate(String code, String date) throws JAXBException {
        System.out.println(code + ":" + date);
        try {
            SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");
            Date date1 = parser.parse(date);
        }
        catch (Exception e){
            return "Invalid date. Please give date in format dd/MM/yyyy";
        }
        ResponseEntity<String> rates = cbrClient.datedCodes(date);
        StringReader reader = new StringReader(Objects.requireNonNull(rates.getBody()));
        JAXBContext context = JAXBContext.newInstance(ValCurs.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        ValCurs valCurs = (ValCurs) unmarshaller.unmarshal(reader);
        System.out.println(valCurs);
        if(rates.getStatusCode().equals(404) && rates.equals(ResponseEntity.status(500))) {
            return "Invalid args";
        }
        if(valCurs.getValuteList() == null){
            return "Current date rate not found. Please give another date";
        }
        for(Valute currentValute : valCurs.getValuteList()){
                if(currentValute.getCharCode().equals(code)){
                    return code + " : " + currentValute.getValue();
                }
        }
       return "Valute code not found";
    }
}


