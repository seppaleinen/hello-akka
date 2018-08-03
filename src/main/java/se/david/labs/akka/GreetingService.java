package se.david.labs.akka;

import org.springframework.stereotype.Component;

@Component
class GreetingService {
    String greet(String name) {
        return String.format("Hello, %s", name);
    }
}
