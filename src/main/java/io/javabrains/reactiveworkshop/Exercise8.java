package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise8 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()

        // Print values from intNumbersFluxWithException and print a message when error happens
        // TODO: Write code here
//        ReactiveSources.intNumbersFluxWithException()
//                .subscribe(s -> System.out.println(s), err -> System.out.println("Error " + err.getMessage()));

//        ReactiveSources.intNumbersFluxWithException()
//                .doOnError(e -> System.out.println("Error!!! " + e.getMessage()))
//                .subscribe(s -> System.out.println(s));

        // Print values from intNumbersFluxWithException and continue on errors
        // TODO: Write code here
        ReactiveSources.intNumbersFluxWithException()
                .onErrorContinue((e, item) -> System.out.println("Error!!! " + e.getMessage()))
                .subscribe(s -> System.out.println(s));

        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2
        // TODO: Write code here
        ReactiveSources.intNumbersFluxWithException()
                .onErrorResume(e -> Flux.just(-1, -2))
                .subscribe(s -> System.out.println(s));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
