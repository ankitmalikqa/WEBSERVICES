package com.qait.WebServices;
import static io.restassured.RestAssured.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;

import java.net.HttpURLConnection;
import java.net.URL;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;
public class BoardTest {

	@BeforeTest
	public void init()
	{
	Response r;	
	}
	@Test
	public void check_if_there_are_4_players()
	{
		
	    when().get("http://10.0.1.86/snl/rest/v1/board/5050.json").then().assertThat().body("response.board.players.id",hasSize(4));
	}
	@Test
	public void check_status_code()
	{
		try{
			  URL url = new URL("http://10.0.1.86/snl/rest/v1/board/4164.json");
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            conn.setRequestMethod("GET");
	            conn.setRequestProperty("Accept", "application/json");
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        assertThat(conn.getResponseCode()).isEqualTo(200);
		}
	catch(Exception e)
		{
		e.printStackTrace();
		}		
	}
	@Test
	public void check_for_delete_player()
	{
		when().delete("http://10.0.1.86/snl/rest/v1/player/1272.json").then().assertThat().statusCode(200);;
		//because id=1272 is in 5074.json
		when().get("http://10.0.1.86/snl/rest/v1/board/5074.json").then().assertThat().body("response.board.players.id",hasSize(1));
	}
}
