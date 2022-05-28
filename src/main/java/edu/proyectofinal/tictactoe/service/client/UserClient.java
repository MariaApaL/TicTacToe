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
            this.webTarget = client.target("http://localhost:8080/WebServices/api/");
        }
        public Player getNotification(String id) {
            return webTarget.path("notifications/get/"+id)
                    .request(MediaType.APPLICATION_JSON)
                    .get(Player.class);
        }
        public Player getNotification(String id, String name) {
            return webTarget.path("notifications/get/"+id+"/name")
                    .queryParam("name", name)
                    .request(MediaType.APPLICATION_JSON)
                    .get(Player.class);
        }
        public Player putNotification(String id, String name) {
            return webTarget.path("notifications/get/"+id+"/"+name)
                    .queryParam("name", name)
                    .request(MediaType.APPLICATION_JSON)
                    .put(Entity.entity("",MediaType.APPLICATION_JSON), Player.class);
        }
        public Player postNotification(Player notification) {
            return webTarget.path("notifications/post")
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(notification,MediaType.APPLICATION_JSON), Player.class);
        }
    }


