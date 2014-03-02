package models;

import javax.validation.*;

import org.bson.types.ObjectId;
import play.data.validation.Constraints.*;

public class User {

    public final static String MONGO_COLLECTION = "users";

    private ObjectId _id;
   
    @Required
    @MinLength(value = 4)
    public String username;
    
    @Required
    @Email
    public String email;
    
    @Required
    @MinLength(value = 6)
    public String password;

    public User() {}
    
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
    
}
