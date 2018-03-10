package com.rest.chat;

import com.services.UserMessagingService;
import com.services.UserMessagingServiceImpl;

import javax.print.attribute.standard.Media;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Created by mohibmanva on 10/03/18.
 */
@Path("/chat")
public class MessagingRestApi {

    UserMessagingService userMessagingService = new UserMessagingServiceImpl();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/SendMessage")
    public String sendMessage(@QueryParam("userId") Long userId, @QueryParam("message") String message) {

        return "success";
    }
}
