import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

class MessageHandler {

    private String startAnswer = "ZDarova ot Vitalika";

    private String startseccsessful = "Vasya Privet";
    private String noAnswer = "I can't understand you. Hello!";

    private String helpAnswer = "/reg - зарегистрироваться\n/rteacher - зарегистрироваться преподавателем\n" +
            "/lesson - текущая пара\n/today - расписание на сегодня\n";


    MessageHandler(){

    }

    String textToText(String message) throws IOException {
        
        if (message.toUpperCase().contentEquals("/START")) {

            return startAnswer;
        }
        if (message.toUpperCase().contentEquals("/STARTED"))
            return startseccsessful;
        

        if (message.toLowerCase().equals("hello!")) {
            return "Good morning!!!";
        }

        if (message.toUpperCase().contentEquals("/HELP")) {
            return helpAnswer;
        }

        if (message.toUpperCase().contains("/FIND"))
        {
            int i = message.toUpperCase().indexOf("/FIND");

            String group = new String();
            if (message.length() > 6)
            group = message.substring(i + 6);

            return weekSchedule(group);
        }


        return noAnswer;
    }

    String weekSchedule (String group) throws IOException {
        URL url = new URL("http://api.rozklad.hub.kpi.ua/groups");
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("search", group);
        Map<String, String> parameters = new HashMap<>();
        parameters.put("search", group);
        con.setDoOutput(true);

        String str = new String();
        int responseCode = con.getResponseCode();
        str += ("GET Response Code :: " + responseCode) + "\n";
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            str += (response.toString());
        } else {
            str+= ("GET request not worked");
        }
        return str;
    }


}
