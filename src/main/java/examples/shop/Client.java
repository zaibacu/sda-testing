package examples.shop;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.*;


public class Client {
    private final String url;
    private CloseableHttpClient httpClient = HttpClients.createDefault();

    public Client(String url){
        this.url = url;
    }

    public List<Item> getItems(){
        try{
            HttpGet request = new HttpGet(String.format("%s/items", this.url));
            HttpResponse response = httpClient.execute(request);
            String rawResponse = EntityUtils.toString(response.getEntity());

            List<Item> result = new ArrayList<>();

            String[] lines = rawResponse.split("\n");
            for(String line : lines){
                result.add(new Item(line));
            }

            return result;
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
            return Collections.emptyList();
        }
    }

    public boolean buyRequest(int id, float money){
        try{
            HttpPost request = new HttpPost(String.format("%s/buy", this.url));

            List<NameValuePair> params = new ArrayList<>(2);
            params.add(new BasicNameValuePair("item", new Integer(id).toString()));
            params.add(new BasicNameValuePair("money", new Float(money).toString()));
            request.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

            HttpResponse response = httpClient.execute(request);
            String rawResponse = EntityUtils.toString(response.getEntity());
            System.out.println(rawResponse);
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
            return false;
        }

        return true;
    }

}
