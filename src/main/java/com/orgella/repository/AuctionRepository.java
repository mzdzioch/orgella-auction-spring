package com.orgella.repository;

import com.orgella.model.Auction;
import com.orgella.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuctionRepository extends CrudRepository<Auction, Integer> {

    List<Auction> getAllBy();

    List<Auction> findAuctionsByActiveIsTrue();

    List<Auction> findAuctionsByActiveIsFalse();

    List<Auction> findAuctionsByActiveIsTrueAndPersonIsNot(Person person);

    Auction findAuctionById(Integer id);

    Auction getAuctionById(Integer id);

    List<Auction> findAllByPerson(Person person);

    List<Auction> findAllByCategoryId(Integer categoryId);


}
