package milletshop.millet.service.active;

public interface ActiveMqService {
    public void sendMsg(String msg);
    public void receiveMsg(String msg);
}
