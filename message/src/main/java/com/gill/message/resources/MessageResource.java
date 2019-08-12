package com.gill.message.resources;

import com.gill.message.model.Message;
import com.gill.message.resources.beans.MessageFilterBean;
import com.gill.message.service.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Path("/messages")
public class MessageResource {

    MessageService messageService = new MessageService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getMessages(@BeanParam MessageFilterBean filterBean){
        if(filterBean.getYear() >0){
            return messageService.getAllMessagesForYear(filterBean.getYear());
        } else if (filterBean.getStart() >0 & filterBean.getSize()>0){
            return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
        }
        else{
            return messageService.getAllMessages();
        }

    }

    @Path("/{messageId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessage(@PathParam("messageId") long messageId){
        return messageService.getMessage(messageId);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMessage(Message message, @Context UriInfo uriInfo) throws URISyntaxException {

        Message newMessage = messageService.addMessage(message);
        return Response.created(new URI("/messenger/webapi/messages/" + newMessage.getId()))
                .entity(newMessage)
                .build();
//        return messageService.addMessage(message);
    }

    @PUT
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Message updateMessage(@PathParam("messageId") long messageId,Message message){
        message.setId(messageId);
        return messageService.updateMessage(message);
    }

    @DELETE
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message deleteMessage(@PathParam("messageId") long messageId){
        return messageService.removeMessage(messageId);
    }

    @Path("/{messageId}/comments")
    public CommentResource getCommentResource(){
        return new CommentResource();
    }
}
