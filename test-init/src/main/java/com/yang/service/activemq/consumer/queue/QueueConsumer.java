package com.yang.service.activemq.consumer.queue;

import com.yang.constants.ActiveMqName;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

// 点对点的消费者
// 消息只会被其中一个消费者消费
@Service
public class QueueConsumer {

    @JmsListener(destination =  ActiveMqName.QUEUE_ONE, containerFactory = "jmsListenerContainerQueue")
    public void getQueue1(String info) {// Queue queue = session.createQueue(QUEUE_NAME);
        System.out.println("listener1成功监听queue1消息队列，传来的值为:" + info);
    }

    @JmsListener(destination = ActiveMqName.QUEUE_ONE, containerFactory = "jmsListenerContainerQueue")
    public void getQueue2(String info) {
        System.out.println("listener2成功监听queue1消息队列，传来的值为:" + info);
    }

    @JmsListener(destination =  ActiveMqName.QUEUE_TWO, containerFactory = "jmsListenerContainerQueue")
    public void getQueue3(String info) {
        System.out.println("listener3成功监听queue1消息队列，传来的值为:" + info);
    }

}
