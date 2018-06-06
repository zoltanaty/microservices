package com.ubb.cs.microservices.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;

import com.ubb.cs.microservices.repository.SzallitmanyRepository;
import com.ubb.cs.microservices.repository.model.Szallitmany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class SzallitmanyController {
    @Autowired
    SzallitmanyRepository szRep;

    @GetMapping(path="szallitmany")
    public List<Szallitmany> getAll() {
        return szRep.findAll();
    }

    @GetMapping(path="api/v1/szallitmany")
    public String getAllV1() {
        return "Udv Kolozsvarrol";
    }

    @GetMapping(path="api/v2/szallitmany")
    public String getAllV2() {
        return "Udv Csikbol";
    }

    @GetMapping(path="api/szallitmany", params = "version=1")
    public String getAllP1() {
        return "Udv Kolozsvarrol with param";
    }

    @GetMapping(path="api/szallitmany", params = "version=2")
    public String getAllP2() {
        return "Udv Csikbol with param";
    }

    @GetMapping(path="api/szallitmany", headers = "x-api-version=1")
    public String getAllH1() {
        return "Udv Kolozsvarrol with header";
    }

    @GetMapping(path="api/szallitmany", headers = "x-api-version=2")
    public String getAllH2() {
        return "Udv Csikbol with header";
    }

}