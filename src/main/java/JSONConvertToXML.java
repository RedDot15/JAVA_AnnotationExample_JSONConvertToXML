import connection.URLGetRequest;
import entity.Address;
import entity.Company;
import entity.User;
import helper.ObjectToXmlHelper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JSONConvertToXML {

    private static final String USER_AGENT = "Mozilla/5.0";

    private static final String GET_URL = "https://jsonplaceholder.typicode.com/users";

    public static void main(String[] args) throws IOException, InterruptedException {
        sendGETSize();
    }

    private static void sendGETSize() throws IOException{
        List<User> userList = new ArrayList<>();

        Object obj = URLGetRequest.getJSON(GET_URL,USER_AGENT);
        JSONArray jsonArray = (JSONArray) obj;

        for (Object object : jsonArray) {
            JSONObject jsonObject = (JSONObject) object;
            userList.add(new User((Long) jsonObject.get("id"), (String) jsonObject.get("name"), (String) jsonObject.get("username"),
                    (String) jsonObject.get("email"), (JSONObject) jsonObject.get("address"), (String) jsonObject.get("phone"),
                    (String) jsonObject.get("website"), (JSONObject) jsonObject.get("company")));
        }

        for(User user : userList){
            System.out.println(ObjectToXmlHelper.convertToXml(user));
        }
    }

}
