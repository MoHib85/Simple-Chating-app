package com.rest.access;

import com.Entity.User;
import com.services.UserAccessProviderService;
import com.services.UserAccessProviderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by mohibmanva on 09/03/18.
 */

@Path("/access")
@Component
public class AccessRestApi {
    @Autowired
    private UserAccessProviderService userAccessProviderService = new UserAccessProviderServiceImpl();

    @GET
    @Path("/Login")
    @Produces(MediaType.TEXT_PLAIN)
    public String login() {
        return "Success";
    }

    @GET
    @Path("/login")
    @Produces(MediaType.TEXT_PLAIN)
    public String login(@QueryParam("userEmail")String userEmail, @QueryParam("passwordHash")Long passwordHash) {
        boolean valid = userAccessProviderService.validateByUserEmail(userEmail, passwordHash);
        return valid ? "Success" : "Invalid Credentials";
    }

    @GET
    @Path("/register")
    @Produces(MediaType.TEXT_PLAIN)
    public String register(@QueryParam("userEmail") String userEmail, @QueryParam("userName") String userName,
                                                                      @QueryParam("passwordHash") Long passwordHash) {
        User user = new User(userEmail, passwordHash, userName);
        boolean success = userAccessProviderService.registerUser(user);
        return success ? "Registered Successfully!" : "Try Valid Username Or password!";
    }
}
