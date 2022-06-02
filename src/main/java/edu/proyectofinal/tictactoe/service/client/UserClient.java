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
        public Player getUserId(String id) {
            return webTarget.path("user/get/"+id)
                    .request(MediaType.APPLICATION_JSON)
                    .get(Player.class);
        }
        public Player getUserName(String id, String name) {
            return webTarget.path("user/get/"+id+"/name")
                    .queryParam("name", name)
                    .request(MediaType.APPLICATION_JSON)
                    .get(Player.class);
        }
        public Player putUser(String id, String name) {
            return webTarget.path("user/get/"+id+"/"+name)
                    .queryParam("name", name)
                    .request(MediaType.APPLICATION_JSON)
                    .put(Entity.entity("",MediaType.APPLICATION_JSON), Player.class);
        }
        public Player postUser(Player user) {
            return webTarget.path("user/post")
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(user,MediaType.APPLICATION_JSON), Player.class);
        }
    }


