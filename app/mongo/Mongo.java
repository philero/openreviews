package mongo;

import com.mongodb.DB;
import org.jongo.Jongo;
import play.Play;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;

public class Mongo{

    public static Jongo jongo(){
        // TODO : connect at application startup
	    MongoClientURI mcUri = new MongoClientURI(Play.application().configuration().getString("mongodb.uri"));
        try {
            MongoClient mongoClient = new MongoClient(mcUri);
            DB db = mongoClient.getDB(mcUri.getDatabase());
            return new Jongo(db);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

    }

}
