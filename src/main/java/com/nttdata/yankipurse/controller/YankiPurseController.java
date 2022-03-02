package com.nttdata.yankipurse.controller;

import com.nttdata.yankipurse.entity.YankiPurse;
import com.nttdata.yankipurse.service.YankiPurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/purse")
public class YankiPurseController {

    @Autowired
    YankiPurseService yankiPurseService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<YankiPurse> getYankiPurse(){
        System.out.println("Listar cuentas de Yanki Purse");
        return yankiPurseService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<YankiPurse> saveYankiPurse(@RequestBody YankiPurse yankiPurse){
        System.out.println("Guardar Yanki Purse");
        return yankiPurseService.save(yankiPurse);
    }

    @GetMapping("/number/{numberAccount}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<YankiPurse> getYankiPurseByNumberAccount(@PathVariable String numberAccount){
        System.out.println("Buscar cuenta de Yanki Purse por número de cuenta");
        return yankiPurseService.findByNumberAccount(numberAccount);
    }
}
