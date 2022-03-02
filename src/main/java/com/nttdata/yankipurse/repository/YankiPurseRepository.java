package com.nttdata.yankipurse.repository;

import com.nttdata.yankipurse.entity.YankiPurse;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface YankiPurseRepository extends ReactiveMongoRepository<YankiPurse, String> {

    Mono<YankiPurse> findByNumberAccount(String numberAccount);
}
