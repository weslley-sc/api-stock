package com.solinftec.stock.dto;

import com.solinftec.stock.model.Stock;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockDTO {
    
    private Long id;
    private String stockSymbol;
    private String stockName;
    private Double askMin;
    private Double askMax;
    private Double bidMin;
    private Double bidMax;
   
    
    
    public StockDTO(Stock stock) {
        this.id = stock.getId();
        this.stockSymbol = stock.getStockSymbol();
        this.stockName = stock.getStockName();
        this.askMin = stock.getAskMin();
        this.askMax = stock.getAskMax();
        this.bidMin = stock.getBidMin();
        this.bidMax = stock.getBidMax();
    }
    

    
    
    
}
