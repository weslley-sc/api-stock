package com.solinftec.stock.repository;




import com.solinftec.stock.model.Stock;


import org.springframework.data.jpa.repository.JpaRepository;



import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {


 

    

   Optional<Stock> findByStockSymbol(String stockSymbol);
   Optional<Stock> findByStockName(String stockName);

}
