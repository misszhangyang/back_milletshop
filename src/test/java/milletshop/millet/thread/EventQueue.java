package milletshop.millet.thread;

import java.util.LinkedList;

import static java.lang.Thread.currentThread;

public class EventQueue {

    private final int max;
    private static final int DEFAULT_MAX = 50;

    static class Event{
    }

    private final LinkedList<Event> eventQueue = new LinkedList<>();

    public EventQueue(int max) {
        this.max = max;
    }

    public void offer(Event event){
        synchronized (eventQueue){
            if(eventQueue.size() >= max){
                try{
                    console("the queue is full");
                    eventQueue.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            console(" the new event is submitted");
            eventQueue.addLast(event);
            eventQueue.notify();
        }
    }

    public Event take(){
        synchronized (eventQueue){
            if(eventQueue.isEmpty()){
                try{
                    console("the eventQueue id empty");
                    eventQueue.wait();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            Event event = eventQueue.removeFirst();
            this.eventQueue.notify();
            console("the event " + event + "is handled");
            return event;
        }
    }

    private void console(String message){
        System.out.printf("%s:%s\n",currentThread().getName(),message);
    }
}
