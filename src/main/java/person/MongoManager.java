package person;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import java.net.UnknownHostException;

public class MongoManager {

    private static MongoManager instance;
    private DB _db;
    private DBCollection _patient_collection;
    private DBCollection _nurse_collection;
    private MongoClient _mongoclient;

    public DBCollection getPatientCollection() {
        return _patient_collection;
    }

    public DBCollection getNurseCollection() {
        return _nurse_collection;
    }

    public MongoManager() {
        String mongo_uri = System.getenv("MONGO_DB_URL");
        System.out.println(mongo_uri);
        _mongoclient = new MongoClient(new MongoClientURI(mongo_uri));
        _db = _mongoclient.getDB("curilab");
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
