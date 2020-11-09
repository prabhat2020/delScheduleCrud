package com.tcs.service.model

import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.PartitionKey
import org.springframework.data.annotation.Id
import java.util.*
import javax.annotation.Generated
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.NamedQuery

@Document(collection = "delivery-schedule")
@NamedQuery(name="deliveryScheduleModel.findByStoreNumberAndDeliveryStreamNumber",
        query="SELECT * FROM delivery-schedule  WHERE (:storenum is null or c. storeNumber= :storenum) AND (:delstreamnum is null or c.deliveryStreamNumber= :delstreamnum))")
data class deliveryScheduleModel(


          val id: String?,
        val storeNumber: Long?,
        val deliveryStreamNumber: Int?,
        val deliveryStreamName: String?,
        val schemaName: String?,
        val deliverySchemaType: Int?,
        val startDate: String?,
        val endDate: String?,
        val notes: String?,
           val _rid : String?,
           var timetablelist:List<Timetable>?

)