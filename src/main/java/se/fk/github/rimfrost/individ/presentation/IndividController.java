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
      GetIndividResponse response = new GetIndividResponse();
      response.setId(id);
      response.setTyp("Pnr");
      response.setVarde("19900101-1234");

      return response;
   }
}
