package com.github.piorkowskiprzemyslaw.blockhound.simpleapp;

import com.github.piorkowskiprzemyslaw.blockhound.simpleapp.test.annotations.NonBlocking;
import org.junit.jupiter.api.Test;
import reactor.core.scheduler.Schedulers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@NonBlocking
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