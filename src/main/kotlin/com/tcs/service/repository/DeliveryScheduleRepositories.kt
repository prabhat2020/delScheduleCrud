package com.tcs.service.repository

import org.springframework.stereotype.Repository
import com.microsoft.azure.spring.data.cosmosdb.repository.ReactiveCosmosRepository
import com.tcs.service.model.deliveryScheduleModel
import org.springframework.data.domain.Example
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import reactor.core.publisher.Flux
import javax.persistence.EntityManagerFactory

/**
 * This file will contain all the repositories interfaces.
 */

@Repository
interface DeliveryScheduleRepositories : ReactiveCosmosRepository<deliveryScheduleModel, Int>{
    //fun findByStoreNumberOrDeliveryStreamNumber(storeNumber: Long?,delstreamnum:Int?):  Flux<deliveryScheduleModel>?
    //fun findAll(exampleQuery : Example<deliveryScheduleModel>):Flux<deliveryScheduleModel>?
  //  @Query(nativeQuery=true,value="SELECT * FROM delivery-schedule  WHERE (:storenum is null or c. storeNumber= :storenum) AND (:delstreamnum is null or c.deliveryStreamNumber= :delstreamnum)")
   // @Query(value="SELECT * FROM c delivery-schedule  WHERE (:storenum is null or c. storeNumber= :storenum)",nativeQuery=true)
   // fun findDeliveryScheduleModelByStoreNumberAndDeliveryStreamNumber(storenum: Long?,delstreamnum: Int?): Flux<deliveryScheduleModel>?
   // @Query(nativeQuery=true)

    fun findByStoreNumberAndDeliveryStreamNumber(storenum: Long?, delstreamnum: Int?):Flux<deliveryScheduleModel>?
    fun findByDeliveryStreamNumber(delstreamnum: Int?):Flux<deliveryScheduleModel>?
    fun findByStoreNumber(storenum: Long):Flux<deliveryScheduleModel>?


}