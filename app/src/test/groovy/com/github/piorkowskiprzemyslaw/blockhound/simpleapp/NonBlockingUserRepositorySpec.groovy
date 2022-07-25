package com.github.piorkowskiprzemyslaw.blockhound.simpleapp

import reactor.core.scheduler.Schedulers
import spock.lang.Specification
import spock.lang.Tag

@Tag("BH")
class NonBlockingUserRepositorySpec extends Specification {

    def "should return specific number of users"() {
        given:
        def repository = new NonBlockingUserRepository()

        when:
        def users = repository.findUsers().buffer(10).subscribeOn(Schedulers.parallel()).blockFirst()

        then:
        with(users) {
            size() == 10
        }
    }

}
