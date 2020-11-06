package com.tcs.service.service

import com.tcs.service.error.customexception.DataNotFoundException
import com.tcs.service.model.BaseModel
import com.tcs.service.model.deliveryScheduleModel
import com.tcs.service.repository.DeliveryScheduleRepositories
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class DeliveryScheduleCrudService(private val Repository: DeliveryScheduleRepositories) {

    val ndf = "No Data Found"
 /*   fun getBaseModel(): BaseModel {
        val result: TemplateContainer = templateContainerRepository.findById(101).block()
                ?: throw DataNotFoundException(ndf)
        return BaseModel().copy(modId = result.id.toString(), modDesc = result.name);
    }

    fun saveModel(model: BaseModel) {
        templateContainerRepository.save(TemplateContainer(id = model.modId.toInt(), name = model.modDesc))

    } */
fun getAll(): List<deliveryScheduleModel> {
     return Repository.findAll().collectList().block()?:throw DataNotFoundException(ndf)
 }
fun saveSchedule(deliveryScheduleModel:deliveryScheduleModel) {
    println(deliveryScheduleModel)
     Repository.save(deliveryScheduleModel).subscribe()
}
}