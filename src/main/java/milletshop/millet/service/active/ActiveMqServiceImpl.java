//package milletshop.millet.service.active;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.annotation.JmsListener;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.stereotype.Service;
//
////@Service
//public class ActiveMqServiceImpl implements ActiveMqService {
//
//    @Autowired
//    private JmsTemplate jmsTemplate;
//
//    @Override
//    public void sendMsg(String msg) {
//        System.out.println("发送消息：" + msg);
//        jmsTemplate.convertAndSend(msg);
//        //自定义发送地址
//        jmsTemplate.convertAndSend("spring.jms.template.default-destination",msg);
//    }
//
//    @Override
//    @JmsListener(destination = "${spring.jms.template.default-destination}")
//
//    public void receiveMsg(String msg) {
//        System.out.println("监听器1接受到消息：" + msg);
//    }
//
//
//    @JmsListener(destination = "${spring.jms.template.default-destination}")
//    public void receiveMsg1(String msg) {
//        System.out.println("监听器2接受到消息：" + msg);
//    }
//
//}
