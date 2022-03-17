package com.solinftec.stock;

import com.solinftec.stock.controller.StockController;
import com.solinftec.stock.dto.StockDTO;

import com.solinftec.stock.service.StockService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import io.restassured.http.ContentType;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@WebMvcTest
public class StockControllerTeste {

    @Autowired
    StockController stockController;

    @MockBean
    private StockService stockService;

    @BeforeEach
    public void setup(){
        standaloneSetup(this.stockController);
    }

    @Test
    void deveRetornarSucesso_QuandoBuscarStock() throws Exception{
        when(this.stockService.stockUnico(1L))
			.thenReturn(new StockDTO(1L, "BEEF", "MINERVA", null, null, null, null));
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/{id}", 1L)
		.then()
			.statusCode(HttpStatus.OK.value());
        
    }

    @Test
    void deveRetornarNaoEncontrado_QuandoBuscarStock() throws Exception{
        when(this.stockService.stockUnico(800L))
                .thenReturn(null);
        given()
            .accept(ContentType.JSON)
        .when()
            .get("/{id}", 800L)
        .then()
            .statusCode(HttpStatus.NOT_FOUND.value());
    }
    
    @Test
	void deveRetornarBadRequest_QuandoBuscarStock() throws Exception {
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/{id}", -1L)
		.then()
			.statusCode(HttpStatus.BAD_REQUEST.value());
		
		verify(this.stockService, never()).stockUnico(-1L);
	} 
    
}
