package com.njr.moexstockservice.controller;

import com.njr.moexstockservice.dto.FigiesDto;
import com.njr.moexstockservice.dto.StocksDto;
import com.njr.moexstockservice.dto.StocksPricesDto;
import com.njr.moexstockservice.dto.TickersDto;
import com.njr.moexstockservice.service.BondService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bonds")
@RequiredArgsConstructor
public class BondMoexController {
    private final BondService bondService;

    @PostMapping("/getBondsByTickers")
    public StocksDto getBondsFromMoex(@RequestBody TickersDto tickersDto) {
        return bondService.getBondsFromMoex(tickersDto);
    }

    @PostMapping("/prices")
    public StocksPricesDto getPricesByFigies(@RequestBody FigiesDto figiesDto) {
        return bondService.getPricesByFigies(figiesDto);
    }
}
