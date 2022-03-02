package com.nttdata.yankipurse.service;

import com.nttdata.yankipurse.entity.YankiPurse;
import reactor.core.publisher.Mono;

public interface YankiPurseService extends CrudService<YankiPurse, String>{

    Mono<YankiPurse> findByNumberAccount(String numberAccount);
}
