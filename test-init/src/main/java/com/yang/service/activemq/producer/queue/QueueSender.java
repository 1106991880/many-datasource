package com.yang.service.activemq.producer.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.*;

@Service
public class QueueSender {

    @Autowired
    @Qualifier("jmsQueueTemplate")
    private JmsTemplate jmsTemplate;

    public void send(String queueName, String message) {
        jmsTemplate.send(queueName, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                // 获得队列
                Queue queue = session.createQueue(queueName);
                // 获得生产者
                MessageProducer messageProducer = session.createProducer(queue);
                // 设置持久化的方式
                messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);
                TextMessage textMessage = session.createTextMessage(message);
                return textMessage;
            }
        });
    }

}
