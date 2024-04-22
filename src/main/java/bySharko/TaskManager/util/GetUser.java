package bySharko.TaskManager.util;

import bySharko.TaskManager.security.PersonDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class GetUser {
    public int getUserID(Authentication authentication){
        int userId;
        authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails=(PersonDetails) authentication.getPrincipal();
        return userId = personDetails.getPerson().getId();
    }


}
