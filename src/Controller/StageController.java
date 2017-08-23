package Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.HashMap;

public class StageController
{
    //建立一个专门存储Stage的Map，全部用于存放Stage对象
    private HashMap<String, Stage> stages = new HashMap<String, Stage>();


    public void addStage(String name, Stage stage)
    {
        stages.put(name, stage);
    }

    public Stage getStage(String name)
    {
        return stages.get(name);
    }

    public void setPrimaryStage(String primaryStageName, Stage primaryStage)
    {
        this.addStage(primaryStageName, primaryStage);
    }


    public boolean loadStage(String name, String resources)
    {
        try
        {
            //加载FXML资源文件
            FXMLLoader loader = new FXMLLoader(getClass().getResource(resources));
            Pane tempPane = (Pane) loader.load();

            //通过Loader获取FXML对应的ViewCtr，并将本StageController注入到ViewCtr中
            ControlledStage controlledStage = (ControlledStage) loader.getController();
            controlledStage.setStageController(this);

            //构造对应的Stage
            Scene tempScene = new Scene(tempPane);
            Stage tempStage = new Stage();
            tempStage.setScene(tempScene);


            //将设置好的Stage放到HashMap中
            this.addStage(name, tempStage);

            return true;
        } catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setStage(String name)
    {
        this.getStage(name).show();
        return true;
    }


    public boolean setStage(String show, String close)
    {

        getStage(close).close();
        setStage(show);
        return true;
    }


    public boolean unloadStage(String name)
    {
        if (stages.remove(name) == null)
        {
            System.out.println("窗口不存在，请检查名称");
            return false;
        } else
        {
            System.out.println("窗口移除成功");
            return true;
        }
    }
}
