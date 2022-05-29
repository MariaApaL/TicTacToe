package edu.proyectofinal.tictactoe.controller;

import edu.proyectofinal.tictactoe.App;
import edu.proyectofinal.tictactoe.model.dao.LineItem;
import edu.proyectofinal.tictactoe.model.dao.Player;
import edu.proyectofinal.tictactoe.model.manager.impl.UserManagerImpl;
import edu.proyectofinal.tictactoe.service.UserService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 *
 * Ranking class
 *
 * @author MariaApa
 * @author Valentina
 * @author Julia
 *
 */
public class RankingController implements Initializable {


    @FXML
    private TableView <LineItem> table;

    private UserService userService;

    private List<Map<String, String>> getDatabaseObject() throws SQLException, ClassNotFoundException {
        List<Player> users = userService.ranking();

        List<Map<String, String>> mappedValues = new ArrayList<>();

        int counter = 1;

        users.forEach(user -> {

            Map<String, String> record = new HashMap<>();
            record.put("Rank", String.valueOf(counter));
            record.put("Name", user.getPlayerName());
          //  record.put("Games", String.valueOf(user.getNumGame()));
            mappedValues.add(record);

        });
        return mappedValues;
    }


    public void rankingUsers() throws SQLException, ClassNotFoundException {


        table = new TableView<>();

        List<Map<String, String>> databaseObject = getDatabaseObject();

        for (String key : databaseObject.get(0).keySet())
        {
            TableColumn<LineItem, String> col = new TableColumn<>(key);
            col.setCellValueFactory((TableColumn.CellDataFeatures<LineItem, String> cellData) -> cellData.getValue().fieldProperty(key));
            table.getColumns().add(col);

        }
        List<LineItem> data = databaseObject.stream().map(LineItem::new).collect(Collectors.toList());
        LineItem sequence1 = new LineItem(databaseObject.get(0));
        data.add(sequence1);


    }


    /**
     * switch to login interface.
     * @throws {@code IOException}
     */
    public void switchToLogin(ActionEvent event) throws IOException{
        App.setStage("loginInterface");
    }

    /**
     * switch to menu interface.
     * @throws {@code IOException}
     */
    public void switchToMenu(ActionEvent event) throws IOException{
        App.setStage("prueba");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userService= new UserService(new UserManagerImpl());

        try {
            getDatabaseObject();
            rankingUsers();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();

        }
    }
}
