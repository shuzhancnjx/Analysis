import org.json.JSONObject;
import zhan.KeyStrokeAnalysisTry.KeyStrokeAnalysis;
import zhan.LatLongService.LatLongSearch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args){
//
//        LatLongSearch latLongSearch = new LatLongSearch();
//        List<String> addresses = latLongSearch.readAddresses("/Users/zshu/desktop/dma.txt");
//
//        try{
//            latLongSearch.getLatLong(addresses);
//        } catch (IOException e){
//            e.printStackTrace();
//        }



        KeyStrokeAnalysis keyStrokeAnalysis = new KeyStrokeAnalysis("/Users/zshu/Desktop/log/log.txt");



        try{
            keyStrokeAnalysis.fileReading("/Users/zshu/Desktop/log/Top1000.csv");
            //keyStrokeAnalysis.fileReading("/Users/zshu/Desktop/log/log.txt");
//            keyStrokeAnalysis.analyzeKeyStroke();
        } catch (IOException e){
            e.printStackTrace();
        }
    }


}
