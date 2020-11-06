package com.tcs.service.model

import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document
import org.springframework.data.annotation.Id
import java.util.*
import javax.annotation.Generated
import javax.persistence.Entity
import javax.persistence.GenerationType
import javax.persistence.*


/**
 * This class will contain all the DTO Objects
 */
@Document(collection = "delivery-schedule")
@Entity
data class deliverySchedule(
      //  @Id @Generated(strategy = GenerationType.AUTO) val id: Int,

       @Id @GeneratedValue val id: Int,
       val storeNumber: Int,
       val deliveryStreamNumber: Int,
       val deliveryStreamName: String,
       val schemaName: String,
       val deliverySchemaType: Int,
       val startDate: Date,
       val endDate: Date,
       val notes: String
)


