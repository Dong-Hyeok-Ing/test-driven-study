package com.example.testdrivenstudy.product;

import com.example.testdrivenstudy.ApiTest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/*
변수에 final 키워드 변경이 필요 없는 변수를 불변으로 만듬
변수의 값이 변경되는 오류를 방지하는 차원에서 값이 변경되지 않는 모든 변수를 불변으로 만듭니다.
무분별하게 setter를 만들지 않는것과 비슷.!
단축키 select refactoring F6
*/

class ProductApiTest extends ApiTest {


    @Test
    void 상품등록(){
        //command + alt + v 자동완성
        /*
        final String name = "상품명";
        final int price = 1000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        final AddProductRequest request = new AddProductRequest(name, price, discountPolicy);
        final 변수에서 command alt M 으로 밖으로 뺌 -> 상풍등록요청_생성()
        */
        final AddProductRequest request = 상풍등록요청_생성();
        //API 요청
        final ExtractableResponse<Response> response = RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when()
                .post("/products")
                .then()
                .log().all().extract();

        assertThat(response.statusCode(), is(HttpStatus.CREATED.value()));
    }

    private static AddProductRequest 상풍등록요청_생성() {
        final String name = "상품명";
        final int price = 1000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        final AddProductRequest request = new AddProductRequest(name, price, discountPolicy);
        return request;
    }

}
