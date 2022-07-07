package com.github.piorkowskiprzemyslaw.blockhound.simpleapp;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import reactor.core.scheduler.Schedulers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Tag("BH")
class NonBlockingUserRepositoryTest {

    @Test
    void shouldReturnSpecificNumberOfUsers() {
        // given
        NonBlockingUserRepository repository = new NonBlockingUserRepository();

        // when
        List<User> users = repository.findUsers().buffer(10).subscribeOn(Schedulers.parallel()).blockFirst();

        // then
        assertEquals(10, users.size());
    }

}