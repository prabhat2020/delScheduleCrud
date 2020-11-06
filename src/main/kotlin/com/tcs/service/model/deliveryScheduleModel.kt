package com.tcs.service.model

import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.PartitionKey
import org.springframework.data.annotation.Id
import java.util.*
import javax.annotation.Generated
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

@Document(collection = "delivery-schedule")
data class deliveryScheduleModel(
      //  @Id @Generated(strategy = GenerationType.AUTO) val id: Int,

        @PartitionKey  @GeneratedValue val id: String,
        val storeNumber: Long,
        val deliveryStreamNumber: Int,
        val deliveryStreamName: String,
        val schemaName: String,
        val deliverySchemaType: Int,
        val startDate: String,
        val endDate: String,
        val notes: String
)