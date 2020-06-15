package ir.ac.kntu;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.*;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.*;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public static void playLevel1(List<Defender> alldefender,int numberOfDefenders) {
        int money=100;
        List<Item> items=new ArrayList<>();
        items.add(Item.CONTAINER);
        items.add(Item.TRUCK);
        Scanner scanner=new Scanner(System.in);
        List<Defender> defenderList=new ArrayList<>();
        System.out.println("_________________________________________________________________________________");
        for(int i=0;i<alldefender.size();i++){
            System.out.println((i+1)+alldefender.get(i).toString());
        }
        System.out.println("_________________________________________________________________________________");
        System.out.println("Enter the number of soldiers that you want start with!(the number should be between 1-16)");
        for(int i=0;i<numberOfDefenders;i++){
            int choice=scanner.nextInt();
            defenderList.add(alldefender.get(choice-1));
        }
        System.out.println("Do you want to update soldiers?(Answer should be a boolean)");
        boolean answer=scanner.nextBoolean();
        while(answer==true){
            System.out.println("_________________________________________________________________________________");
            for(int i=0;i<defenderList.size();i++){
                System.out.println((i+1)+defenderList.get(i).toString());
            }
            System.out.println("_________________________________________________________________________________");
            System.out.println("Enter the number of the soldier that you want to update:");
            int number=scanner.nextInt();
            if(money>=(defenderList.get(number-1).getLevel()*10)){
                money-=defenderList.get(number-1).getLevel()*10;
                defenderList.get(number-1).setLevel(defenderList.get(number-1).getLevel()+1);
                defenderList.get(number-1).setHealth(104*defenderList.get(number-1).getHealth()/100);
                defenderList.get(number-1).setAttack(104*defenderList.get(number-1).getAttack()/100);
            }else{
                System.out.println("You don't have enough money!");
            }
            System.out.println("Do you want to update soldiers?(Answer should be a boolean)");
            answer=scanner.nextBoolean();
        }
        System.out.println("Do you want to update items?(Answer should be a boolean)");
        boolean ans=scanner.nextBoolean();
        while(ans==true) {
            System.out.println("_________________________________________________________________________________");
            for (int i = 0; i < items.size(); i++) {
                System.out.println((i + 1) + items.get(i).toString());
            }
            System.out.println("_________________________________________________________________________________");
            System.out.println("Enter the number of the item that you want to update:");
            int num = scanner.nextInt();
            if (money >= (items.get(num - 1).getLevel() * 100)) {
                money -= items.get(num - 1).getLevel() * 100;
                items.get(num - 1).setLevel(items.get(num - 1).getLevel() + 1);
                items.get(num - 1).setDurability(110 * items.get(num - 1).getDurability() / 100);
            } else {
                System.out.println("You don't have enough money!");
            }
            System.out.println("Do you want to update items?(Answer should be a boolean)");
            ans = scanner.nextBoolean();
        }
    }
    @Override
    public void start(Stage stage) throws Exception {

        List<Enemy> allEnemy=new ArrayList<>();
        allEnemy.add(new Enemy("RedSoldier",1000,500,1,3));
        allEnemy.add(new Enemy("GraySoldier",1000,800,1,2));
        allEnemy.add(new Enemy("YellowSoldier",800,1500,2,2));
        allEnemy.add(new Enemy("GreenSoldier",1500,700,1,2));
        allEnemy.add(new Enemy("BossLevel1",8000,5000,1,2));
        allEnemy.add(new Enemy("GoldSoldier",800,2000,5,1));
        allEnemy.add(new Enemy("BossLevel2",20000,12000,1,2));

        List<Defender> alldefender=new ArrayList<>();
        alldefender.add(new Defender("GoroMajima",4000,4500,3,4,4));
        alldefender.add(new Defender("DaigoDojima",4000,4000,1,2,4));
        alldefender.add(new Defender("KaoruSayama",4500,4500,2,4,4));
        alldefender.add(new Defender("TaigaSaejima",7000,5000,1,1,4));
        alldefender.add(new Defender("SoheiDojima",3000,3000,1,1,5));
        alldefender.add(new Defender("KojiShidno",3800,3600,1,1,5));
        alldefender.add(new Defender("SotaroKomaki",2800,5000,3,1,5));
        alldefender.add(new Defender("ShintaroKazama",4500,4500,2,1,5));
        alldefender.add(new Defender("RyuijiGoda",5000,5000,1,2,4));
        alldefender.add(new Defender("OsamuKashiwagi",4000,3000,2,1,4));
        alldefender.add(new Defender("MakotoDate",4500,1800,2,3,4));
        alldefender.add(new Defender("FutoshiShimano",4200,4000,2,1,4));
        alldefender.add(new Defender("RyoTakashima",3600,3800,1,1,5));
        alldefender.add(new Defender("YukioTerada",4000,3000,1,1,5));
        alldefender.add(new Defender("JiroKawara",5500,3200,3,3,5));
        alldefender.add(new Defender("TestuTachibana",5600,4000,2,1,5));

        Scanner scanner=new Scanner(System.in);
        System.out.println("How many defenders are you going to choose?(between 1-10)");
        int numberOfDefenders=scanner.nextInt();
        if(numberOfDefenders<11 && numberOfDefenders>0) {
            playLevel1(alldefender, numberOfDefenders);
        }else{
            System.out.println("Invalid input");
        }

        /////////////////////////////

        Group root = new Group();
        Scene scene = new Scene(root, 1380, 720, false, SceneAntialiasing.BALANCED);
        stage.setScene(scene);
        Camera camera = new ParallelCamera();
        scene.setCamera(camera);
        stage.setTitle("Once Upon a Time in Kamurocho!");
        Rectangle enemyArea=new Rectangle(200,680,Color.GREY);
        enemyArea.setX(20);
        enemyArea.setY(20);
        Rectangle item1=new Rectangle(80,130,Color.ORANGE);
        item1.setX(1250);
        item1.setY(100);
        Rectangle item2=new Rectangle(80,130,Color.ORANGE);
        item2.setX(1250);
        item2.setY(470);
        Rectangle border1=new Rectangle(10,100,Color.RED);
        border1.setX(800);
        border1.setY(0);
        Rectangle border2=new Rectangle(10,100,Color.RED);
        border2.setX(800);
        border2.setY(200);
        Rectangle border3=new Rectangle(10,100,Color.RED);
        border3.setX(800);
        border3.setY(400);
        Rectangle border4=new Rectangle(10,100,Color.RED);
        border4.setX(800);
        border4.setY(600);
        Rectangle rectangle = new Rectangle(20, 20, Color.web("0x01abff"));
        rectangle.setX(400);
        rectangle.setY(400);
        for(int i=0;i<numberOfDefenders;i++){
            Circle defender=new Circle(30,Color.PINK);
            int randomX=RandomHelper.nextInt(400)+780;
            int randomY=RandomHelper.nextInt(670)+30;
            defender.setCenterX(randomX);
            defender.setCenterY(randomY);
            root.getChildren().add(defender);
            defender.addEventHandler(MouseEvent.MOUSE_EXITED, e -> {
                double dx = e.getX() - defender.getCenterX();
                double dy = e.getY() - defender.getCenterY();
                defender.setCenterX(defender.getCenterX() + dx);
                defender.setCenterY(defender.getCenterY() + dy);
            });
        }
        scene.addEventHandler(MouseEvent.MOUSE_MOVED, e -> {
            rectangle.setX(e.getX() - 20);
            rectangle.setY(e.getY() - 20);
        });
        scene.addEventFilter(MouseEvent.MOUSE_MOVED, e -> {
            if (e.isAltDown()) {
                e.consume();
            }
        });
        new AnimationTimer() {
            @Override
            public void handle(long l) {
                rectangle.setRotate(rectangle.getRotate() + 5);
            }
        }.start();
        Timer timer = new Timer();
        ProgressBar progressBar = new ProgressBar();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> progressBar.setProgress(progressBar.getProgress() + 0.1));
            }
        };
        stage.addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, e -> e.consume());
        timer.schedule(task, 1000, 500);
        root.getChildren().addAll( rectangle, progressBar,item1,item2,enemyArea,border1,border2,border3,border4);
        stage.setResizable(false);
        scene.setFill(Color.DARKGRAY);
        stage.show();
    }
}