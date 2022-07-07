package com.github.piorkowskiprzemyslaw.blockhound.simpleapp;

import reactor.core.publisher.Flux;

public interface UserRepository {
    Flux<User> findUsers();
}
