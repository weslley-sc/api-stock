package com.solinftec.stock.service;


import java.util.Optional;

import com.solinftec.stock.dto.StockDTO;


public interface IStockService {
    Optional<StockDTO> findByStockSymbol(String stockSymbol);

    Optional<StockDTO> findByStockName(String stockName);
    
}
