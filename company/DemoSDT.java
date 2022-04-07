package com.company;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

public class DemoSDT {
    public TextField name;
    public TextField sdt;
    public Text loi;


    public void nhaptt(){
        try {
            if (name.getText().isEmpty() || sdt.getText().isEmpty()){
                throw new Exception("Nhap day du thong tin pleaseeeeeeeeeeee!!!!!!!!");
            }
            for (NhapTT ntt:Main.nttList) {
                if (ntt.getName().equals(name.getText())){
                    for (String s:ntt.sdt) {
                        if (s.equals(sdt.getText())){
                            this.loi.setText("Sai r ");
                            this.loi.setVisible(true);
                            return;
                        }
                    }
                    ntt.sdt.add(sdt.getText());
                    this.loi.setText("Thêm thành công");
                    this.loi.setVisible(true);
                    return;
                }
            }
            Main.nttList.add(new NhapTT(name.getText(),sdt.getText()));
            this.loi.setText("Thêm thành công name and sđt");
            this.loi.setVisible(true);
            Parent root = FXMLLoader.load(getClass().getResource("ttsdt.fxml"));
            Main.rootStage.setScene(new Scene(root,800,600));
        }
        catch (Exception e){
        loi.setText(e.getMessage());
        loi.setVisible(true);
        }
    }

    public void ttng() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("ttsdt.fxml"));
        Main.rootStage.setScene(new Scene(root,800,600));
    }



}
