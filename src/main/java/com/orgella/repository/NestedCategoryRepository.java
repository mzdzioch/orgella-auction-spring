package com.orgella.repository;

import com.orgella.model.NestedCategory;
import org.springframework.data.repository.CrudRepository;

public interface NestedCategoryRepository extends CrudRepository<NestedCategory, Integer> {

//    @Query("select u from NestedCategory nested_category")
//    List<NestedCategory> findAllBy();


}
