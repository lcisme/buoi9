package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class DanhSachSDT implements Initializable {
    public TableView<NhapTT> tXemDS;
    public TableColumn<NhapTT, String > tName;
    public TableColumn<NhapTT, String > tSDT;
    public TableColumn<NhapTT, Button> tEdit;
    public TableColumn<NhapTT, Button> tRemove;
    public TextField tSearch;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    tName.setCellValueFactory(new PropertyValueFactory<NhapTT, String>("name"));
    tSDT.setCellValueFactory(new PropertyValueFactory<NhapTT, String>("sdt"));
    tEdit.setCellValueFactory(new PropertyValueFactory<NhapTT, Button>("edit"));
    tRemove.setCellValueFactory(new PropertyValueFactory<NhapTT, Button>("remove"));
    tXemDS.setItems(Main.nttList);
    }

    public void formthemsdt() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("nhapsdt.fxml"));
        Main.rootStage.setScene(new Scene(root,800,600));
    }

    public void search(){
    String t = tSearch.getText();
    ArrayList<NhapTT> kq = Main.nttList.stream()
            .filter(p->p.getName().contains(t)|| p.getSdt().contains(t))
            .collect(Collectors.toCollection(ArrayList::new));
    ObservableList ketqua = FXCollections.observableArrayList();
    ketqua.addAll(kq);
    tXemDS.setItems(ketqua);
    }

}
