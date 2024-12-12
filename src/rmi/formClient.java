package rmi;

import java.awt.*;
import java.awt.event.*;
import java.rmi.Naming;

@SuppressWarnings("serial")
public class formClient extends Frame {
    private TextField enoField, nameField, deptField, desgField, unameField, prdField;
    private Button submitButton;
    private TextArea resultArea;

    public formClient() {
        setLayout(new FlowLayout());

        add(new Label("Enrollment No:"));
        enoField = new TextField(20);
        add(enoField);

        add(new Label("Name:"));
        nameField = new TextField(20);
        add(nameField);

        add(new Label("Department:"));
        deptField = new TextField(20);
        add(deptField);

        add(new Label("Designation:"));
        desgField = new TextField(20);
        add(desgField);

        add(new Label("Username:"));
        unameField = new TextField(20);
        add(unameField);

        add(new Label("Password:"));
        prdField = new TextField(20);
        prdField.setEchoChar('*');
        add(prdField);

        submitButton = new Button("Submit");
        add(submitButton);

        resultArea = new TextArea(5, 40);
        add(resultArea);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitData();
            }
        });

        setSize(400, 400);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    private void submitData() {
        int eno = Integer.parseInt(enoField.getText());
        String name = nameField.getText();
        String dept = deptField.getText();
        String desg = desgField.getText();
        String uname = unameField.getText();
        String prd = prdField.getText();

        try {
            String formServerURL = "rmi://localhost:1099/formServer";
            form aform = (form) Naming.lookup(formServerURL);
            String result = aform.stdData(eno, name, dept, desg, uname, prd);
            resultArea.setText(result);
        } catch (Exception e) {
            e.printStackTrace();
            resultArea.setText("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new formClient();
    }
}
