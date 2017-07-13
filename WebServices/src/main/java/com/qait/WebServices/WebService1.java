package com.qait.WebServices;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.Iterator;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class WebService1 {
	 public static void main(String[] args) throws JSONException, ParseException {
	        String output = "";
	        try {

	            URL url = new URL("http://10.0.1.86/snl/rest/v1/board/boardAnkit.json");
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            conn.setRequestMethod("GET");
	            conn.setRequestProperty("Accept", "application/json");

	            if (conn.getResponseCode() != 200) {

	                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
	            }

	            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
	            System.out.println("Output from Server .... \n");
	            while ((output = br.readLine()) != null) {
	                System.out.println(output);
	            }
	        }
	        catch(Exception e)
	        {
	        	e.printStackTrace();
	        }

	 }
	 }
