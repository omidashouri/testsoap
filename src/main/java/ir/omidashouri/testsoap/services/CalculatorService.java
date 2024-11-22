package ir.omidashouri.testsoap.services;

import ir.omidashouri.testsoap.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;


@Slf4j
public class CalculatorService extends WebServiceGatewaySupport implements CalculatorSoap {

    private final ObjectFactory objectFactory = new ObjectFactory();

    @Override
    public int subtract(int intA, int intB) {
        Subtract subtract = objectFactory.createSubtract();
        subtract.setIntA(intA);
        subtract.setIntB(intB);
        SubtractResponse response = (SubtractResponse) getWebServiceTemplate()
                .marshalSendAndReceive(subtract, new SoapActionCallback("http://tempuri.org/Subtract"));
        log.info("Subtract response: {}", response);
        return response.getSubtractResult();
    }

    @Override
    public int divide(int intA, int intB) {
        Divide divide = objectFactory.createDivide();
        divide.setIntA(intA);
        divide.setIntB(intB);
        DivideResponse response = (DivideResponse) getWebServiceTemplate()
                .marshalSendAndReceive(divide, new SoapActionCallback("http://tempuri.org/Divide"));
        log.info("Divide response: {}", response);
        return response.getDivideResult();
    }

    @Override
    public int add(int intA, int intB) {
        Add add = objectFactory.createAdd();
        add.setIntA(intA);
        add.setIntB(intB);
        AddResponse response = (AddResponse) getWebServiceTemplate()
                .marshalSendAndReceive(add, new SoapActionCallback("http://tempuri.org/Add"));
        log.info("Add response: {}", response);
        return response.getAddResult();
    }

    @Override
    public int multiply(int intA, int intB) {
        Multiply multiply = objectFactory.createMultiply();
        multiply.setIntA(intA);
        multiply.setIntB(intB);
        MultiplyResponse response = (MultiplyResponse) getWebServiceTemplate()
                .marshalSendAndReceive(multiply, new SoapActionCallback("http://tempuri.org/Multiply"));
        log.info("Multiply response: {}", response);
        return response.getMultiplyResult();
    }

}