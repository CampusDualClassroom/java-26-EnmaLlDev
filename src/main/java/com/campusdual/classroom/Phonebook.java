package com.campusdual.classroom;

import java.util.Map;
import java.util.HashMap;
/*
* Añadir un contacto al listín telefónico
Mostar los contactos del listín telefónico
Seleccionar un contacto y mostrar su menú de acciones
Eliminar un contacto
* **/
public class Phonebook {
    Map<String, Contact> listaTelefonica = new HashMap<>();
    public void addContact(Contact contact) {
        if (contact != null && !listaTelefonica.containsKey(contact.getCode())) {
            listaTelefonica.put(contact.getCode(), contact);
            System.out.println("Añadido: " + contact.getName() + " " + contact.getSurname());
        } else {
            System.out.println("El contacto ya existe o no es valido.");
        }
    }
    public void deleteContact(String code) {
        if (listaTelefonica.containsKey(code)) {
            Contact removedContact = listaTelefonica.remove(code);
            System.out.println("Eliminado: " + removedContact.getName() + " " + removedContact.getSurname());
        } else {
            System.out.println("El contacto no existe.");
        }
    }
    public Map<String, Contact> getData() {
        return listaTelefonica;
    }

    public void showPhonebook() {
        for(Contact c : listaTelefonica.values()) {
            System.out.println("Contacto: " + c.getName() + " " +
                    c.getSurname() + ", Teléfono: " + c.getPhone());
        }
    }
}
