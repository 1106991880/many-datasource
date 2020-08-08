package com.yang.controller;

import com.yang.constants.ActiveMqName;
import com.yang.service.activemq.producer.Sender;
import com.yang.service.activemq.producer.queue.QueueSender;
import com.yang.service.activemq.producer.topic.TopicSender;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jms.Destination;

/**
 * @Author: yang
 * @Date: 2020-06-21 10:54
 * @Description: 测试发送消息 点对点和发布订阅两种模式
 */
@Controller
@RequestMapping("activemq")
public class ActivemqController {

    @Autowired
    private Sender sender;

    @Autowired
    private QueueSender queueSender;

    @Autowired
    private TopicSender topicSender;

    // 点对点的方式发送消息
    @RequestMapping(value = "/add/queue")
    public String addQueue(@RequestBody String json) {
        Destination destination = new ActiveMQQueue(ActiveMqName.QUEUE_ONE);
        sender.sendTemplate(destination, "queue_success");
        return json;
    }

    // 发布订阅的方式发送消息
    @RequestMapping(value = "/add/topic")
    public String addTopic(@RequestBody String json) {
        Destination destination = new ActiveMQTopic(ActiveMqName.TOPIC_ONE);
        sender.sendTemplate(destination, "topic_success");
        return json;
    }

    // 点对点的方式发送消息 使用JmsTemplate
    @RequestMapping(value = "/create/queue")
    public String createQueue(@RequestBody String json) {
        queueSender.send(ActiveMqName.QUEUE_ONE, "queue_success");
        return json;
    }

    // 发布订阅的方式发送消息 使用JmsTemplate
    @RequestMapping(value = "/create/topic")
    public String createTopic(@RequestBody String json) {
        topicSender.send(ActiveMqName.TOPIC_ONE, "topic_success");
        return json;
    }


}
