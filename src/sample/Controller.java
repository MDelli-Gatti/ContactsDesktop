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

    static ObservableList<Contact> contacts = FXCollections.observableArrayList();


    public void onAdd() throws Exception {
        Contact c = new Contact(name.getText(), phone.getText(), email.getText());
        if (c.name.equals("")) {
            throw new Exception("no name");
        }
        else if (c.phone.equals("")) {
            throw new Exception("no phone number");
        }
        else if (c.email.equals("")) {
            throw new Exception("no email");
        }
        else{
            contacts.add(c);
        }
        name.setText("Enter Name");
        phone.setText("Enter Phone Number");
        email.setText("Enter Email");

    }

    public void onRemove() {
        SelectionModel model = list.getSelectionModel();
        Contact contact = (Contact) model.getSelectedItem();
        contacts.remove(contact);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.setItems(contacts);
        name.setText("Enter Name");
        phone.setText("Enter Phone Number");
        email.setText("Enter Email");

    }
}
