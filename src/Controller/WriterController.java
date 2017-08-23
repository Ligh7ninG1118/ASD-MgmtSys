package Controller;

import DAO.ArticleDAO;
import DAO.UserDAO;
import MgmtSys.Main;
import Util.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Article;
import model.User;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

import static MgmtSys.Main.WriterViewID;

public class WriterController implements ControlledStage, Initializable
{
    StageController myController;
    Logger myLogger = new Logger();
    User user = null;
    ArticleDAO adao = new ArticleDAO();
    UserDAO udao = new UserDAO();
    @FXML
    private RadioButton rbtn_eula;

    @FXML
    private DatePicker birthdayDatePicker;

    @FXML
    private ChoiceBox subcommitCBox;
    @FXML
    private ChoiceBox commitCBox;
    @FXML
    private ChoiceBox searchTypeCBox;
    @FXML
    private ChoiceBox sexCBox;

    @FXML
    private TextField searchTextField;
    @FXML
    private TextField articleTitleTextField;
    @FXML
    private TextArea articleContentTextArea;
    @FXML
    private TextField oldpwTextField;
    @FXML
    private TextField newpwTextField;
    @FXML
    private TextField repwTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField commTextField;
    @FXML
    private TextField addressTextField;


    @FXML
    private TableColumn colId;
    @FXML
    private TableColumn colTitle;
    @FXML
    private TableColumn colAuthor;
    @FXML
    private TableColumn colDeadlineDate;
    @FXML
    private TableColumn colStatus;
    @FXML
    private TableColumn colYay;
    @FXML
    private TableColumn colNay;
    @FXML
    private TableView searchResult;

    @FXML
    private Label nametag;


    public void setStageController(StageController stageController)
    {
        this.myController = stageController;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        user = myLogger.requireUserInfo();
        nametag.setText("欢迎您, " + user.getLoginID());

        searchTypeCBox.getSelectionModel().selectFirst();
        colId.setCellValueFactory(new PropertyValueFactory("Id"));
        colTitle.setCellValueFactory(new PropertyValueFactory("Title"));
        colDeadlineDate.setCellValueFactory(new PropertyValueFactory("DeadlineDate"));
        colStatus.setCellValueFactory(new PropertyValueFactory("Status"));
        colYay.setCellValueFactory(new PropertyValueFactory("Yay"));
        colNay.setCellValueFactory(new PropertyValueFactory("Nay"));
        colAuthor.setCellValueFactory(new PropertyValueFactory("Authorname"));
    }


    public void editInfoTabAction(Event event)
    {
        resetInfo();
    }

    public void resetAction(Event event)
    {
        resetInfo();
    }

    private void resetInfo()
    {
        nameTextField.setText(user.getName());
        sexCBox.setValue(user.getSex());
        commTextField.setText(user.getComm());
        addressTextField.setText(user.getAddress());
        birthdayDatePicker.setValue(user.getBirthday().toLocalDate());
    }

    public void editAction(Event event)
    {
        user.setSex(sexCBox.getValue().toString());
        udao.updateUser(user);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("更改成功");
        alert.setHeaderText(null);
        alert.setContentText("您的个人信息已更改成功，特殊信息请等待管理员审核后方可生效");
        alert.showAndWait();
        resetInfo();
        return;

    }

    public void signoffAction(Event event)
    {
        /**
         * Log表删除登录记录
         */
        myController.setStage(Main.loginViewID, WriterViewID);
    }

    public void searchAction(Event event)
    {
        ObservableList<Article> list = FXCollections.observableArrayList();
        String key = searchTextField.getText();
        int mode = modeCheck();

        for (Article temp : adao.queryArticles(key, mode))
        {
            list.add(temp);
        }
        searchResult.setItems(list);

    }

    public void submitAction(Event event)
    {
        if (!rbtn_eula.isSelected())
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("提交失败");
            alert.setHeaderText(null);
            alert.setContentText("请阅读提案建议要求");
            alert.showAndWait();
            return;
        }
        Article temp = new Article();
        temp.setAuthor(user);
        temp.setTitle(articleTitleTextField.getText());
        temp.setContent(articleContentTextArea.getText());
        temp.setSubmiteDate(Date.valueOf(LocalDate.now()));
        temp.setStatus(false);
        temp.setYay(0);
        temp.setNay(0);
        temp.setArticleType(0);

        adao.addArticle(temp);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("提交成功");
        alert.setHeaderText(null);
        alert.setContentText("您的提案已经提交成功");
        alert.showAndWait();
    }

    public void saveAction(Event event)
    {
/*
        节约空间 此处省略存储功能
         */
    }

    public void printAction(Event event)
    {
        /*
        节约纸张 此处省略打印功能
         */
    }

    private int modeCheck()
    {
        String lbl[] = new String[4];
        lbl[0] = "任意";
        lbl[1] = "作者";
        lbl[2] = "标题";
        lbl[3] = "编号";
        int cnt = 0;
        for (String temp : lbl)
        {
            cnt++;
            if (searchTypeCBox.getValue().toString().equals(temp))
                break;
        }
        return cnt;
    }

    public void clearRecordAction(ActionEvent actionEvent)
    {
        searchTextField.clear();
    }
}
