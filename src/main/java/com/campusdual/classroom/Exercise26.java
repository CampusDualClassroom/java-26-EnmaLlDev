package com.campusdual.classroom;


public class Exercise26 {
    public static void main(String[] args) {

        //Verificaicones clase Contact
        Contact contact1 = new Contact("Javier", "Lopez", "654321321");
        Contact contact2 = new Contact("Carlos", "Fernandez-Simón", "654321321");
        Contact contact3 = new Contact("Jose Manuel", "Soria", "654321321");
        Contact contact4 = new Contact("Santiago", "Fernández Rocha", "654321321");
        Contact contact5 = new Contact("Esteban", "Serrano del Río", "654321321");
        Contact contact6 = new Contact("Fernando Miguel", "Juan de los Santos Requejo León", "654321321");
        System.out.println("------------------------------------");
        Contact[] contactos = new Contact[]{ contact1, contact2, contact3, contact4, contact5, contact6};

        for (Contact c : contactos) {
            c.callMyNumber();
            c.callOtherNumber("999888777");
            c.showContactDetails();
        }


        System.out.println("------------------------------------");
        //Verificaciones clase Phonebook
        Phonebook agendaTelefonica = new Phonebook();
        agendaTelefonica.addContact(contact1);
        agendaTelefonica.addContact(contact2);
        agendaTelefonica.addContact(contact3);
        agendaTelefonica.addContact(contact4);
        agendaTelefonica.addContact(contact5);
        agendaTelefonica.addContact(contact6);
        agendaTelefonica.showPhonebook();
        System.out.println("Contactos en la agenda: " + agendaTelefonica.getData().size());
        agendaTelefonica.deleteContact(contact1.getCode());
        System.out.println("Contactos en la agenda: " + agendaTelefonica.getData().size());
        agendaTelefonica.showPhonebook();
        System.out.println("------------------------------------");
    }
}
