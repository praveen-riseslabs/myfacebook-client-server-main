__This is Back end project for Registration and login for a user. In this project I used Spring boot 3.2 as back end technology and mysql as database.__

# Prerequisites:

Before you begin, ensure you have Java Development Kit (JDK) installed on your Windows machine.

Before you begin, ensure you have MYSQL database work bench

# STS 4 Installation Steps:

__Download STS 4:__

Visit the official Spring Tool Suite download page: [STS](https://spring.io/tools)  Installing Spring boot is the same as installing any other software.

![sts home page](https://github.com/praveen-riseslabs/fullstack-venkataraman-vuejs/assets/152584709/e41dbe05-379b-431d-bb77-31023cc056fd)

Choose platform as you like for mine I choosen Spring tools 4 for Eclipse (Windows).

Click on the "Download STS 4" button. Choose the appropriate version based on your Windows architecture (32-bit or 64-bit).

##### Run the Installer:

Once the download completes, locate the downloaded STS installer file (usually in the Downloads folder).

Double-click the installer file to start the installation process.

Select Installation Directory:

The installer will prompt you to choose the installation directory for STS.

Select a preferred directory or use the default one suggested by the installer.

##### Installation Progress:

The installer will begin copying files and configuring the STS 4 environment.

Wait for the installation process to complete. This may take a few minutes depending on your system's performance.

##### Launch STS 4:

Once the installation finishes, you'll have the option to launch STS 4 immediately after installation.

If not automatically launched, locate the STS 4 executable file in the installation directory and double-click it to open the Spring Tool Suite 4.

##### Configure STS 4:

Upon launching STS 4 for the first time, you might be prompted to select a workspace directory.

Choose a workspace directory where your projects will be stored, or stick with the default workspace provided by STS.

##### Start Using STS 4:

After configuring the workspace, STS 4 will open with the welcome screen.

You are now ready to start creating and managing your Spring projects using the Spring Tool Suite 4 on your Windows machine.

### Troubleshooting:

##### Java JDK Not Found:

If STS 4 fails to start due to Java JDK not found, ensure that JDK is installed and the environment variable JAVA_HOME is correctly set.

# MySQL Installation Steps:

__Download MySQL Installer:__

Visit the official MySQL download page: [MYSQL](https://dev.mysql.com/downloads/workbench/)

![Screenshot (31)](https://github.com/praveen-riseslabs/fullstack-venkataraman-vuejs/assets/152584709/fbf281c1-f423-4af7-9c46-2486d7192d8c)

Click on the "MySQL Installer for Windows" download button.

##### Run the Installer:

Once the download is complete, locate the downloaded MySQL Installer executable file.

Double-click the installer file to begin the installation.

##### Choose Setup Type:

The installer offers different setup types. Select "Developer Default" for a typical installation suitable for most development needs.

You can customize by choosing "Custom" if you require specific configurations.

##### Product Selection:

The installer will display a list of MySQL products available for installation. Ensure that "MySQL Workbench" is selected for installation.

Optionally, select other components or tools you might need, such as MySQL Server.

##### MySQL Workbench Configuration:

During the installation, you'll be prompted to configure MySQL Work bench.

Set a root password for the MySQL root user. Ensure it's strong and secure.

Choose a port for MySQL (3306 is the default) and configure other options as per your requirements.

##### Installation Progress:

Proceed with the installation by clicking the "Execute" button.

The installer will download necessary files and configure the MySQL Workbench based on your selections.

##### Complete Installation:

Once the installation completes, you'll see a summary of the installed products and configurations.

Click on the "Finish" button to complete the installation.

##### Start MySQL Workbench:

After installation, MySQL Workbench might not start automatically.

You can start MySQL manually by accessing the Windows Services. Search for "Services" in the Windows search bar, locate "MySQL" in the list, and start the service.

##### Troubleshooting:

Port Conflict: If the chosen port (default: 3306) is already in use, consider using a different port during installation.

Firewall Settings: Ensure that your firewall allows MySQL connections on the specified port.

## Successfully completed the Prerequisites

__Note:__ Before ruuning the server Create a database in the my sql by using below commands

Access MySQL Command Line:

Open a Command Prompt or terminal window.

#### Enter the MySQL command line interface by typing:

##### mysql -u your_username -p

Replace your_username with your MySQL username. You'll be prompted to enter your MySQL password.

#### Create a Database:

Once logged in to MySQL, you can create a new database using the CREATE DATABASE command. For example:

##### CREATE DATABASE your_database_name;

Replace your_database_name with the desired name for your database. Remember the name of the database you created.


__Importing and running a Java Spring Boot application involves a few steps, primarily related to setting up the project in your preferred integrated development environment (IDE) and running the application. Here's a general guide:__

 ## 1. Importing the Spring Boot Project:

### a. Cloning or Downloading the Project:

If using Git:

Open Git Bash or a terminal.

Use git clone <repository_URL> to clone the project repository to your local machine.

#### If downloading as a ZIP:

Download the project as a ZIP file from the repository (GitHub, GitLab, etc.).

Extract the ZIP file to a preferred directory on your computer.

### b. Opening the Project in IDE:

Open your preferred IDE (IntelliJ IDEA, Eclipse, or Spring Tool Suite). For mine I choosen Eclipse.

### c. Importing the Project:

#### In Eclipse:

Two ways to import the project:

1. Click on "File" --> "Open Projects from file system." --> "Select the project folder in your directory".

![part 1](https://github.com/praveen-riseslabs/fullstack-venkataraman-vuejs/assets/152584709/7f69b3f0-6842-412a-8591-738749b474a1)

![part 2](https://github.com/praveen-riseslabs/fullstack-venkataraman-vuejs/assets/152584709/13a4b9e7-c5cd-4238-a25b-c8feb213a360)

2. Click on "File" --> "Import" --> "Maven" --> "Existing project" --> "Select the project folder in your directory".

![import part 1](https://github.com/praveen-riseslabs/fullstack-venkataraman-vuejs/assets/152584709/01d00422-6df3-4b77-8d89-38114cacf82f)

![import part 2 ](https://github.com/praveen-riseslabs/fullstack-venkataraman-vuejs/assets/152584709/bd0e5fb8-5279-4464-b14e-7967ba153c1d)

![import part 3](https://github.com/praveen-riseslabs/fullstack-venkataraman-vuejs/assets/152584709/011547d2-8cd3-4e5b-9126-07e9f5f0802a)

### d. Resolving Dependencies:

The IDE will automatically download the necessary dependencies specified in the project's build file (pom.xml for Maven or build.gradle for Gradle).

## 2. Configuring and Running the Spring Boot Application:

__Note:__ It is neccesary to configure Application.properties in your project to save the data I'm attaching the picture for your reference.

### a. Changing Application Properties:

Locate the application.properties or application.yml file in the project's resources directory.

__Path:__ Project/src/main/resources/application.prperties

Update database connection properties, server port, or any other configurations required for your environment. Kindly observe the below picture I'm attaching and change them as connection credentials.

![Application properties](https://github.com/praveen-riseslabs/fullstack-venkataraman-vuejs/assets/152584709/0a05febd-3fcd-4bd6-afda-591826fdeff0)

### b. Running the Application:

Two ways to run the Application

1. Right click on the project folder --> "Run As" --> "Spring Boot Application".

![run througn project folder](https://github.com/praveen-riseslabs/fullstack-venkataraman-vuejs/assets/152584709/f753c22f-558c-4327-8cae-f7b1d40392d5)

2. Find the main class annotated with @SpringBootApplication. Right-click on this class and select the option to "Run As" --> "Spring Boot Application".If prompted, choose the main method to start the application.

![run througn main class](https://github.com/praveen-riseslabs/fullstack-venkataraman-vuejs/assets/152584709/a2240286-2975-45cb-a701-485919a8a233)
   
The default endpoint for a Spring Boot application is usually http://localhost:8080. but I inserted __http://localhost:8085__ port for avoiding front end, back end running on same server please go with the Application properties image I attached in above section. 

### c. Monitoring Application Output:

Check the console in the IDE for application logs, including any startup messages, errors, or endpoints available.

### d. Accessing and Testing the Application:

Open a web browser or use tools like Postman to interact with the application's endpoints.

## 3. Additional Tips:

Before running the application, ensure that any necessary configurations (like database connection properties) are properly set up in the application.properties or application.yml file.

By following these detailed steps, newcomers to Spring Boot can successfully import a project, configure it, and run the application within their preferred IDE.
