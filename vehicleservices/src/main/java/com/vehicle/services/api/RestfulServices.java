package com.vehicle.services.api;

import com.vehicle.services.dao.VehicleServicesModel;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.Map;

@Controller
@RequestMapping(value = "/school/api")
public class RestfulServices {
    @Autowired
    public VehicleServicesModel model;

    private ObjectMapper om = new ObjectMapper();

    @RequestMapping(method = RequestMethod.GET, value="/customers/all")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<String> studentsAll() throws IOException {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<String>(om.writeValueAsString(model.getAllCustomers()), headers, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/customers/add")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<String> addCustomer(@RequestBody Map<String,String> body) throws JsonMappingException, IOException, ParseException {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        model.addCustomer(body.get("firstName"),body.get("lastName"),body.get("userName"),body.get("email"),body.get("phone"),body.get("password"));
        return new ResponseEntity<String>("done", headers, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/vehicle/add")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<String> addVehicle(@RequestBody Map<String,String> body) throws JsonMappingException, IOException, ParseException {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        model.addVehicle(body.get("make"),body.get("model"),Long.parseLong(body.get("year")),Long.parseLong(body.get("mileage")),body.get("condition"),Long.parseLong(body.get("customerId")));
        return new ResponseEntity<String>("done", headers, HttpStatus.OK);
    }
}
