package com.corso.java.tourismagency.controller;

import com.corso.java.tourismagency.domain.Cliente;
import com.corso.java.tourismagency.domain.Spettacolo;
import com.corso.java.tourismagency.service.ClienteService;
import com.corso.java.tourismagency.service.SpettacoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/spettacolo")
public class SpettacoloController {

    @Autowired
    SpettacoloService spettacoloService;

    @GetMapping("spettacoli")
    public ResponseEntity<List<Spettacolo>> findAllShows() {

        return new ResponseEntity<List<Spettacolo>>(
                spettacoloService.findAllShows(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Spettacolo> getShowById(@PathVariable("id") String id) {
        return new ResponseEntity(spettacoloService.findShowById(id), HttpStatus.OK);
    }

    @PostMapping("spettacolo")
    public ResponseEntity<Spettacolo> addSpettacolo(@RequestBody Spettacolo spettacolo) {
        Spettacolo saveSpettacolo = spettacoloService.addShow(spettacolo);
        return new ResponseEntity(saveSpettacolo, HttpStatus.CREATED);
    }
}

