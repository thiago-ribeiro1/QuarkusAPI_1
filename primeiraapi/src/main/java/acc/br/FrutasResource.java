package acc.br;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import acc.br.model.Fruta;

@ApplicationScoped // mantém uma única instância da classe durante toda a execução do aplicativo
@Path("/frutas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FrutasResource {

    // listar frutas
    @GET
    public List<Fruta> list() {
        return Fruta.listAll();
    }

    // inserir frutas
    @POST
    @Transactional
    public Response inserirFruta(Fruta fruta) {
        if (fruta == null || fruta.nome == null || fruta.qtd <= 0) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        fruta.persist();
        return Response.status(Response.Status.CREATED).entity(fruta).build();
    }

    // excluir uma fruta específica
    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deletarFruta(@PathParam("id") Long id) {
        Fruta fruta = Fruta.findById(id);
        if (fruta == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        fruta.delete();
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
