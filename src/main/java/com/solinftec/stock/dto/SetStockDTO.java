package com.solinftec.stock.dto;

import lombok.Data;

@Data
public class SetStockDTO {
    private Long id;
    private Double askMin;
    private Double askMax;
    private Double bidMin;
    private Double bidMax;
}
