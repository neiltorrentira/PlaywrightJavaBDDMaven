@Smoke @Regression
Feature: Tests 002 - Browse Google
  I want to browse and search Google in my feature file

  Scenario: Tests 002 Google scenario
    Given users inputs "John Cena" search text
    Then users validates "John Cena" search text is present
    #And users clicks Images, News, Videos, and Shopping links