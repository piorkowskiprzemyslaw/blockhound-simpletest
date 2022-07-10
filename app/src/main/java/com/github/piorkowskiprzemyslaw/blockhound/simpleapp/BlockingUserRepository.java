package com.github.piorkowskiprzemyslaw.blockhound.simpleapp;

import reactor.core.publisher.Flux;

import java.util.concurrent.ThreadLocalRandom;

public class BlockingUserRepository implements UserRepository {

    @Override
    public Flux<User> findUsers() {
        return Flux.<Integer>generate(sink -> sink.next(Math.abs(ThreadLocalRandom.current().nextInt(100))))
                .map(age -> {
                    try {
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return new User("random " + age, age);
                });
    }
}
