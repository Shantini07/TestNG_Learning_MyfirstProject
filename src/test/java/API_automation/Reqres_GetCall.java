package API_automation;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.path.xml.config.XmlPathConfig.xmlPathConfig;

public class Reqres_GetCall {

    @Test
    public static void rest_A() {

        RestAssured.baseURI = "https://reqres.in/api/users?page=2";
        Response res = RestAssured.get();
        int ststua_Code = res.getStatusCode();
        String resBody = res.getBody().asString();
        System.out.println(resBody);
    }

    @Test
    public void E2E_Testing1() {
        Response response = given()
                .when()
                .get("https://reqres.in/api/users?page=2");
        String page = response.getBody().jsonPath().getString("page");
        System.out.println("Page number is ==>" + page);
    }


    // Base URI
    @Test
    public void E2E_Testing2() {
        Response response = given()
                .when()
                .get("https://reqres.in/api/users?page=2");
        String page = response.getBody().jsonPath().getString("page");
        System.out.println("Page number is ==>" + page);
        int totalEmail = response.getBody().jsonPath().getList("data.email").size();
        System.out.println("totalEmail Count is ==>" + totalEmail);
        for (int a = 0; a < totalEmail; a++) {
            String emailid = response.getBody().jsonPath().getString("data.email[" + a + "]");
//            String sizee = response.getBody().jsonPath().getString("data.size["+a+"]");
            System.out.printf("Email ID is ===>" + emailid);
//            System.out.printf("Size is ===>"+sizee);
        }
    }

    @Test
    public void chercher_Tech_SOAP_2() {
        Response res1 = given()
                .relaxedHTTPSValidation().when().get("https://chercher.tech/sample/api/books.xml");
        System.out.println("The response is ==>" + res1);
        XmlPath xml_path_obj = new XmlPath(res1.getBody().asString()).using(xmlPathConfig().namespaceAware(false));
        String title0 = xml_path_obj.getString("bookstore.book[0].title");
        System.out.println("The title is ==>" + title0);
    }
    @Test
    public void validateWithContains_SOAP_2() {
        Response response = given()
                .relaxedHTTPSValidation().when().get("https://chercher.tech/sample/api/books.xml");
        String res = response.getBody().asString();
        XmlPath xml_path_obj = new XmlPath(res).using(xmlPathConfig().namespaceAware(false));
// First get the count of node you want to test ...
        int xmlPathcount = xml_path_obj.get("bookstore.book.title.size()");
        System.out.println("Count is ==>" + xmlPathcount);
        for (int a = 0; a < xmlPathcount; a++) {
            String title = xml_path_obj.getString("bookstore.book[" + a + "].title");
            if (title.equals("Harry Potter")) {
                System.out.println("Yes , the expected text is available==>" + "Harry Potter");
                break;
            }
        }

    }
}






