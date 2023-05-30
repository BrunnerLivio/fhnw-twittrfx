package twittrfx.bird.bird_list;

import javafx.collections.ListChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import twittrfx.ViewMixin;
import twittrfx.bird.BirdPM;
import twittrfx.bird.bird_view.BirdViewPM;
import twittrfx.i18n.Caption;
import twittrfx.i18n.I18nPM;

public class BirdList extends VBox implements ViewMixin {
  private final BirdViewPM model;
  private final I18nPM i18n;
  private TableView<BirdPM> table;
  private BirdListHeader birdListTitle;
  private TableColumn<BirdPM, String> nameColumn;
  private TableColumn<BirdPM, String> populationTrend;
  private TableColumn<BirdPM, String> populationStatus;

  public BirdList(BirdViewPM model, I18nPM i18n) {
    this.model = model;
    this.i18n = i18n;
    init();
  }

  @Override
  public void initializeSelf() {
    addStylesheetFiles("bird_list.css");
  }

  private TableView<BirdPM> initializeTable() {
    TableView<BirdPM> tableView = new TableView<>(model.getBirds());
    nameColumn = new TableColumn<>();
    nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

    populationTrend = new TableColumn<>();
    populationTrend.setCellValueFactory(cellData -> cellData.getValue().populationTrendProperty());

    populationStatus = new TableColumn<>();
    populationStatus.setCellValueFactory(cellData -> cellData.getValue().populationStatusProperty());

    tableView.getColumns().addAll(nameColumn, populationTrend, populationStatus);

    return tableView;
  }

  @Override
  public void initializeControls() {
    table = this.initializeTable();
    birdListTitle = new BirdListHeader(model, i18n);
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
    model.getBirds().addListener((ListChangeListener<BirdPM>) c -> {
      while (c.next()) {
        table.scrollTo(c.getFrom());
      }
    });

  }

  @Override
  public void setupBindings() {
    nameColumn.textProperty().bind(i18n.get(Caption.NAME));
    populationTrend.textProperty().bind(i18n.get(Caption.POPULATION_TREND));
    populationStatus.textProperty().bind(i18n.get(Caption.POPULATION_STATUS));
  }
}
