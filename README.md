# Phonebook Management System Report | Jack Keys | CompSci-349

## UMLs

![screenshot](https://github.com/Vulpolox/PhonebookManagementSystem/blob/main/Screenshots/UMLs.png)

## Features

![screenshot](https://github.com/Vulpolox/PhonebookManagementSystem/blob/main/Screenshots/FeaturesTable.png)

## Code Explanations

#### UserDataAccess Class

* The class that handles communication with the database.  It utilizes objects of the User and Contact classes with its methods to manipulate and retrieve data from the database

#### User Class

* The class that represents users within the database
* The class contains username and password fields along with a unique id used as a foreign key to find contacts associated with it in the database

#### Contact Class

* The class that represents a contact belonging to a user in the database
* The class contains firstname, lastname, and phone number fields which can be displayed to the end-user or edited using an update operation
* Contact objects associated with the user are retrieved from the database using an instance of UserDataAccess and are stored in an array; the array is used alongside a DefaultListModel to construct a JList that is then displayed to the end-user.  A reference to the original array is also kept so data isn't lost from search operations

#### Views

* The different windows that the application is composed of.  Views include the LoginView for logging in end-users into the system, the RegisterView for registering new end-users, the ContactsView for viewing contacts associated with users, and the AddContact and EditContact views for manipulating contacts

#### Controllers

* Controller classes add functionality to the components of each of the windows from the Views
* Notable Components / Controllers:
  - searchButton -- takes the text from searchField and filters the Contacts in the JList to have only entries that contain the text in their firstname or lastname fields.  It does this by passing a reference to the DefaultListModel of the JList to a function alongside an array of Contacts containing the unmodified data and the text from SearchField.  This function does two things: first, it first clears all data from the ListModel.  Then, if there is no text in the SearchField when the button is pressed (i.e. an empty string is passed to the function), the ListModel is repopulated with all of the original data; otherwise, the ListModel is populated only with Contacts from the original data whose first or lastname fields contain the text from the searchField.
  - registerButton -- if any of the corresponding JTextFields are empty, if the password fields don't match, or if the username entered in the UsernameField is associated with an account currently in the database, display the appropriate error message through a JOptionPane; otherwise, construct a User using the data entered in the fields and pass that to an instance of the UserDataAccess class to store in the database
  - loginButton -- if any of the corresponding JTextFields are empty or if the entered username and password are not associated with a user currently in the database, display the appropriate error message through a JOptionPane; otherwise, fetch the id associated with the entered username and password through a UserDataAccess instance and use it to create an array of Contacts associated with it (also through a UDA instance). The array is then stored as instance data in the ContactsView and is used to both construct the JList every time it is loaded in and to preserve data through search operations.
  - addContactButton -- if any of the corresponding JTextFields are empty, displays an error message through a JOptionPane; otherwise, creates a new Contact object using the data from the fields and the current User's id and, through a UserDataAccess object, adds it to the database
  - editContactButton -- if a Contact is not selected from the JList, displays an error message through a JOptionPane; otherwise, loads the EditContactView with its JTextFields auto-populated with the data from the selected Contact.
  - updateContactButton -- exists in EditContactView.  If any of the corresponding JTextFields are emtpy, displays an error message through a JOptionPane; otherwise, it deletes the selected Contact from the database and creates and adds an updated one with the data from the text fields to the database before reloading the ContactsView
  - deleteContactButton -- exists in EditContactView.  When pressed, it removes the currently selected Contact from the database before reloading the ContactsView
  - contactsList -- the JList that is displayed in the ContactsView containing all Contacts associated with the current User.  Contacts are sorted alphabetically by firstname on JList initialization through a class that implements the Comparator interface alongside the Arrays.sort function from the java.utils library

## Screenshots

#### Registering and Logging in

![screenshot](https://github.com/Vulpolox/PhonebookManagementSystem/blob/main/Screenshots/FeatureScreenshots/LoginAndRegister.png)

#### Adding New Contacts

![screenshot](https://github.com/Vulpolox/PhonebookManagementSystem/blob/main/Screenshots/FeatureScreenshots/AddingContacts.png)

#### Searching Through Contacts

![screenshot](https://github.com/Vulpolox/PhonebookManagementSystem/blob/main/Screenshots/FeatureScreenshots/Search.png)

#### Updating Contacts

![screenshot](https://github.com/Vulpolox/PhonebookManagementSystem/blob/main/Screenshots/FeatureScreenshots/UpdateContact.png)

#### Removing Contacts

![screenshot](https://github.com/Vulpolox/PhonebookManagementSystem/blob/main/Screenshots/FeatureScreenshots/RemoveContact.png)

#### CSV Writing

![screenshot](https://github.com/Vulpolox/PhonebookManagementSystem/blob/main/Screenshots/FeatureScreenshots/CSVWriting.png)

## Video

## Download Link

[Zip file with source code and .jar](https://drive.google.com/drive/folders/1Sd2CwV23NgdhE1F5OoNGNZvsRhZ2Ajye?usp=sharing) \
(alternatively, you can just clone this repo as it is the same thing)

## Source Code Shortcuts (for easier grading)

#### Views

* [LoginView.java](https://github.com/Vulpolox/PhonebookManagementSystem/blob/main/PhoneBookManagement/src/View/LoginView.java)

* [RegisterView.java](https://github.com/Vulpolox/PhonebookManagementSystem/blob/main/PhoneBookManagement/src/View/RegisterView.java)

* [ContactsView.java](https://github.com/Vulpolox/PhonebookManagementSystem/blob/main/PhoneBookManagement/src/View/ContactsView.java)

* [EditContactView.java](https://github.com/Vulpolox/PhonebookManagementSystem/blob/main/PhoneBookManagement/src/View/EditContactView.java)

* [AddContactView.java](https://github.com/Vulpolox/PhonebookManagementSystem/blob/main/PhoneBookManagement/src/View/AddContactView.java)

#### Controllers

* [LoginController.java](https://github.com/Vulpolox/PhonebookManagementSystem/blob/main/PhoneBookManagement/src/Controllers/LoginController.java)

* [RegisterController.java](https://github.com/Vulpolox/PhonebookManagementSystem/blob/main/PhoneBookManagement/src/Controllers/RegisterController.java)

* [ContactsController.java](https://github.com/Vulpolox/PhonebookManagementSystem/blob/main/PhoneBookManagement/src/Controllers/ContactsController.java)

* [EditContactController.java](https://github.com/Vulpolox/PhonebookManagementSystem/blob/main/PhoneBookManagement/src/Controllers/EditContactController.java)

* [AddContactController.java](https://github.com/Vulpolox/PhonebookManagementSystem/blob/main/PhoneBookManagement/src/Controllers/AddContactController.java)

#### Modules

* [User.java](https://github.com/Vulpolox/PhonebookManagementSystem/blob/main/PhoneBookManagement/src/Modules/User.java)

* [Contact.java](https://github.com/Vulpolox/PhonebookManagementSystem/blob/main/PhoneBookManagement/src/Modules/Contact.java)

* [UserDataAccess.java](https://github.com/Vulpolox/PhonebookManagementSystem/blob/main/PhoneBookManagement/src/Modules/UserDataAccess.java)

* [ContactComparator](https://github.com/Vulpolox/PhonebookManagementSystem/blob/main/PhoneBookManagement/src/Modules/ContactComparator.java)

#### MyUtils

* [Utilites.java](https://github.com/Vulpolox/PhonebookManagementSystem/blob/main/PhoneBookManagement/src/MyUtils/Utilities.java)

#### App

* [Main](https://github.com/Vulpolox/PhonebookManagementSystem/blob/main/PhoneBookManagement/src/App/Main.java)

