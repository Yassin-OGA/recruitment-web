package com.oga;

import java.util.Objects;

/**
 * La classe Book représente un livre avec des attributs tels que le titre, l'auteur et l'ISBN.
 * Elle fournit des méthodes pour accéder à ces informations, ainsi que des méthodes pour la comparaison,
 * la représentation sous forme de chaîne et la génération du code de hachage.
 */
public class Book {
    /** Le titre du livre. */
    String title;

    /** L'auteur du livre. */
    String author;

    /** L'ISBN (International Standard Book Number) du livre. */
    ISBN isbn;

    /**
     * Constructeur par défaut de la classe Book.
     */
    public Book() {}

    /**
     * Obtient le titre du livre.
     *
     * @return Le titre du livre.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Obtient l'auteur du livre.
     *
     * @return L'auteur du livre.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Obtient l'ISBN du livre.
     *
     * @return L'ISBN du livre.
     */
    public ISBN getIsbn() {
        return isbn;
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères du livre.
     *
     * @return Une chaîne représentant le livre.
     */
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn=" + isbn +
                '}';
    }

    /**
     * Indique si le livre est égal à un autre objet donné.
     *
     * @param o L'objet à comparer.
     * @return true si les objets sont égaux, false sinon.
     */
    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if(o instanceof Book) {
            Book book = (Book) o;
            result = Objects.equals(title, book.title) &&
                    Objects.equals(author, book.author) &&
                    Objects.equals(isbn, book.isbn);
        }
        return result;
    }

    /**
     * Génère un code de hachage pour le livre.
     *
     * @return Le code de hachage du livre.
     */
    @Override
    public int hashCode() {
        return Objects.hash(title, author, isbn);
    }
}
