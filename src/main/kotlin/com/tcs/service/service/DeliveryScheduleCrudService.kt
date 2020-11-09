package com.tcs.service.service

import com.tcs.service.error.customexception.DataNotFoundException
import com.tcs.service.model.deliveryScheduleModel
import com.tcs.service.repository.DeliveryScheduleRepositories
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.persistence.EntityManager

@Service
class DeliveryScheduleCrudService (private val Repository: DeliveryScheduleRepositories) {

    val ndf = "No Data Found"




//       fun getBaseModel(): BaseModel {
//           val result: TemplateContainer = templateContainerRepository.findById(101).block()
//                   ?: throw DataNotFoundException(ndf)
//           return BaseModel().copy(modId = result.id.toString(), modDesc = result.name);
//       }
//
//       fun saveModel(model: BaseModel) {
//           templateContainerRepository.save(TemplateContainer(id = model.modId.toInt(), name = model.modDesc))
//
//       }
fun getAll(): List<deliveryScheduleModel> {
     return Repository.findAll().collectList().block()?:throw DataNotFoundException(ndf)
 }

 fun getbyquery(storenum:Long?,delstreamnum:Int?):  List<deliveryScheduleModel>{

//     val matcher = ExampleMatcher.matching().withIgnoreNullValues()
//     val sampleobj = deliveryScheduleModel("null",120,1,null,null,null,null,null,null,null,null)
//     var exampleQuery: Example<deliveryScheduleModel> = Example.of(sampleobj, matcher)
//     return Repository.findAll(exampleQuery)?.collectList()?.block()?:throw DataNotFoundException(ndf)
     print(storenum)
     print(delstreamnum)
     if(storenum==null)
         return Repository.findByDeliveryStreamNumber(delstreamnum)?.collectList()?.block()?:throw DataNotFoundException(ndf)
     else if(delstreamnum==null)
         return Repository.findByStoreNumber(storenum)?.collectList()?.block()?:throw DataNotFoundException(ndf)
     else
     return Repository.findByStoreNumberAndDeliveryStreamNumber(storenum,delstreamnum)?.collectList()?.block()?:throw DataNotFoundException(ndf)

 }

fun saveSchedule(deliveryScheduleModel:deliveryScheduleModel) {
    println(deliveryScheduleModel)
     Repository.save(deliveryScheduleModel).subscribe()
}
}