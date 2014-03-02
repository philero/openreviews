package controllers;

import mongo.Mongo;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import play.api.templates.Html;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import models.User;

public class MainController extends Controller {
    
    public static Result index() {
        return ok(renderIndex(Form.form(User.class)));
    }

    public static Html renderIndex(Form<User> form){
        Jongo j = Mongo.jongo();
        MongoCollection users = j.getCollection(User.MONGO_COLLECTION);
        Iterable<User> allUsers = users.find().sort("{username: 1}").as(User.class);

        return views.html.index.render(form, allUsers);
    }

}
