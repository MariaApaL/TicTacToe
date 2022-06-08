package edu.proyectofinal.tictactoe.service.client;


import edu.proyectofinal.tictactoe.model.dao.Player;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;


public class UserClient {

        private WebTarget webTarget;

        public UserClient() {
            Client client = ClientBuilder.newClient();
            this.webTarget = client.target("http://localhost:8080/webservice/api/");
        }
        public Player FindByName(String name) {
            return webTarget.path("user/"+name)
                    .request(MediaType.APPLICATION_JSON)
                    .get(Player.class);
        }
        public Player validate(Player player) {
            return webTarget.path("user/player")
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(player,MediaType.APPLICATION_JSON), Player.class);
        }
        public Player delete(Player player) {
            return webTarget.path("user/player")
                    .request(MediaType.APPLICATION_JSON)
                    .delete(Player.class);
        }
        public Player insert(Player player) {
            return webTarget.path("user")
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(player,MediaType.APPLICATION_JSON), Player.class);
        }

    public Player findbyId(int id) {

        return webTarget.path("user/"+id)
                .request(MediaType.APPLICATION_JSON)
                .get(Player.class);
    }

    public Player update(Player player){
            return webTarget.path("user")
                    .request(MediaType.APPLICATION_JSON)
                    .put(Entity.entity("",MediaType.APPLICATION_JSON), Player.class);
        }
    }


