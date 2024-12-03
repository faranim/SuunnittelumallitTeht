package Facade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ApiFacade {

    public String getAttributeValueFromJson(String urlString, String attributeName)
            throws IllegalArgumentException, IOException {
        String jsonResponse = fetchJsonFromApi(urlString);
        return extractAttributeFromJson(jsonResponse, attributeName);
    }
    private String fetchJsonFromApi(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            return response.toString();
        } finally {
            connection.disconnect();
        }
    }
    private String extractAttributeFromJson(String json, String attributeName)
            throws IllegalArgumentException {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(json);
            if (jsonObject.containsKey(attributeName)) {
                return (String) jsonObject.get(attributeName);
            } else {
                throw new IllegalArgumentException("Attribuuttia '" + attributeName + "' ei löytynyt JSON-datasta.");
            }
        } catch (ParseException e) {
            throw new IllegalArgumentException("JSON-datan jäsentäminen epäonnistui: " + e.getMessage());
        }
    }
}
