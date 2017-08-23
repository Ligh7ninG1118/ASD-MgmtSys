package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ArticleDetailController
{
    @FXML
    private RadioButton rbtn_Nay;
    @FXML
    private RadioButton rbtn_Yay;
    @FXML
    private Button btn_Cancel;
    @FXML
    private Button btn_Submit;

    @FXML
    private TextField articleIdTextField;
    @FXML
    private TextField articleTitleTextField;
    @FXML
    private TextField articleDeadlineDateTextField;
    @FXML
    private TextField articleAuthorTextField;
    @FXML
    private TextField commentTextField;

    @FXML
    private TextArea articleContentTextArea;

    public void initialize()
    {

    }
}
