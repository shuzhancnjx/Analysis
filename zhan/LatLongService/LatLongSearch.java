package zhan.LatLongService;


import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class LatLongSearch {

    private CloseableHttpClient httpClient = HttpClients.createDefault();

    public void getLatLong(List<String> addresses) throws IOException {

        for(String address : addresses){

            String url = "http://maps.googleapis.com/maps/api/geocode/json?address=" + address + "&sensor=true";
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet);

            try {
                StatusLine statusLine = closeableHttpResponse.getStatusLine();
                if (statusLine.getStatusCode() == 200) {
                    HttpEntity httpEntity = closeableHttpResponse.getEntity();
                    String result = EntityUtils.toString(httpEntity);
                    JSONObject jsonObject = new JSONObject(result);

                    JSONObject jsonObject1 = jsonObject.getJSONArray("results")
                            .getJSONObject(0)
                            .getJSONObject("geometry")
                            .getJSONObject("location");

                    Double lat = jsonObject1.getDouble("lat");
                    Double lng = jsonObject1.getDouble("lng");

                    System.out.println(" inputs.add(Arrays.asList(\"" + address + "\",\"" + lat + "\",\"" + lng + "\"))");

                } else {
                    throw new ClientProtocolException("not successful " + address);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }


    public List<String> readAddresses(String filename){
            String line;
            List<String> result = new ArrayList<>();
            try {
                FileReader fileReader = new FileReader(filename) ;
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                while( (line = bufferedReader.readLine()) != null ){
                    result.add(line.trim().replaceAll("\\s+", "+"));
                }

                bufferedReader.close();

            } catch (FileNotFoundException e){
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return result;
    }


}

