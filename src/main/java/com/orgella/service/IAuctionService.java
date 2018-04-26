package com.orgella.service;

import com.orgella.model.Auction;
import com.orgella.model.Bid;
import com.orgella.model.Person;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface IAuctionService {

    List<Auction> getAllAuctions();

    List<Auction> getAllAuctionsWithLatestPrice();

    List<Auction> getAllAuctionsWithLatesPriceAndPersonIsNot(Person person);

    List<Auction> getAllActiveAuctions();

    List<Auction> getAllInactiveAuctions();

    List<Auction> findAllAuctionsByPerson(Person person);

    Auction getAuction(Integer id);

    Auction saveAuction(Auction auction);

    List<Bid> getBidList(Auction auction);

    BigDecimal getLastPrice(Auction auction);

    boolean isBidHigher(Auction auction, BigDecimal bidValue);

    boolean makeBid(Auction auction, BigDecimal bidValue);

    void setAuctionFalse(Auction auction);
}
