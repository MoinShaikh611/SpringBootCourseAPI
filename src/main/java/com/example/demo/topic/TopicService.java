package com.example.demo.topic;

import org.apache.naming.TransactionRef;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    private List<Topic> topics= new ArrayList<>(Arrays.asList(
            new Topic(1,"Springboot","Spring just run"),
            new Topic(2,"Java","Amazing"),
            new Topic(3,"Python","Superb")
    ));
    public List<Topic> getAllTopic(){
        return topics;
    }

    public Topic getTopic(int id){
        return topics.stream().filter(topic -> topic.getId()==id).findFirst().get();
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }


    public void updateTopic(int id, Topic topic) {
        for (int i = 0; i < topics.size(); i++) {
            Topic t = topics.get(i);
            if (t.getId()==id){
                topics.set(id, topic);
                return;
            }
        }
    }

    public void deleteTopic(int id) {
        topics.removeIf(t -> t.getId()==id);
    }
}

