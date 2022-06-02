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
        public Player FindUser(String name) {
            return webTarget.path("user/"+name)
                    .request(MediaType.APPLICATION_JSON)
                    .get(Player.class);
        }
        public Player validateUser(Player player) {
            return webTarget.path("user/player")
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(player,MediaType.APPLICATION_JSON), Player.class);
        }
        public Player deleteUser(Player player) {
            return webTarget.path("user/player")
                    .request(MediaType.APPLICATION_JSON)
                    .delete(Player.class);
        }
        public Player insertUserReg(Player player) {
            return webTarget.path("user")
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(player,MediaType.APPLICATION_JSON), Player.class);
        }

        public Player updatePassword(Player player){
            return webTarget.path("user")
                    .request(MediaType.APPLICATION_JSON)
                    .put(Entity.entity("",MediaType.APPLICATION_JSON), Player.class);
        }
    }


