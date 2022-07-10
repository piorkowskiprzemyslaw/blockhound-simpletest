package com.github.piorkowskiprzemyslaw.blockhound.simpleapp

import reactor.core.scheduler.Schedulers
import spock.lang.Specification

class BlockingUserRepositorySpec extends Specification {


    def "should return specific number of users"() {
        given:
        def repository = new BlockingUserRepository()

        when:
        def users = repository.findUsers().buffer(10).subscribeOn(Schedulers.parallel()).blockFirst()

        then:
        with(users) {
            size() == 10
        }
    }

}
