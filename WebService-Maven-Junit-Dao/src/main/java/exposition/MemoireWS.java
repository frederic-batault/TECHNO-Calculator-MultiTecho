package exposition;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import domaine.CalculDomaine;
import domaine.Memoire;
import service.CalculService;
import service.MemoireService;

@Path("/memoire")
public class MemoireWS {

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Memoire afficherWS() {
		MemoireService memoireService = new MemoireService();
		Memoire memoire = memoireService.afficherMemoire();
		return memoire;
	}

	@POST
	@Path("/post")
	@Produces(MediaType.APPLICATION_JSON)
	public Boolean memoriserWS(Memoire memoire) {
		MemoireService memoireService = new MemoireService();
		boolean memorise = memoireService.memoriser(memoire);
		Boolean memoriseO=Boolean.valueOf(memorise);
		return memoriseO;
	}
}
