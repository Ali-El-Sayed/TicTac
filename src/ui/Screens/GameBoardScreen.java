package ui.Screens;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ui.SceneController;
import ui.components.GameButton;

public class GameBoardScreen extends StackPane {

  protected final ImageView backGroundImage;
  public final GridPane gridPane;
  protected final ColumnConstraints columnConstraints;
  protected final ColumnConstraints columnConstraints0;
  protected final ColumnConstraints columnConstraints1;
  protected final RowConstraints rowConstraints;
  protected final RowConstraints rowConstraints0;
  protected final RowConstraints rowConstraints1;
  protected final RowConstraints rowConstraints2;
  protected final RowConstraints rowConstraints3;
  protected final Button boardButton8;
  protected final Button boardButton9;
  protected final Button boardButton5;
  protected final Button boardButton6;
  protected final Button boardButton4;
  protected final Button boardButton1;
  protected final Button boardButton3;
  protected final Button boardButton2;
  protected final Button boardButton7;
  protected final Button back_btn;
  protected final Button reset_btn;
  protected final HBox hBoxPlayer1;
  protected final Label Player1Symbol;
  protected final Label Player1NameAndScore;
  protected final HBox hBoxPlayer2;
  protected final Label Player2Symbol;
  protected final Label player2NameAndScore;
  protected int[][] winProbabilities;
  protected boolean isX = true;
  protected String str;
  protected String str1;
  protected Socket cs;
  protected DataInputStream dataInputStream;
  protected BufferedReader ear;
  protected PrintStream mouth;
  protected Button btn;

  HashMap<Integer, String> checkedBtns = new HashMap();
  Socket socket;

  public GameBoardScreen(Stage s) {
    initializeConnection();

    backGroundImage = new ImageView();
    gridPane = new GridPane();
    columnConstraints = new ColumnConstraints();
    columnConstraints0 = new ColumnConstraints();
    columnConstraints1 = new ColumnConstraints();
    rowConstraints = new RowConstraints();
    rowConstraints0 = new RowConstraints();
    rowConstraints1 = new RowConstraints();
    rowConstraints2 = new RowConstraints();
    rowConstraints3 = new RowConstraints();
    boardButton8 = new Button();
    boardButton9 = new Button();
    boardButton5 = new Button();
    boardButton6 = new Button();
    boardButton4 = new Button();
    boardButton1 = new Button();
    boardButton3 = new Button();
    boardButton2 = new Button();
    boardButton7 = new Button();
    back_btn = new GameButton("Exit game", GameButton.Mode.BACK);
    reset_btn = new GameButton("New Game", GameButton.Mode.BACK);
    hBoxPlayer1 = new HBox();
    Player1Symbol = new Label();
    Player1NameAndScore = new Label();
    hBoxPlayer2 = new HBox();
    Player2Symbol = new Label();
    player2NameAndScore = new Label();

    winProbabilities = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 4, 7 }, { 2, 5, 8 }, { 3, 6, 9 },
        { 1, 5, 9 }, { 3, 5, 7 } };

    setMaxHeight(858.0);
    setMaxWidth(1343.0);
    setMinHeight(USE_PREF_SIZE);
    setMinWidth(USE_PREF_SIZE);
    setPrefHeight(858.0);
    setPrefWidth(1343.0);
    backGroundImage.setFitHeight(858.0);
    backGroundImage.setFitWidth(1343.0);
    backGroundImage.setPickOnBounds(true);
    backGroundImage.setImage(new Image(getClass().getResource("/assets/grid.png").toExternalForm()));

    columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
    columnConstraints.setMaxWidth(528.0);
    columnConstraints.setMinWidth(10.0);
    columnConstraints.setPrefWidth(524.0);

    columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
    columnConstraints0.setMaxWidth(443.0);
    columnConstraints0.setMinWidth(10.0);
    columnConstraints0.setPrefWidth(288.0);

    columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
    columnConstraints1.setMaxWidth(537.0);
    columnConstraints1.setMinWidth(10.0);
    columnConstraints1.setPrefWidth(531.0);

    rowConstraints.setMaxHeight(207.0);
    rowConstraints.setMinHeight(8.0);
    rowConstraints.setPrefHeight(8.0);
    rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

    rowConstraints0.setMaxHeight(207.0);
    rowConstraints0.setMinHeight(10.0);
    rowConstraints0.setPrefHeight(127.0);
    rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

    rowConstraints1.setMaxHeight(344.0);
    rowConstraints1.setMinHeight(10.0);
    rowConstraints1.setPrefHeight(214.0);
    rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

    rowConstraints2.setMaxHeight(374.0);
    rowConstraints2.setMinHeight(10.0);
    rowConstraints2.setPrefHeight(267.0);
    rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

    rowConstraints3.setMaxHeight(256.0);
    rowConstraints3.setMinHeight(10.0);
    rowConstraints3.setPrefHeight(244.0);
    rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

    GridPane.setColumnIndex(boardButton8, 1);
    GridPane.setHalignment(boardButton8, javafx.geometry.HPos.CENTER);
    GridPane.setRowIndex(boardButton8, 4);
    GridPane.setValignment(boardButton8, javafx.geometry.VPos.TOP);
    boardButton8.setMnemonicParsing(false);
    boardButton8.setPrefHeight(166.0);
    boardButton8.setPrefWidth(176.0);
    boardButton8.setStyle("-fx-background-color: transparent;");
    boardButton8.setText("");
    boardButton8.setTextFill(javafx.scene.paint.Color.valueOf("#234d20"));
    GridPane.setMargin(boardButton8, new Insets(0.0));
    boardButton8.setFont(new Font("Arial Rounded MT Bold", 110.0));

    GridPane.setColumnIndex(boardButton9, 2);
    GridPane.setHalignment(boardButton9, javafx.geometry.HPos.LEFT);
    GridPane.setRowIndex(boardButton9, 4);
    GridPane.setValignment(boardButton9, javafx.geometry.VPos.TOP);
    boardButton9.setMnemonicParsing(false);
    boardButton9.setPrefHeight(166.0);
    boardButton9.setPrefWidth(176.0);
    boardButton9.setStyle("-fx-background-color: transparent;");
    boardButton9.setText("");
    boardButton9.setTextFill(javafx.scene.paint.Color.valueOf("#234d20"));
    GridPane.setMargin(boardButton9, new Insets(0.0));
    boardButton9.setFont(new Font("Arial Rounded MT Bold", 110.0));

    GridPane.setColumnIndex(boardButton5, 1);
    GridPane.setHalignment(boardButton5, javafx.geometry.HPos.CENTER);
    GridPane.setRowIndex(boardButton5, 3);
    GridPane.setValignment(boardButton5, javafx.geometry.VPos.CENTER);
    boardButton5.setMnemonicParsing(false);
    boardButton5.setPrefHeight(166.0);
    boardButton5.setPrefWidth(176.0);
    boardButton5.setStyle("-fx-background-color: transparent;");
    boardButton5.setText("");
    boardButton5.setTextFill(javafx.scene.paint.Color.valueOf("#234d20"));
    boardButton5.setFont(new Font("Arial Rounded MT Bold", 110.0));

    GridPane.setColumnIndex(boardButton6, 2);
    GridPane.setHalignment(boardButton6, javafx.geometry.HPos.LEFT);
    GridPane.setRowIndex(boardButton6, 3);
    GridPane.setValignment(boardButton6, javafx.geometry.VPos.CENTER);
    boardButton6.setMnemonicParsing(false);
    boardButton6.setPrefHeight(166.0);
    boardButton6.setPrefWidth(176.0);
    boardButton6.setStyle("-fx-background-color: transparent;");
    boardButton6.setText("");
    boardButton6.setTextFill(javafx.scene.paint.Color.valueOf("#234d20"));
    GridPane.setMargin(boardButton6, new Insets(0.0));
    boardButton6.setFont(new Font("Arial Rounded MT Bold", 110.0));

    GridPane.setHalignment(boardButton4, javafx.geometry.HPos.RIGHT);
    GridPane.setRowIndex(boardButton4, 3);
    boardButton4.setMnemonicParsing(false);
    boardButton4.setPrefHeight(166.0);
    boardButton4.setPrefWidth(176.0);
    boardButton4.setStyle("-fx-background-color: transparent;");
    boardButton4.setText("");
    boardButton4.setTextFill(javafx.scene.paint.Color.valueOf("#234d20"));
    GridPane.setMargin(boardButton4, new Insets(0.0));
    boardButton4.setFont(new Font("Arial Rounded MT Bold", 110.0));

    GridPane.setHalignment(boardButton1, javafx.geometry.HPos.RIGHT);
    GridPane.setRowIndex(boardButton1, 2);
    GridPane.setValignment(boardButton1, javafx.geometry.VPos.BOTTOM);
    boardButton1.setMnemonicParsing(false);
    boardButton1.setPrefHeight(166.0);
    boardButton1.setPrefWidth(176.0);
    boardButton1.setStyle("-fx-background-color: transparent;");
    boardButton1.setText("");
    boardButton1.setTextFill(javafx.scene.paint.Color.valueOf("#234d20"));
    GridPane.setMargin(boardButton1, new Insets(0.0));
    boardButton1.setFont(new Font("Arial Rounded MT Bold", 110.0));

    GridPane.setColumnIndex(boardButton3, 2);
    GridPane.setHalignment(boardButton3, javafx.geometry.HPos.LEFT);
    GridPane.setRowIndex(boardButton3, 2);
    GridPane.setValignment(boardButton3, javafx.geometry.VPos.BOTTOM);
    boardButton3.setMnemonicParsing(false);
    boardButton3.setPrefHeight(166.0);
    boardButton3.setPrefWidth(176.0);
    boardButton3.setStyle("-fx-background-color: transparent;");
    boardButton3.setText("");
    boardButton3.setTextFill(javafx.scene.paint.Color.valueOf("#234d20"));
    GridPane.setMargin(boardButton3, new Insets(0.0));
    boardButton3.setFont(new Font("Arial Rounded MT Bold", 110.0));

    GridPane.setColumnIndex(boardButton2, 1);
    GridPane.setHalignment(boardButton2, javafx.geometry.HPos.CENTER);
    GridPane.setRowIndex(boardButton2, 2);
    GridPane.setValignment(boardButton2, javafx.geometry.VPos.BOTTOM);
    boardButton2.setMnemonicParsing(false);
    boardButton2.setPrefHeight(166.0);
    boardButton2.setPrefWidth(176.0);
    boardButton2.setStyle("-fx-background-color: transparent;");
    boardButton2.setText("");
    boardButton2.setTextFill(javafx.scene.paint.Color.valueOf("#234d20"));
    GridPane.setMargin(boardButton2, new Insets(0.0));
    boardButton2.setFont(new Font("Arial Rounded MT Bold", 110.0));

    GridPane.setHalignment(boardButton7, javafx.geometry.HPos.RIGHT);
    GridPane.setRowIndex(boardButton7, 4);
    GridPane.setValignment(boardButton7, javafx.geometry.VPos.TOP);
    boardButton7.setMnemonicParsing(false);
    boardButton7.setPrefHeight(166.0);
    boardButton7.setPrefWidth(176.0);
    boardButton7.setStyle("-fx-background-color: transparent;");
    boardButton7.setText("");
    boardButton7.setTextFill(javafx.scene.paint.Color.valueOf("#234d20"));
    boardButton7.setFont(new Font("Arial Rounded MT Bold", 110.0));

    // back_btn.setLayoutX(400);
    // back_btn.setLayoutY(300);
    // reset_btn.setLayoutX(100);
    reset_btn.setLayoutY(300);
    GridPane.setRowIndex(hBoxPlayer1, 1);
    hBoxPlayer1.setPrefHeight(100.0);
    hBoxPlayer1.setPrefWidth(542.0);
    hBoxPlayer1.setSpacing(5.0);

    Player1Symbol.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
    Player1Symbol.setPrefHeight(92.0);
    Player1Symbol.setPrefWidth(98.0);
    Player1Symbol.setText("X");

    Player1Symbol.setTextFill(javafx.scene.paint.Color.valueOf("#234d20"));
    Player1Symbol.setPadding(new Insets(0.0, 15.0, 0.0, 0.0));
    Player1Symbol.setFont(new Font("System Bold", 36.0));
    Player1Symbol.setOpaqueInsets(new Insets(0.0));

    Player1NameAndScore.setPrefHeight(92.0);
    Player1NameAndScore.setPrefWidth(358.0);
    Player1NameAndScore.setStyle("-fx-background-color: #68C8A7; -fx-background-radius: 25px;");
    Player1NameAndScore.setText("Player 1: 0");
    Player1NameAndScore.setTextFill(javafx.scene.paint.Color.valueOf("#187135"));
    Player1NameAndScore.setFont(new Font("Berlin Sans FB Bold", 50.0));
    Player1NameAndScore.setPadding(new Insets(0.0, 0.0, 0.0, 20.0));

    GridPane.setColumnIndex(hBoxPlayer2, 2);
    GridPane.setRowIndex(hBoxPlayer2, 1);
    hBoxPlayer2.setPrefHeight(100.0);
    hBoxPlayer2.setPrefWidth(542.0);
    hBoxPlayer2.setSpacing(5.0);

    Player2Symbol.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
    Player2Symbol.setPrefHeight(92.0);
    Player2Symbol.setPrefWidth(129.0);
    Player2Symbol.setText("O");
    Player2Symbol.setTextFill(javafx.scene.paint.Color.valueOf("#234d20"));
    Player2Symbol.setFont(new Font("Arial Rounded MT Bold", 42.0));
    Player2Symbol.setPadding(new Insets(0.0, 15.0, 0.0, 0.0));

    player2NameAndScore.setPrefHeight(92.0);
    player2NameAndScore.setPrefWidth(344.0);
    player2NameAndScore.setStyle("-fx-background-color: #68C8A7; -fx-background-radius: 25px;");
    player2NameAndScore.setText("PC : 0");
    player2NameAndScore.setTextFill(javafx.scene.paint.Color.valueOf("#187135"));
    player2NameAndScore.setFont(new Font("Berlin Sans FB Bold", 50.0));
    player2NameAndScore.setPadding(new Insets(0.0, 0.0, 0.0, 20.0));

    getChildren().add(backGroundImage);
    gridPane.getColumnConstraints().add(columnConstraints);
    gridPane.getColumnConstraints().add(columnConstraints0);
    gridPane.getColumnConstraints().add(columnConstraints1);
    gridPane.getRowConstraints().add(rowConstraints);
    gridPane.getRowConstraints().add(rowConstraints0);
    gridPane.getRowConstraints().add(rowConstraints1);
    gridPane.getRowConstraints().add(rowConstraints2);
    gridPane.getRowConstraints().add(rowConstraints3);
    gridPane.getChildren().add(boardButton1);
    gridPane.getChildren().add(boardButton2);
    gridPane.getChildren().add(boardButton3);
    gridPane.getChildren().add(boardButton4);
    gridPane.getChildren().add(boardButton5);
    gridPane.getChildren().add(boardButton6);
    gridPane.getChildren().add(boardButton7);
    gridPane.getChildren().add(boardButton8);
    gridPane.getChildren().add(boardButton9);
    hBoxPlayer1.getChildren().add(Player1Symbol);
    hBoxPlayer1.getChildren().add(Player1NameAndScore);
    gridPane.getChildren().add(hBoxPlayer1);
    hBoxPlayer2.getChildren().add(Player2Symbol);
    hBoxPlayer2.getChildren().add(player2NameAndScore);
    gridPane.getChildren().add(hBoxPlayer2);
    getChildren().add(gridPane);
    gridPane.getChildren().add(back_btn);
    gridPane.getChildren().add(reset_btn);
    gridPane.setMargin(reset_btn, new Insets(500.0, 0.0, -1120.0, 150.0));
    gridPane.setMargin(back_btn, new Insets(500.0, 0.0, -1120.0, 0.0));

    for (Node node : gridPane.getChildren()) {
      if (node.getClass() == Button.class) {
        btn = (Button) node;
        btn.setOnAction((ActionEvent event) -> {
          Integer btn1 = gridPane.getChildren().indexOf(node);
          if (isX) {
            str1 = "X";
          } else {
            str1 = "O";
          }
          checkedBtns.put(btn1 + 1, str1);
          try {
            handleTurn(event);
          } catch (IOException ex) {
            Logger.getLogger(GameBoardScreen.class.getName()).log(Level.SEVERE, null, ex);
          }
          if (isWinner()) {
            handleGameOver(event);
          }

        });

      }
      ;
    }
    back_btn.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        for (int i = 0; i < checkedBtns.size(); i++) {
          checkedBtns.remove(i);
        }

        try {
          Socket socket = new Socket("127.0.0.1", 5005);
          ear = new DataInputStream(socket.getInputStream());
          mouth = new PrintStream(socket.getOutputStream());

        } catch (IOException ex) {
          Logger.getLogger(GameBoardScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        new Thread() {
          @Override
          public void run() {
            while (true) {
              try {
                String str = ear.readLine();
                Platform.runLater(() -> {
                  System.out.println("received from server" + str);

                });
              } catch (IOException ex) {
                Logger.getLogger(GameBoardScreen.class.getName()).log(Level.SEVERE, null, ex);
              }
            }
          }

        }.start();

        SceneController sc = new SceneController();
        try {
          sc.switchToSplashScreen(event);
        } catch (IOException ex) {
          Logger.getLogger(GameBoardScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    });
    reset_btn.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        for (int i = 0; i < checkedBtns.size(); i++) {
          checkedBtns.remove(i);
        }

        SceneController sc = new SceneController();
        try {
          sc.switchToGameBoard(event);
        } catch (IOException ex) {
          Logger.getLogger(GameBoardScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    });
  }

  private void initializeConnection() {
    new Thread(() -> {
      try {
        cs = new Socket("127.0.0.1", 5000);
        dataInputStream = new DataInputStream(cs.getInputStream());
        ear = new BufferedReader(new InputStreamReader(dataInputStream));
        mouth = new PrintStream(cs.getOutputStream());
        while (true) {
          if (cs.isConnected()) {
            System.out.println(cs.getLocalAddress());
            System.out.println(ear.readLine());
          }
        }
      } catch (IOException ex) {
        Logger.getLogger(GameBoardScreen.class.getName()).log(Level.SEVERE, null, ex);
      }
    }).start();
  }

  private void handleTurn(ActionEvent event) throws IOException {
    btn = (Button) event.getTarget();

    btn.setText(str1);
    mouth.println(btn.getText());

    isX = !isX;
    btn.setOnAction((e) -> {
    });
  }

  protected boolean isWinner() {
    for (int[] winCase : winProbabilities) {
      if (checkedBtns.getOrDefault(winCase[0], "A").equals(checkedBtns.getOrDefault(winCase[1], "B"))
          && checkedBtns.getOrDefault(winCase[0], "D").equals(checkedBtns.getOrDefault(winCase[2], "D"))) {

        handleWinner(winCase);
        return true;
      }
    }

    private void handleTurn(ActionEvent event) throws IOException {
        btn = (Button) event.getTarget();

        mouth.println(btn.getText());
        btn.setText(str1);
        System.out.println(str1);
        isX = !isX;
        btn.setOnAction((e) -> {
        });
    }

    private boolean isWinner() {
        for (int[] winCase : winProbabilities) {
            if (checkedBtns.getOrDefault(winCase[0], "A").equals(checkedBtns.getOrDefault(winCase[1], "B"))
                    && checkedBtns.getOrDefault(winCase[0], "D").equals(checkedBtns.getOrDefault(winCase[2], "D"))) {
                handleWinner(winCase);
                return true;
            }
        }

        return false;

    }

    private void handleGameOver(ActionEvent e) {
    }

    return false;

  }

  protected void handleGameOver(ActionEvent e) {

    try {
      new SceneController().switchToVideoScreen(e);
    } catch (IOException ex) {
      Logger.getLogger(GameBoardScreen.class.getName()).log(Level.SEVERE, null, ex);

    }
  }

  protected void handleWinner(int[] winCase) {
    for (int i : winCase) {
      Button btn = (Button) gridPane.getChildren().get(i - 1);
      btn.setTextFill(Color.WHITE);

    }

  }

}