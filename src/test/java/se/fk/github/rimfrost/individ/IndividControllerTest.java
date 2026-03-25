package se.fk.github.rimfrost.individ;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.UUID;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import se.fk.rimfrost.api.individ.jaxrsspec.controllers.generatedsource.model.GetIndividResponse;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
class IndividControllerTest
{
   private static final ObjectMapper mapper = new ObjectMapper();

   @Test
   void testIndividController() throws JsonProcessingException
   {
      var expectedResponse = new GetIndividResponse();
      expectedResponse.setId(UUID.fromString("a60a67d6-cfb6-41ad-9718-49e2f9e6b9ba"));
      expectedResponse.setTyp("Pnr");
      expectedResponse.setVarde("19900101-1234");

      String actualResponse = given()
            .when().get("/individ/a60a67d6-cfb6-41ad-9718-49e2f9e6b9ba")
            .then()
            .statusCode(200)
            .extract()
            .body()
            .asString();

      var response = mapper.readValue(actualResponse, GetIndividResponse.class);
      assertEquals(expectedResponse, response);
   }

   @Test
   void testIndividWithDifferentId() throws JsonProcessingException
   {
      var expectedResponse = new GetIndividResponse();
      expectedResponse.setId(UUID.fromString("235520e4-8715-43ad-b902-fa684cf63a18"));
      expectedResponse.setTyp("Pnr");
      expectedResponse.setVarde("19900101-1234");

      String actualResponse = given()
            .when().get("/individ/235520e4-8715-43ad-b902-fa684cf63a18")
            .then()
            .statusCode(200)
            .extract()
            .body()
            .asString();

      var response = mapper.readValue(actualResponse, GetIndividResponse.class);
      assertEquals(expectedResponse, response);
   }

   @Test
   void testIndividWithSsnInId() throws JsonProcessingException
   {
      var expectedResponse = new GetIndividResponse();
      expectedResponse.setId(UUID.fromString("00000000-0000-0000-0000-199001019999"));
      expectedResponse.setTyp("Pnr");
      expectedResponse.setVarde("19900101-9999");

      String actualResponse = given()
            .when().get("/individ/00000000-0000-0000-0000-199001019999")
            .then()
            .statusCode(200)
            .extract()
            .body()
            .asString();

      var response = mapper.readValue(actualResponse, GetIndividResponse.class);
      assertEquals(expectedResponse, response);
   }

   @Test
   void testIndividWithSsnInIdButWrongPrefix() throws JsonProcessingException
   {
      var expectedResponse = new GetIndividResponse();
      expectedResponse.setId(UUID.fromString("01000000-0000-0000-0000-199001019999"));
      expectedResponse.setTyp("Pnr");
      expectedResponse.setVarde("19900101-1234");

      String actualResponse = given()
            .when().get("/individ/01000000-0000-0000-0000-199001019999")
            .then()
            .statusCode(200)
            .extract()
            .body()
            .asString();

      var response = mapper.readValue(actualResponse, GetIndividResponse.class);
      assertEquals(expectedResponse, response);
   }
}
