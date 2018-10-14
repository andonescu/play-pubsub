package ro.andonescu.playground.gcp.pubsub.reader.service;

import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.cloud.pubsub.v1.MessageReceiver;
import com.google.cloud.pubsub.v1.Subscriber;
import com.google.pubsub.v1.ProjectSubscriptionName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;

@Service
public class SubscriberServiceImpl {

    private Subscriber subscriber = null;

    @Autowired
    public SubscriberServiceImpl(MessageReceiver messageReceiver) {

        ProjectSubscriptionName subscriptionName = ProjectSubscriptionName.of("andonescu", "quota");

        ExecutorProvider executorProvider =
                InstantiatingExecutorProvider.newBuilder().setExecutorThreadCount(1).build();

        // create subscriber
        subscriber = Subscriber.newBuilder(subscriptionName, messageReceiver).setExecutorProvider(executorProvider).build();
        subscriber.startAsync();

    }

    @PreDestroy
    public void onClose() {
        if (subscriber != null) {
            subscriber.stopAsync();
        }
    }

}
