//package API_automation;
//
//import io.restassured.path.xml.XmlPath;
//import io.restassured.response.Response;
//import org.testng.annotations.Test;
//
//import static io.restassured.RestAssured.given;
//import static io.restassured.path.xml.config.XmlPathConfig.xmlPathConfig;
//
//public class Chercher_Tech_API {
//
//    @Test
//    public void validateWithContains_SOAP_2(){
//        Response response= given()
//                .relaxedHTTPSValidation().when().get("https://chercher.tech/sample/api/books.xml");
//        String res = response.getBody().asString();
//        XmlPath xml_path_obj = new XmlPath(res).using(xmlPathConfig().namespaceAware(false));
//// First get the count of node you want to test ...
//        int xmlPathcount = xml_path_obj.get("bookstore.book.title.size()");
//        System.out.println("Count is ==>"+xmlPathcount);
//        for(int a=0;a<xmlPathcount;a++){
//            String title = xml_path_obj.getString("bookstore.book["+a+"].title");
//            if(title.equals("Harry Potter")){
//                System.out.println("Yes , the expected text is available==>"+"Harry Potter");
//                break;
//            }
//        }
//    }
//}
