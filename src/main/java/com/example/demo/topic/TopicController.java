package com.example.demo.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;
    private Topic topic;


    @RequestMapping("/topic")
    public List<Topic> getAllTopic()
    {
        return topicService.getAllTopic();
    }

    @RequestMapping("/topic/{id}")
    public Topic getTopic(@PathVariable int id){
        return topicService.getTopic(id);
    }

    @RequestMapping(value = "/topic",method = RequestMethod.POST)
    public Topic addTopic(@RequestBody Topic topic) {

        topicService.addTopic(topic);
        return topic;
    }

    @RequestMapping(value="/topic/{id}", method=RequestMethod.PUT)
    public Topic updateTopic(@RequestBody Topic topic,@PathVariable int id){
        topicService.updateTopic(id,topic);
        return topic;
    }

    @RequestMapping(value = "/topic/{id}",method = RequestMethod.DELETE)
    public void deleteTopic(@PathVariable int id){
        topicService.deleteTopic(id);
    }
}
