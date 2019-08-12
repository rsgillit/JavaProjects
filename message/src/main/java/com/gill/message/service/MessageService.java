package com.gill.message.service;

import com.gill.message.database.DatabaseClass;
import com.gill.message.exception.DataNotFoundException;
import com.gill.message.model.ErrorMessage;
import com.gill.message.model.Message;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;


public class MessageService {

    private static Map<Long, Message> messages = DatabaseClass.getMessages();

    public MessageService(){
        messages.put(1L, new Message(1, "Hello Service", "Rashpal"));
        messages.put(2L, new Message(2, "Hello Service", "Singh"));

    }

    public List<Message> getAllMessages(){
        return new ArrayList<Message>(messages.values());
    }

    public List<Message> getAllMessagesForYear(int year){
        List<Message> messagesForYear = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        for(Message message : messages.values()){
            cal.setTime(message.getCreated());
            if(cal.get(Calendar.YEAR) == year){
                messagesForYear.add(message);
            }
        }
        return messagesForYear;
    }

    public List<Message> getAllMessagesPaginated(int start, int size){
        ArrayList<Message> list = new ArrayList<>(messages.values());
        return list.subList(start, start + size);
    }

    public Message getMessage(Long id){
        Message message = messages.get(id);
        if(message == null ){
            ErrorMessage errorMessage = new ErrorMessage("Not Found", 404,"htttp://google.com");
            Response response = Response.status(Response.Status.NOT_FOUND)
                    .entity(errorMessage)
                    .build();
            throw new WebApplicationException(response);
        }
        return message;
    }
    public Message addMessage(Message message){
        message.setId(messages.size()+1);
        messages.put(message.getId(), message);
        return message;
    }

    public Message updateMessage(Message message){
        if(message.getId() <= 0  ){
            return null;
        }

        messages.put(message.getId(), message);
        return message;
    }

    public Message removeMessage(long id){
        return messages.remove(id);
    }
}

