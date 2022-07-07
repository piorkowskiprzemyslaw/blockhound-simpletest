package com.github.piorkowskiprzemyslaw.blockhound.simpleapp;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

public class NonBlockingUserRepository implements UserRepository {
    @Override
    public Flux<User> findUsers() {
        return Flux.<Integer>generate(sink -> sink.next(Math.abs(ThreadLocalRandom.current().nextInt(100))))
                .map(age -> new User("random " + age, age))
                .delayElements(Duration.ofMillis(150));
    }
}
