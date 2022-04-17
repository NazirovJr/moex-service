package com.njr.moexstockservice.parser;


import com.njr.moexstockservice.dto.BondDto;

import java.util.List;

public interface Parser {
    List<BondDto> parse(String ratesAsString);
}
