package lt.vu.rest;

import lt.vu.entities.Costumer;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/student")
@Produces(MediaType.APPLICATION_JSON)
public class CostumerRestService {
    @PersistenceContext
    private EntityManager em;

    @GET
    @Path("/{costumerId}")
    public Costumer find(@PathParam("costumerId") Integer studentId) {
        System.out.println("==== Get Request ====");
        System.out.println("Costumer id: " + studentId);
        return em.find(Costumer.class, studentId);
    }

    @Path("/create")
    @PUT
    @Transactional
    public Costumer create(@QueryParam("personal") Integer personal,
                           @QueryParam("name") String name,
                           @QueryParam("surname") String surname){

        System.out.println("==== Put Request ====");
        System.out.println("Personal code: " + personal);
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);

        Costumer costumer = new Costumer();
        costumer.setPersonalCode(personal);
        costumer.setName(name);
        costumer.setSurname(surname);
        em.persist(costumer);
        return costumer;
    }

    @Path("/update/{personal}")
    @POST
    @Transactional
    public Response update(@PathParam("personal") Integer personal,
                           @QueryParam("name") String name,
                           @QueryParam("surname") String surname) {
        Costumer costumer = em.find(Costumer.class, personal);
        if (costumer == null) {
            throw new IllegalArgumentException("Costumer with personal code: " + personal + " could not be found");
        }
        costumer.setName(name);
        costumer.setSurname(surname);
        em.merge(costumer);
        return Response.ok(costumer).build();
    }
}
