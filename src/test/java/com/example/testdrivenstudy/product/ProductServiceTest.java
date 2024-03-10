package com.example.testdrivenstudy.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/*
변수에 final 키워드 변경이 필요 없는 변수를 불변으로 만듬
변수의 값이 변경되는 오류를 방지하는 차원에서 값이 변경되지 않는 모든 변수를 불변으로 만듭니다.
무분별하게 setter를 만들지 않는것과 비슷.!
단축키 select refactoring F6
*/

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

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
        productService.addProduct(request);
    }

    private static AddProductRequest 상풍등록요청_생성() {
        final String name = "상품명";
        final int price = 1000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        final AddProductRequest request = new AddProductRequest(name, price, discountPolicy);
        return request;
    }

}
