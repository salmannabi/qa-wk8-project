Coverage:86.5%
# Vehicle Database

This is a vehicle database API which also inludes the Front-End implementation as an example, users of the API can tailor a custom Front-End based on their needs and wants. Currently the API only support the management of Cars but in future other vehicle types such as Vans and Motorbikes can be added to the API. Users of the API can add new cars to the database, update an existing car entry, read all cars in the database or delete a car entry from the database. In addition to the basic CRUD functionality users can also read cars by individual columns such as, Id, Make, Model, Body_Type, Gearbox and Fuel_Type.

Currently the database only has a single table 'Car' and it has the folowing columns
-> id : This stores the id of the car entry to the database
-> make : This stores the make of the car
-> model : This stores the model of the car
-> body_type : This stores the body type of the car
-> gearbox : This stores the gearbox type of the car
-> fuel_type : This stores the fuel_type of the car

## Getting Started

To get a copy of the project on your system
1. Open up a command-line terminal such as GitBash (Note: Git PATH integration into the environment-variables is required)
2. Navigate to the folder where you want to download the project
3. Run "git pull https://github.com/salmannabi/qa-wk8-project". This command will download the project to the specified directory where it can be run and tested

### Prerequisites

To use this software you will need
2. A Java SDK (recommended version 14+), The latest Java SDK can be found here https://www.oracle.com/java/technologies/downloads/
3. Follow the installation instructions for the JDK based on your platform here https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html
3. The JDK path needs to be included in the environment-variables to run the the program from a command line 
4. Download and install the latest version of Eclipse from here: https://www.eclipse.org/downloads/

### Usage

To use the software and API follow the below instructions
1. Run the program by right clicking on the project inside Eclipse, then select 'Run As' and then 'Spring Boot App'
2. Now open up a browser window and navigate to "http://localhost:8080/index.html"
3. To add a new entry to the database complete the relevant fields and press the "Create Entry" button, this will add a new car entry to the database.
4. To update an existing entry just complete the relevant fields and press "Update Entry" button
5. To view all cars, press the "View All Cars" button in the relevant section, this should display all cars in the database at the bottom of the page.
6. To delete a car entry simply put the specified Id of the car in the relevant field and press "Delete By Id" button.
7. Other functionality can also be used in a similar way as the above CRUD functionality.

## Running the tests

The program comes with some automated unit tests for the CarController class of the Java project, to run the tests
1. Right click on the src/tests/java folder
2. Select "Run-as" from the drop down menu
3. Click "JUnit Test"
Using the above instructions will run the entire test suit and a result will be given in the specified JUnit test window
This project uses Integration Testing

### Integration Tests 
Integration tests are used to test an entire class whether it funcitons as it is implemented, that is if the methods in a class are integrated properly. Integration are used after method (Unit) testing and before system testing. An example of integration test is testing the entire customer class to check if its methods are integrated properly.


## Authors

* **Salman Nabi** - *Project completion* - [salmannabi](https://github.com/salmannabi)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Stages Of Development

These are the different stages of the project development in screenshots

### Initial Jira Board
https://github.com/salmannabi/qa-wk8-project/blob/main/documentation/jira-initial-screensnap.png

### Project Risk Assessment
https://github.com/salmannabi/qa-wk8-project/blob/main/documentation/risk_assessment_pdf_screenshot.png

### Risk Assessment Matrix
https://github.com/salmannabi/qa-wk8-project/blob/main/documentation/risk_assessment_matrix.png

### Acceptance Criteria Added
https://github.com/salmannabi/qa-wk8-project/blob/main/documentation/added_acceptance_criteria.png

### Car Table ERD Diagram
https://github.com/salmannabi/qa-wk8-project/blob/main/documentation/car_table_erd_diagram.png

### H2 and Prod Database Properties Added
https://github.com/salmannabi/qa-wk8-project/blob/main/documentation/h2_and_prod_database_implemented.png

### Manual Test Using Postman
https://github.com/salmannabi/qa-wk8-project/blob/main/documentation/api_testing_via_postman.png

### Additional Functionality Added To The Repository
https://github.com/salmannabi/qa-wk8-project/blob/main/documentation/extra_data_retrieval_functionality_added.png

### Front-End index.html Incomplete Stage
https://github.com/salmannabi/qa-wk8-project/blob/main/documentation/index_file_access_view.png

### Test Coverage At 71.7%
https://github.com/salmannabi/qa-wk8-project/blob/main/documentation/test_coverage_at_71.png

### Test Coverage At 86.5%
https://github.com/salmannabi/qa-wk8-project/blob/main/documentation/test_coverage_reached_86.png
