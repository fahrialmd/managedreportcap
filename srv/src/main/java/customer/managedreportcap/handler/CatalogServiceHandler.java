package customer.managedreportcap.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sap.cds.Result;
import com.sap.cds.ResultBuilder;
import com.sap.cds.reflect.CdsEntity;
import com.sap.cds.reflect.CdsModel;
import com.sap.cds.services.cds.CdsReadEventContext;
import com.sap.cds.services.cds.CqnService;
import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.services.handler.annotations.After;
import com.sap.cds.services.handler.annotations.On;
import com.sap.cds.services.handler.annotations.ServiceName;

import cds.gen.catalogservice.CatalogService_;
import cds.gen.catalogservice.AllEntities;
import cds.gen.catalogservice.AllEntities_;
import cds.gen.catalogservice.Books;

@Component
@ServiceName(CatalogService_.CDS_NAME)
public class CatalogServiceHandler implements EventHandler {

    @Autowired
    CdsModel cdsModel;

    @On(event = CqnService.EVENT_READ, entity = AllEntities_.CDS_NAME)
    public void getAllEntities(CdsReadEventContext context) {

        List<AllEntities> results = new ArrayList<AllEntities>();

        cdsModel.services().forEach((service) -> {
            String serviceName = service.getName();
            Stream<CdsEntity> entities = service.entities();
            entities.forEach((entity) -> {
                AllEntities entityResult = AllEntities.create();
                entityResult.setEntityName(entity.getName());
                entityResult.setDescription(entity.getAnnotationValue("title", null));
                entityResult.setService(serviceName);
                results.add(entityResult);
            });
        });

        long inlineCount = results.size();
        Result result = ResultBuilder.selectedRows(results).inlineCount(inlineCount).result();
        context.setResult(result);

    }

}
