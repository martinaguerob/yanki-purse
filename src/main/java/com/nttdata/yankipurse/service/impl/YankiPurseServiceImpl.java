package com.nttdata.yankipurse.service.impl;

import com.nttdata.yankipurse.entity.YankiPurse;
import com.nttdata.yankipurse.repository.YankiPurseRepository;
import com.nttdata.yankipurse.service.YankiPurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
public class YankiPurseServiceImpl implements YankiPurseService {

    @Autowired
    YankiPurseRepository yankiPurseRepository;

    @Override
    public Flux<YankiPurse> findAll() {
        return yankiPurseRepository.findAll();
    }

    @Override
    public Mono<YankiPurse> save(YankiPurse entity) {
        entity.setStatus(true);
        entity.setCreatedAt(new Date());
        return yankiPurseRepository.save(entity);
    }

    @Override
    public Mono<YankiPurse> update(YankiPurse entity, String id) {
        return yankiPurseRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NO_CONTENT)))
                .flatMap(origin ->
                {
                    origin.setBalance(entity.getBalance()==null ? origin.getBalance() : entity.getBalance());
                    origin.setNumberAccount(entity.getNumberAccount()==null ? origin.getNumberAccount() : entity.getNumberAccount());
                    return yankiPurseRepository.save(origin);
                });
    }

    @Override
    public Mono<YankiPurse> deleteById(String id) {
        return yankiPurseRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NO_CONTENT)))
                .flatMap(yp -> {
                    yp.setStatus(false);
                    return yankiPurseRepository.save(yp);
                });
    }

    @Override
    public Mono<YankiPurse> findByNumberAccount(String numberAccount) {
        return yankiPurseRepository.findByNumberAccount(numberAccount);
    }
}
