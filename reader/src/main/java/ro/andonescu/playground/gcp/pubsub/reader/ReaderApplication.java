package ro.andonescu.playground.gcp.pubsub.reader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReaderApplication {

    public static void main(String[] args) throws InterruptedException {

        SpringApplication.run(ReaderApplication.class, args);

        while (true) {

            Thread.sleep(30000); //sleep 30 seconds
        }
    }
}
