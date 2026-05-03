//package org.prog.session11;

//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//import io.restassured.response.ValidatableResponse;
//import io.restassured.specification.RequestSpecification;
//import org.hamcrest.Matchers;
//import org.prog.session11.dto.PersonDto;
//import org.prog.session11.dto.ResultsDto;
//import org.prog.session5.poly.Ford;
//import org.testng.Assert;
//import org.testng.annotations.Test;

//TODO: Add location validation with ValidatableResponse AND DTO
//TODO: Check street number and name are not null
//TODO: Check post cod has no letter (only digits)

//public class RestTest {

 //   @Test
 //   public void testRest() {
 //       RequestSpecification requestSpecification = RestAssured.given();
   //     requestSpecification.baseUri("https://randomuser.me/");
     //   requestSpecification.basePath("/api");
       // requestSpecification.queryParam("inc", "gender,name,nat,location");
      //  requestSpecification.queryParam("noinfo");
        //requestSpecification.queryParam("results", 3);

      //  Response response = requestSpecification.get();
        //System.out.println(">>>>> " + response.jsonPath().get("results.gender[0]"));
        //response.body().prettyPrint();
        //ValidatableResponse validatableResponse = response.then();
        //validatableResponse.statusCode(200);
        //validatableResponse.header("Content-Type", "application/json; charset=utf-8");
        //validatableResponse.header("Access-Control-Allow-Origin", "*");
        //validatableResponse.body("results.gender[0]", Matchers.equalTo("female"));
    //}

   // @Test
    //public void testRest2() {
      //  RequestSpecification requestSpecification = RestAssured.given();
       // requestSpecification.baseUri("https://randomuser.me/");
        //requestSpecification.basePath("/api");
        //requestSpecification.queryParam("inc", "gender,name,nat,location");
        //requestSpecification.queryParam("noinfo");
        //requestSpecification.queryParam("results", 3);

       // Response response = requestSpecification.get();
       // response.prettyPrint();
       // ResultsDto resultsDto = response.as(ResultsDto.class);
       // Assert.assertTrue(resultsDto.getResults().size() == 3);
        //Assert.assertTrue(
         //       resultsDto.getResults()
           //             .stream()
             //           .anyMatch(r ->
               //                 r.getGender().equalsIgnoreCase("female")));

     //   RequestSpecification requestSpecification2 = RestAssured.given();
       // requestSpecification2.body(resultsDto);
    //}

    //@Test
    //public void testRest3() {
        //GIVEN
      //  RestAssured.given()
        //        .baseUri("https://randomuser.me/")
         //       .basePath("/api")
         //       .queryParam("inc", "gender,name,nat,location")
         //       .queryParam("noinfo")
         //       .queryParam("results", 3)
          //      .get()
            //    .prettyPeek()
        //VALIDATE



         //       .then()
         //       .statusCode(200)
         //       .contentType(ContentType.JSON)
         //       .body("results.gender[0]", Matchers.equalTo("female"));
 //   }
//}


package org.prog.session11;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.prog.session11.dto.ResultsDto;
import org.prog.session11.dto.StreetDto;
import org.prog.session11.dto.LocationDto;
import org.prog.session11.dto.PersonDto;
import org.prog.session5.poly.Ford;
import org.prog.session11.dto.NameDto;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RestTest {

    @Test
    public void testRest() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://randomuser.me/");
        requestSpecification.basePath("/api");
        requestSpecification.queryParam("inc", "gender,name,nat,location");
        requestSpecification.queryParam("noinfo");
        requestSpecification.queryParam("results", 3);

        Response response = requestSpecification.get();
        System.out.println(">>>>> " + response.jsonPath().get("results.gender[0]"));
        response.body().prettyPrint();

        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(200);
        validatableResponse.header("Content-Type", "application/json; charset=utf-8");
        validatableResponse.header("Access-Control-Allow-Origin", "*");

        validatableResponse.body("results[0].location.street.number", Matchers.notNullValue());
        validatableResponse.body("results[0].location.street.name", Matchers.notNullValue());
        validatableResponse.body("results[0].location.postcode.toString()", Matchers.matchesPattern("\\d+"));
    }

    @Test
    public void testRest2() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://randomuser.me/");
        requestSpecification.basePath("/api");
        requestSpecification.queryParam("inc", "gender,name,nat,location");
        requestSpecification.queryParam("noinfo");
        requestSpecification.queryParam("results", 3);

        Response response = requestSpecification.get();
        response.prettyPrint();

        ResultsDto resultsDto = response.as(ResultsDto.class);

        Assert.assertTrue(resultsDto.getResults().size() == 3);

        Assert.assertNotNull(resultsDto.getResults().get(0).getLocation().getStreet().getNumber());
        Assert.assertNotNull(resultsDto.getResults().get(0).getLocation().getStreet().getName());

        String postcode = resultsDto.getResults().get(0).getLocation().getPostcode();
        Assert.assertTrue(postcode.matches("\\d+"));

        RequestSpecification requestSpecification2 = RestAssured.given();
        requestSpecification2.body(resultsDto);
    }

    @Test
    public void testRest3() {
        RestAssured.given()
                .baseUri("https://randomuser.me/")
                .basePath("/api")
                .queryParam("inc", "gender,name,nat,location")
                .queryParam("noinfo")
                .queryParam("results", 3)
                .get()
                .prettyPeek()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("results[0].location.street.number", Matchers.notNullValue())
                .body("results[0].location.street.name", Matchers.notNullValue())
                .body("results[0].location.postcode.toString()", Matchers.matchesPattern("\\d+"));
    }
}