package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML
    TextField name;

    @FXML
    TextField phone;

    @FXML
    TextField email;

    @FXML
    ListView list;

    ObservableList<Contact> contacts = FXCollections.observableArrayList();

    public void onAdd(){
        Contact c = new Contact(name.getText(), phone.getText(), email.getText());
        contacts.add(c);
    }

    public void onRemove() {
        SelectionModel model = list.getSelectionModel();
        Contact contact = (Contact) model.getSelectedItem();
        contacts.remove(contact);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.setItems(contacts);
    }
}
