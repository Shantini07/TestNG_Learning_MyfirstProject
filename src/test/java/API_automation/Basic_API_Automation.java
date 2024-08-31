package API_automation;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.devtools.v124.fetch.model.AuthChallengeResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Basic_API_Automation {


    @Test
    public void RestAssured_API_Testing() {
        try {

            RestAssured.baseURI = "https://rest-assured.io/";
            Response res = RestAssured.get();
            int statusCode = res.getStatusCode();
            String response = res.getBody().asString();
            Assert.assertEquals(statusCode, 200);
            System.out.println("The status code is " + statusCode);
            System.out.println("The response is " + response);


        } catch (Exception e) {
        }
    }

        @Test
        public void Google_API_Testing () {
            try {

                RestAssured.baseURI = "https://www.google.co.in/";
                Response res = RestAssured.get();
                int statusCode = res.getStatusCode();
                String response = res.getBody().asString();
                Assert.assertEquals(statusCode, 200);
                System.out.println("The status code is " + statusCode);
                System.out.println("The response is " + response);


            } catch (Exception e) {
            }

        }
    }

