package API_automation;

    import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
    import static io.restassured.path.xml.config.XmlPathConfig.xmlPathConfig;

public class FetchTitleFromXML {

        public static void main(String[] args) {

            RestAssured.baseURI = "https://chercher.tech";
            Response response = given()
                    .when()
                    .get("/sample/api/books.xml")
                    .then()
                    .statusCode(200)
                    .extract()
                    .response();
            XmlPath xmlPath = new XmlPath(response.asString());
            String title = xmlPath.getString("bookstore.book.find { it.@category == 'cooking' }.title");
            System.out.println("Title: " + title);
        }


    }

