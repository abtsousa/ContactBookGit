# ContactBook

The application manages a contact book. Each contact has a name, a phone number and an email.

## Usage
### Commands

* **AC**: Add a new contact to the contact book
```
AC
name
phone
email
```
* **RC**: Removes a contact from the contact book.
```
RC
name
```
* **GP**: Gets the phone number of a contact.
```
GP
name
```

* **GE**: Gets the email address of a contact.
```
GP
name
```

* **SP**: Updates the phone number of a contact.
```
SP
name
phone
```
* **SE**: Updates the email address of a contact.
```
SE
name
email
```





ULookup a contact given its phone number (GN command). The operation receives a phone number and returns the contact with that given number. In case there are several contacts with that same phone number, the oldest contact is returned. The operation fails if: (1) the phone number does not match any contact ("Phone number does not exist.").

Check if there are contacts with the same phone number (EP command). This operation always succeeds. In case there are contacts with the same phone number, the feedback message is "There are contacts that share phone numbers.". Otherwise, the feedback message is "All contacts have different phone numbers".

End the program execution with the message "Goodbye!".

## Installation
1. Clone the repo
```
git clone https://github.com/MiguelGoulao/ContactBookGit
```
## Currently Contributing
* Afonso Sousa
* Alexandre Cristóvão
* Ana Lopes

## Original Author
* Miguel Goulão