package com.solinftec.stock;

import static org.junit.jupiter.api.Assertions.assertNull;

import com.solinftec.stock.model.Stock;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StockApplicationTests {

	@Test
	void stockTests() {
		Stock stock = new Stock();
		assertNull(stock.getStockName());
	}

}
