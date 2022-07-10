package com.github.piorkowskiprzemyslaw.blockhound.simpleapp;

import org.junit.jupiter.api.Test;
import reactor.core.scheduler.Schedulers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@NonBlocking
class BlockingUserRepositoryTest {

    @Test
    void shouldReturnSpecificNumberOfUsers() {
        // given
        BlockingUserRepository repository = new BlockingUserRepository();

        // when
        List<User> users = repository.findUsers().buffer(10).subscribeOn(Schedulers.parallel()).blockFirst();

        // then
        assertEquals(10, users.size());
    }

}