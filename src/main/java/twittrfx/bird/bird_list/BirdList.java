package twittrfx.bird.bird_list;

import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import twittrfx.ViewMixin;
import twittrfx.bird.BirdPM;
import twittrfx.bird.bird_view.BirdViewPM;

public class BirdList extends VBox implements ViewMixin {
  private final BirdViewPM model;
  private TableView<BirdPM> table;
  private BirdListTitle birdListTitle;

  public BirdList(BirdViewPM model) {
    this.model = model;
    init();
  }

  @Override
  public void initializeSelf() {
    addStylesheetFiles("bird_list.css");
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
    birdListTitle = new BirdListTitle(model);
  }

  @Override
  public void layoutControls() {
    setPadding(new Insets(10));
    setVgrow(table, Priority.ALWAYS);

    getChildren().addAll(birdListTitle, table);
  }

  @Override
  public void setupEventHandlers() {
    table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
      model.setSelectedBird(newValue);
    });
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
