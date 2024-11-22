package ir.omidashouri.testsoap.conf;

import ir.omidashouri.testsoap.services.CalculatorService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import ir.omidashouri.testsoap.model.*;

import java.io.IOException;

@Configuration
public class WebServiceConf {

    @Bean
    public Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("ir.omidashouri.testsoap.model");
        return marshaller;
    }

    @Bean
    public CalculatorService calculatorService(Jaxb2Marshaller jaxb2Marshaller) {
        CalculatorService client = new CalculatorService();
//        search for "soap:address location" in xml/wsdl file
        client.setDefaultUri("http://www.dneonline.com/calculator.asmx");
        client.setMarshaller(jaxb2Marshaller);
        client.setUnmarshaller(jaxb2Marshaller);
        return client;
    }

/*    @Bean
    public CalculatorSoap calculatorSoapClient() {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setWsdlURL("http://www.dneonline.com/calculator.asmx?wsdl"); // Add the ?wsdl suffix if required
        factory.setServiceClass(CalculatorSoap.class);
        factory.setAddress("http://www.dneonline.com/calculator.asmx"); // Correct endpoint
        return (CalculatorSoap) factory.create();
    }*/
}
