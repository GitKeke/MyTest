import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Created by keke on 2020/7/17.
 */
public class MongodbTest {
    public static void main(String[] args) {
         MongoClient client=new MongoClient("192.168.184.134");//创建连接
         MongoDatabase spitdb = client.getDatabase("spitdb");//打开数据库
         MongoCollection<Document> spit = spitdb.getCollection("spit");
         FindIterable<Document> documents = spit.find();
         for(Document document:documents){//
             System.out.println("内容："+document.getString("content"));
             System.out.println("用户ID:"+document.getString("userid"));
             System.out.println("浏览量："+document.getInteger("visits"));
         }
         client.close();//关闭连接
    }
}
