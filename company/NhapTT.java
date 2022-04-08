package com.company;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.util.ArrayList;

public class NhapTT {
    public String name;
    public Button edit;
    public Button remove;
    ArrayList<String> sdt = new ArrayList<>();

    public Button getEdit() {
        return edit;
    }
    public void setEdit(Button edit) {
        this.edit = edit;
    }
    public Button getRemove() {
        return remove;
    }
    public void setRemove(Button remove) {
        this.remove = remove;
    }
    public String getSdt() {
        String s = "";
        for (String s1:sdt){
            s+=s1+"\n";
        }
        return s;
    }
    public void setSdt(ArrayList<String> sdt) {
        this.sdt = sdt;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public NhapTT(){ }

    public NhapTT(String name, String sdt) {
        this.name = name;
        this.sdt.add(sdt);
        this.edit = new Button("Edit");
        this.edit.setOnAction(event -> {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("edit.fxml"));
            Parent root = loader.load();
            EditSDT d = loader.getController();
            d.setData(this);
            Main.rootStage.setScene(new Scene(root,800,600));
        } catch (Exception e) {

        }
        });
        this.remove = new Button("Remove");
        this.remove.setOnAction(event -> {
            Main.nttList.remove(this);
        });
    }


}

