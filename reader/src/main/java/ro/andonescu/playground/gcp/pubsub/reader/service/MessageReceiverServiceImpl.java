package ro.andonescu.playground.gcp.pubsub.reader.service;

import com.google.cloud.pubsub.v1.AckReplyConsumer;
import com.google.cloud.pubsub.v1.MessageReceiver;
import com.google.common.base.Throwables;
import com.google.pubsub.v1.PubsubMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MessageReceiverServiceImpl implements MessageReceiver {

    public MessageReceiverServiceImpl() {
        LOG.info("#MessageReceiverServiceImpl creation");
    }

    private final Logger LOG = LoggerFactory.getLogger(SubscriberServiceImpl.class);

    @Override
    public void receiveMessage(PubsubMessage message, AckReplyConsumer consumer) {
        LOG.info("Id : " + message.getMessageId() + " w/ data " + message.getData().toStringUtf8());

        // add some delay

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            LOG.error(Throwables.getStackTraceAsString(e));
        }

        consumer.ack();
    }


}
