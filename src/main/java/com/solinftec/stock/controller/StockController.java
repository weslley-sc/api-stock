package com.solinftec.stock.controller;

import java.util.List;
import java.util.Optional;

import com.solinftec.stock.service.StockService;
import com.solinftec.stock.dto.StockDTO;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stock")
public class StockController {


  

    private final StockService stockService;

    @GetMapping("")
    public ResponseEntity<List<StockDTO>> getAll() {
        try {
            return ResponseEntity.ok().body(stockService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        
    }

    @GetMapping("/stocksymbol/{stockSymbol}")
    public ResponseEntity<Optional<StockDTO>> buscaPorSymbol(@PathVariable("stockSymbol") String stockSymbol) {
        return ResponseEntity.ok().body(stockService.findByStockSymbol(stockSymbol));
        
    }
    @GetMapping("/stockname/{stockName}")
    public ResponseEntity<Optional<StockDTO>> buscaPorName(@PathVariable("stockName") String stockName) {
        return ResponseEntity.ok().body(stockService.findByStockName(stockName));
        
    }


    @GetMapping("/paged")
    public ResponseEntity<Page<StockDTO>> getPage(Pageable pageable) {
        try {
            return ResponseEntity.ok().body(stockService.getPage(pageable)) ;
            
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockDTO> stockUnico(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(stockService.stockUnico(id))  ;
    }

    @PostMapping("/update_stocks")
    public StockDTO updateStocks(
             @RequestBody StockDTO stocksPricesDto) {
       return stockService.updateStocks(stocksPricesDto);
    }
}
