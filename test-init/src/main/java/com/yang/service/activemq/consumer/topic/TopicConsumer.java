package com.yang.service.activemq.consumer.topic;

import com.yang.constants.ActiveMqName;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

// 发布订阅的消费者
// 消息会被多个消费者消费
@Service
public class TopicConsumer {

    @JmsListener(destination = ActiveMqName.TOPIC_ONE, containerFactory = "jmsListenerContainerTopic")
    public void getTopic1(String info) {
        System.out.println("topicListener1成功监听topic1消息队列，传来的值为:" + info);
    }

    @JmsListener(destination = ActiveMqName.TOPIC_ONE, containerFactory = "jmsListenerContainerTopic")
    public void getTopic2(String info) {
        System.out.println("topicListener2成功监听topic1消息队列，传来的值为:" + info);
    }

}
