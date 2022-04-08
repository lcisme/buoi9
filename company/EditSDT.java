package com.company;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

public class EditSDT {
    public TextField name;
    public TextArea sdt;
    public NhapTT nhapTT;
    public Text loi;

    public void setData(NhapTT nhapTT){
        this.nhapTT = nhapTT;
        name.setText(nhapTT.getName());
        sdt.setText(nhapTT.getSdt().toString());
    }

    public void nhaptt(){
        try {
            NhapTT ntt = new NhapTT(name.getText(),sdt.getText());

            if (name.getText().isEmpty() || sdt.getText().isEmpty()){
                throw new Exception("Nhap day du thong tin pleaseeeeeeeeeeee!!!!!!!!");
            }
            else{
                int i = Main.nttList.indexOf(this.nhapTT);
                Main.nttList.set(i,ntt);
                System.out.println("Thành công r");
                loi.setVisible(false);
            }
            Parent root = FXMLLoader.load(getClass().getResource("ttsdt.fxml"));
            Main.rootStage.setScene(new Scene(root,800,600));
            loi.setVisible(false);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            loi.setText("Nhap thieu roi ban ej");
            loi.setVisible(true);

        }
    }
    public void ttng() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ttsdt.fxml"));
        Main.rootStage.setScene(new Scene(root,800,600));
    }



}
