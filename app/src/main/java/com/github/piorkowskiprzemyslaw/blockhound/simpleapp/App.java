/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.github.piorkowskiprzemyslaw.blockhound.simpleapp;

public class App {

    public static void main(String[] args) {
        var t0 = System.currentTimeMillis();
        new NonBlockingUserRepository().findUsers()
                .take(10)
                .doOnNext(user -> System.out.println((System.currentTimeMillis() - t0) + " got user " + user))
                .blockLast();

    }
}
