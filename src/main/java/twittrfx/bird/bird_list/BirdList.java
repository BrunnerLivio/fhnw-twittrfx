package twittrfx.bird.bird_list;

import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import twittrfx.ViewMixin;
import twittrfx.bird.BirdPM;

public class BirdList extends VBox implements ViewMixin {
  private final BirdListPM model;
  private TableView<BirdPM> table;
  private Text title;

  public BirdList(BirdListPM model) {
    this.model = model;
    init();
  }

  private TableView<BirdPM> initializeTable() {
    TableView<BirdPM> tableView = new TableView<>(model.getBirds());
    TableColumn<BirdPM, String> nameColumn = new TableColumn<>("Name");
    nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

    TableColumn<BirdPM, String> populationTrend = new TableColumn<>("Population trend");
    populationTrend.setCellValueFactory(cellData -> cellData.getValue().populationTrendProperty());

    TableColumn<BirdPM, String> populationStatus = new TableColumn<>("Population Status");
    populationStatus.setCellValueFactory(cellData -> cellData.getValue().populationStatusProperty());

    tableView.getColumns().addAll(nameColumn, populationTrend, populationStatus);

    return tableView;
  }

  @Override
  public void initializeControls() {
    table = this.initializeTable();
    title = new Text("Birds of Switzerland");
  }

  @Override
  public void layoutControls() {
    setPadding(new Insets(10));
    setVgrow(table, Priority.ALWAYS);
    title.getStyleClass().add("title");

    getChildren().addAll(title, table);
  }

  @Override
  public void setupEventHandlers() {
  }

  @Override
  public void setupValueChangedListeners() {
    // model.getElements().addListener((ListChangeListener<String>) c -> {
    // while (c.next()) {
    // listView.scrollTo(c.getFrom());
    // }
    // });
  }

  @Override
  public void setupBindings() {
  }
}
