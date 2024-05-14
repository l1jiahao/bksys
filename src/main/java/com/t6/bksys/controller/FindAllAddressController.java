package com.t6.bksys.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.t6.bksys.entity.Address;
import com.t6.bksys.service.FindAllAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class FindAllAddressController {

    private final FindAllAddressService findAllAddressService;

    @Autowired
    public FindAllAddressController(FindAllAddressService findAllAddressService) {
        this.findAllAddressService = findAllAddressService;
    }

    @GetMapping("/findall")
    public ResponseEntity<String> findAllAddresses() {
        List<Address> addresses = findAllAddressService.findAllAddresses();
        JSONObject responseJson = new JSONObject();
        responseJson.put("code", 1);
        JSONObject messageJson = new JSONObject();
        JSONArray dataArray = new JSONArray();
        for (Address address : addresses) {
            JSONObject addressJson = new JSONObject();
            addressJson.put("address_id", address.getAddress_id());
            addressJson.put("building", address.getBuilding());
            addressJson.put("floor", address.getFloor());
            dataArray.add(addressJson);
        }
        messageJson.put("data", dataArray);
        responseJson.put("message", messageJson);
        return new ResponseEntity<>(responseJson.toJSONString(), HttpStatus.OK);
    }
}
