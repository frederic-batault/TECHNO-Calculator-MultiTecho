package exposition;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import domaine.CalculDomaine;
import domaine.Memoire;
import service.CalculService;
import service.MemoireService;

@Path("/calcul")
public class CalculWS {

	@PUT
	@Path("/put")
	@Produces(MediaType.APPLICATION_JSON)
	public CalculDomaine calculWS(CalculDomaine calculAller) {
		CalculService calculService = new CalculService();
		CalculDomaine calculRetour = calculService.choixOperateur(calculAller);
		return calculRetour;
	}
	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public CalculDomaine testWS() {
		CalculDomaine calc = new CalculDomaine (1.0,1,2.0,3.0,"3");
		return calc;
	}
}
