package se.david.labs.akka;

import akka.actor.AbstractActor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class GreetingActor extends AbstractActor {
    @Autowired
    private GreetingService greetingService;

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Greet.class, greet -> {
                    getSender().tell(greetingService.greet(greet.getName()), getSelf());
                })
                .build();
    }

    public static class Greet {
        private String name;

        String getName() {
            return name;
        }
    }
}