package com.njr.moexstockservice.dto;

import com.njr.moexstockservice.model.Stock;
import lombok.*;

import java.util.List;

@Value
public class StocksDto {
    List<Stock> stocks;
}
