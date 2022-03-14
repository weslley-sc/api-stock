package com.solinftec.stock.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.solinftec.stock.dto.StockDTO;
import com.solinftec.stock.model.Stock;
import com.solinftec.stock.repository.StockRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StockService implements IStockService {
 private final StockRepository stockRepository;
    
    public List<StockDTO> getAll(){
        return stockRepository.findAll()
                .stream()
                .map(StockDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public StockDTO stockUnico(@PathVariable("id") Long id){
        Stock stock = stockRepository.findById(id)
                .orElseThrow();
        return new StockDTO(stock);
    }

    @Transactional(readOnly = true)
    public Page<StockDTO> getPage(Pageable pageable) {
        Page<Stock> result = stockRepository.findAll(pageable);
        return result.map(StockDTO::new);
    }

    @Override
    public Optional<StockDTO> findByStockSymbol(String stockSymbol) {
        Optional<Stock> find = stockRepository.findByStockSymbol(stockSymbol);
        return find.map(StockDTO::new);
        
    }

    @Override
    public Optional<StockDTO> findByStockName(String stockName) {
        Optional<Stock> find = stockRepository.findByStockName(stockName);
        return find.map(StockDTO::new);
        
    }
}
