# Contacts Manager Application

## Introduction
This Android application serves as a personal contacts manager, allowing users to easily add, view, and manage their contacts. The application emphasizes user-friendliness and efficiency, with a sleek design that presents contacts in a card-like fashion within a RecyclerView for optimal organization and accessibility.

## Features
- **Add New Contacts:** Users can create new contacts by pressing the "Add" button. This feature includes validation checks to prevent the addition of contacts with empty fields, ensuring that each contact has a name and an email address.
- **Elegant Display:** Contacts are displayed in a beautiful, card-like list view through the use of a RecyclerView, making it easy for users to view and manage their contacts.
- **Contact Creation Handler**: The AddNewContactClickHandler class is dedicated to handling the creation of new contacts, streamlining the process for a better user experience.
- **Persistent Storage:** The application uses Room Database for data persistence, allowing users to maintain their contact list across sessions.
- **Contact Entity:** A Contact entity class is defined, following the POJO (Plain Old Java Object) pattern, to represent contact information in a structured manner.
- **Data Layer Abstraction:** The MyViewModel class serves as an intermediary layer between the UI and the repository, facilitating data handling and business logic separation.
- **Database Access Object (DAO):** The ContactDao interface, marked with the @Dao annotation, contains the SQL logic for accessing the database, providing an efficient way to perform data operations.

## Technologies Used
- Android Studio
- Java
- XML for layouts
- Room DB

## Screenshots
![image](https://github.com/ihor-kucheriavyi21/ContactsManager/assets/52655831/67452fa8-7243-4b6e-9bd8-201795b6c186)
![image](https://github.com/ihor-kucheriavyi21/ContactsManager/assets/52655831/5eae96ce-0ccb-462a-a23b-96990d080c28)
![image](https://github.com/ihor-kucheriavyi21/ContactsManager/assets/52655831/ec36cf25-40b2-4a35-b333-e822196b3fa3)

