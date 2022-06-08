package edu.proyectofinal.tictactoe.service.client;

import edu.proyectofinal.tictactoe.model.dao.Player;
import edu.proyectofinal.tictactoe.model.dao.Suggestion;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

public class SuggestionClient {

    private WebTarget webTarget;

    public SuggestionClient() {
        Client client = ClientBuilder.newClient();
        this.webTarget = client.target("http://localhost:8080/webservice/api/");
    }
    public Suggestion FindByName(String name) {
        return webTarget.path("suggest/"+name)
                .request(MediaType.APPLICATION_JSON)
                .get(Suggestion.class);
    }
    public Suggestion validate(Suggestion suggu) {
        return webTarget.path("suggest/suggu")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(suggu,MediaType.APPLICATION_JSON), Suggestion.class);
    }
    public Suggestion delete(Suggestion suggu) {
        return webTarget.path("suggest/suggu")
                .request(MediaType.APPLICATION_JSON)
                .delete(Suggestion.class);
    }
    public Suggestion insertSuggestion(Suggestion suggu) {
        return webTarget.path("suggest")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(suggu,MediaType.APPLICATION_JSON), Suggestion.class);
    }

    public Suggestion findbyId(int id) {

        return webTarget.path("suggest/"+id)
                .request(MediaType.APPLICATION_JSON)
                .get(Suggestion.class);
    }

    public Suggestion update(Suggestion sugu){
        return webTarget.path("suggest")
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity("",MediaType.APPLICATION_JSON), Suggestion.class);
    }
}



