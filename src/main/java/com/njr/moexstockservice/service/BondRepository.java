package com.njr.moexstockservice.service;

import com.njr.moexstockservice.dto.BondDto;
import com.njr.moexstockservice.exception.LimitRequestsException;
import com.njr.moexstockservice.parser.Parser;
import com.njr.moexstockservice.moexclient.CorporateBondsClient;
import com.njr.moexstockservice.moexclient.GovBondsClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BondRepository {
    private final CorporateBondsClient corporateBondsClient;
    private final GovBondsClient govBondsClient;

    private final Parser bondsParser;

    @Cacheable(value = "corps")
    public List<BondDto> getCorporateBonds() {
        log.info("Getting corporate bonds from Moex");
        String xmlFromMoex = corporateBondsClient.getBondsFromMoex();
        List<BondDto> bonds = bondsParser.parse(xmlFromMoex);
        if(bonds.isEmpty()) {
            log.error("Moex isn't answering for getting corporate bonds.");
            throw new LimitRequestsException("Moex isn't answering for getting corporate bonds.");
        }
        return bonds;
    }

    @Cacheable(value = "govs")
    public List<BondDto> getGovBonds() {
        log.info("Getting government bonds from Moex");
        String xmlFromMoex = govBondsClient.getBondsFromMoex();

        List<BondDto> bonds = bondsParser.parse(xmlFromMoex);
        if(bonds.isEmpty()) {
            log.error("Moex isn't answering for getting government bonds.");
            throw new LimitRequestsException("Moex isn't answering for getting government bonds.");
        }
        return bonds;
    }
}
