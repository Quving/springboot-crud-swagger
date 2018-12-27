package person;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoManager {

    private static MongoManager instance;
    private final MongoDatabase _db;
    private final MongoCollection _patient_collection;
    private final MongoCollection _nurse_collection;
    private final MongoClient _mongoclient;

    public MongoCollection getPatientCollection() {
        return _patient_collection;
    }

    public MongoCollection getNurseCollection() {
        return _nurse_collection;
    }

    public MongoManager() {
        String mongo_uri = System.getenv("MONGO_DB_URL");
        System.out.println(mongo_uri);
        _mongoclient = new MongoClient(new MongoClientURI(mongo_uri));
        _db = _mongoclient.getDatabase("curilab");
        _patient_collection = _db.getCollection("patients");
        _nurse_collection = _db.getCollection("nurses");
    }


    public static MongoManager getInstance() {
        if (MongoManager.instance == null) {
            MongoManager.instance = new MongoManager();
        }
        return MongoManager.instance;
    }
}
