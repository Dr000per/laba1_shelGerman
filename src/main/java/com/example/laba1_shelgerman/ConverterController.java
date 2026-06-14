package com.example.laba1_shelgerman;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ConverterController {

    @FXML
    private TextField inputField;

    @FXML
    private ComboBox<String> fromComboBox;

    @FXML
    private ComboBox<String> toComboBox;

    @FXML
    private Label resultLabel;

    @FXML
    private Label errorLabel;

    @FXML
    public void initialize() {

        fromComboBox.setItems(
                FXCollections.observableArrayList(
                        "Часы",
                        "Минуты",
                        "Дни",
                        "Недели",
                        "Рабочие часы",
                        "Рабочие дни"
                )
        );

        toComboBox.setItems(
                FXCollections.observableArrayList(
                        "Часы",
                        "Минуты",
                        "Дни",
                        "Недели",
                        "Рабочие часы",
                        "Рабочие дни"
                )
        );
    }

    @FXML
    private void handleConvert() {

        errorLabel.setText("");
        resultLabel.setText("");

        String input = inputField.getText();

        if (InputValidator.isEmpty(input)) {
            errorLabel.setText("Поле не может быть пустым");
            return;
        }

        if (!InputValidator.isNumeric(input)) {
            errorLabel.setText("Разрешено вводить только цифры");
            return;
        }

        if (!InputValidator.isPositive(input)) {
            errorLabel.setText("Число должно быть больше 0");
            return;
        }

        if (!InputValidator.isWithinMaxValue(input, 999)) {
            errorLabel.setText("Слишком большое значение");
            return;
        }

        String from = fromComboBox.getValue();
        String to = toComboBox.getValue();

        if (from == null || to == null) {
            errorLabel.setText("Выберите единицы измерения");
            return;
        }

        double value = Double.parseDouble(input);
        double result = 0;


        if (from.equals("Часы") && to.equals("Минуты")) {
            result = value * 60;
        }


        else if (from.equals("Минуты") && to.equals("Часы")) {
            result = value / 60;
        }

        else if (from.equals("Дни") && to.equals("Недели")) {
            result = value / 7;
        }

        else if (from.equals("Недели") && to.equals("Дни")) {
            result = value * 7;
        }

        else if (from.equals("Рабочие часы")
                && to.equals("Рабочие дни")) {
            result = value / 8;
        }

        else if (from.equals("Рабочие дни")
                && to.equals("Рабочие часы")) {
            result = value * 8;
        }

        else if (from.equals(to)) {
            result = value;
        }

        else {
            errorLabel.setText("Такое преобразование не поддерживается");
            return;
        }

        resultLabel.setText(
                String.format("Результат: %.1f", result)
        );
    }
}