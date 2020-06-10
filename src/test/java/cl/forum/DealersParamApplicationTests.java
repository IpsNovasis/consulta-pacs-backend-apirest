package cl.forum;

import static io.restassured.RestAssured.given;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.http.ContentType;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DealersParamApplicationTests {

	@org.junit.Test
    public void testGetUF() {
		given().pathParams("dealerDocumentNumber", "84807200","dateTo", "2100-12-31 23:59:59","pageNumber", "1","maxRows", "10").
        get("http://localhost:8406/api/dealer_parametrics/v1/?dateTo={dateTo}&dealerDocumentNumber={dealerDocumentNumber}&maxRows={maxRows}&pageNumber={pageNumber}").then()
		 .assertThat().statusCode(200).
        	and().
        		contentType(ContentType.JSON);

	} 

}
