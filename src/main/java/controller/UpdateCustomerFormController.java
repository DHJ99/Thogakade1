package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import model.Customer;
import thogakadePOS.DBConnection;

import java.util.List;

public class UpdateCustomerFormController {

    @FXML
    public JFXButton btnSearch;

    @FXML
    public JFXButton btnUpdate;

    @FXML
    private DatePicker dateDob;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtSearchId;

    List<Customer> customersList = DBConnection.getInstance().getConnection();
    private Customer selectedCustomer;

    @FXML
    void btnSearch(ActionEvent ignoredEvent) {

        for(Customer customer : customersList){
            String searchId=txtSearchId.getText();

            if(customer.getId().equals(searchId)){
                selectedCustomer = customer;

                txtId.setText(customer.getId());
                txtName.setText(customer.getName());
                txtAddress.setText(customer.getAddress());
                txtContact.setText(customer.getContact());
                dateDob.setValue(customer.getDob());

                return;
            }
        }
        clearFields();
        selectedCustomer = null;
    }

    @FXML
    void btnUpdate(ActionEvent ignoredEvent) {
        if (selectedCustomer != null) {

            String updatedName = txtName.getText();
            String updatedAddress = txtAddress.getText();
            String updatedContact = txtContact.getText();

            selectedCustomer.setName(updatedName);
            selectedCustomer.setAddress(updatedAddress);
            selectedCustomer.setContact(updatedContact);
            selectedCustomer.setDob(dateDob.getValue());

            int index = customersList.indexOf(selectedCustomer);
            if (index != -1) {
                customersList.set(index, selectedCustomer);
                showAlert("Success", "Customer updated successfully.");
                clearFields();

            } else {
                showAlert("Error", "Failed to update customer in the list.");
                clearFields();
            }
        } else {
            showAlert("Error", "No customer selected. Please search for a customer first.");
            clearFields();
        }
    }

    private void clearFields() {
        txtId.clear();
        txtName.clear();
        txtAddress.clear();
        txtContact.clear();
        dateDob.setValue(null);
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
