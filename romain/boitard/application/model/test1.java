package romain.boitard.application.model;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class test1 extends Application {

    public static List<StationView> circles = new ArrayList<StationView>();
    

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
    	
    	

        Group root = new Group();

        Canvas canvas = new Canvas(300, 300);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawShapes(gc);

        StationView circle1 = new StationView(50, new Station("Sp1", "Sp", 5, 10));
        circle1.setStroke(Color.GREEN);
        circle1.setFill(Color.GREEN.deriveColor(1, 1, 1, 0.7));
        circle1.relocate(100, 100);

        StationView circle2 = new StationView(50, new Station("Sp2", "Sp", 5, 10));
        circle2.setStroke(Color.BLUE);
        circle2.setFill(Color.BLUE.deriveColor(1, 1, 1, 0.7));
        circle2.relocate(200, 200);

        Line line = new Line(circle1.getLayoutX(), circle1.getLayoutY(), circle2.getLayoutX(), circle2.getLayoutY());
        line.setStrokeWidth(20);

        Pane overlay = new Pane();
        overlay.getChildren().addAll(circle1, circle2, line);

        MouseGestures mg = new MouseGestures();
        mg.makeDraggable(circle1);
        mg.makeDraggable(circle2);
        mg.makeDraggable(line);

        root.getChildren().addAll(canvas, overlay);

        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
    
   

    private void drawShapes(GraphicsContext gc) {
        gc.setStroke(Color.RED);
        gc.strokeRoundRect(10, 10, 230, 230, 10, 10);
    }

    public static class MouseGestures {

        double orgSceneX, orgSceneY;
        double orgTranslateX, orgTranslateY;

        public void makeDraggable(Node node) {
            node.setOnMousePressed(circleOnMousePressedEventHandler);
            node.setOnMouseDragged(circleOnMouseDraggedEventHandler);
        }

        EventHandler<MouseEvent> circleOnMousePressedEventHandler = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {

                orgSceneX = t.getSceneX();
                orgSceneY = t.getSceneY();

                if (t.getSource() instanceof StationView) {

                	StationView p = ((StationView) (t.getSource()));
                	System.out.println(p.getStation().getName());

                    orgTranslateX = p.getCenterX();
                    orgTranslateY = p.getCenterY();

                } else {

                    Node p = ((Node) (t.getSource()));

                    orgTranslateX = p.getTranslateX();
                    orgTranslateY = p.getTranslateY();

                }
            }
        };

        EventHandler<MouseEvent> circleOnMouseDraggedEventHandler = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {

                double offsetX = t.getSceneX() - orgSceneX;
                double offsetY = t.getSceneY() - orgSceneY;

                double newTranslateX = orgTranslateX + offsetX;
                double newTranslateY = orgTranslateY + offsetY;

                if (t.getSource() instanceof Circle) {

                    Circle p = ((Circle) (t.getSource()));

                    p.setCenterX(newTranslateX);
                    p.setCenterY(newTranslateY);

                } else {

                    Node p = ((Node) (t.getSource()));

                    p.setTranslateX(newTranslateX);
                    p.setTranslateY(newTranslateY);

                }

            }
        };

    }

}