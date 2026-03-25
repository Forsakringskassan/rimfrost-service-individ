package se.fk.github.rimfrost.individ.presentation;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Path;
import java.util.UUID;
import se.fk.rimfrost.api.individ.jaxrsspec.controllers.generatedsource.IndividControllerApi;
import se.fk.rimfrost.api.individ.jaxrsspec.controllers.generatedsource.model.GetIndividResponse;

@ApplicationScoped
@Path("/individ/{id}")
public class IndividController implements IndividControllerApi
{
   @Override
   public GetIndividResponse individIdGet(UUID id)
   {
      var idString = id.toString();
      var ssn = "19900101-1234";

      if (idString.matches("0[-0]+[0-9]{12}$"))
      {
         var idSsn = idString.substring(idString.length() - 12);
         ssn = idSsn.substring(0, 8) + "-" + idSsn.substring(8, 12);
      }

      GetIndividResponse response = new GetIndividResponse();
      response.setId(id);
      response.setTyp("Pnr");
      response.setVarde(ssn);

      return response;
   }
}
