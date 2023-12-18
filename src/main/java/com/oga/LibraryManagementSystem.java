package com.oga;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * La classe LibraryManagementSystem implémente l'interface Library et gère les opérations de la bibliothèque,
 * telles que l'emprunt et le retour de livres. Elle utilise un BookRepository pour stocker et récupérer les informations
 * sur les livres disponibles et empruntés.
 */
public class LibraryManagementSystem implements Library {

    /** Le référentiel de livres utilisé par le système de gestion de bibliothèque. */
    private BookRepository bookRepository;

    /**
     * Constructeur de la classe LibraryManagementSystem.
     *
     * @param bookRepository Le référentiel de livres à utiliser par le système.
     */
    public LibraryManagementSystem(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Book borrowBook(long isbnCode, Member member, LocalDate borrowedAt) {
        Book book = null;
        if (isLate(member)) {
            throw new HasLateBooksException();
        }
        book = bookRepository.findBook(isbnCode);
        Optional<Book> opBook = Optional.ofNullable(book);
        Consumer<Book> c1= b -> bookRepository.saveBookBorrow(b, borrowedAt);
        Consumer<Book> c2 = c1.andThen(b-> bookRepository.saveBorrower(b, member));
        opBook.ifPresent(c2);
        return book;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void returnBook(Book book, Member member) {
        int numberOfDays = (int) bookRepository.findBorrowedBookDate(book).until(LocalDate.now(), ChronoUnit.DAYS);
        bookRepository.returnBook(book);
        member.payBook(numberOfDays);
    }

    /**
     * Vérifie si un membre a des livres en retard.
     *
     * @param member Le membre à vérifier.
     * @return true si le membre a des livres en retard, false sinon.
     */
    private boolean isLate(Member member) {
        boolean result = false;
        List<Book> booksBorrowedByTheMember = bookRepository.booksBorrowedByMember().get(member);
        if (booksBorrowedByTheMember != null) {
            int memberMaxPeriod = member.getConfig().getMaxPeriod();
            result = booksBorrowedByTheMember.stream()
                    .anyMatch(b -> bookNotReturned(b, memberMaxPeriod));
        }
        return result;
    }

    /**
     * Vérifie si un livre n'a pas été retourné dans la période spécifiée.
     *
     * @param book     Le livre à vérifier.
     * @param maxPeriod La période maximale avant qu'un livre ne soit considéré comme en retard.
     * @return true si le livre n'a pas été retourné dans la période spécifiée, false sinon.
     */
    private boolean bookNotReturned(Book book, int maxPeriod) {
        int daysBorrowed = daysBorrowed(book);
        return daysBorrowed > maxPeriod;
    }

    /**
     * Calcule le nombre de jours pendant lesquels un livre a été emprunté.
     *
     * @param book Le livre dont on veut calculer la durée d'emprunt.
     * @return Le nombre de jours d'emprunt du livre.
     */
    private int daysBorrowed(Book book) {
        LocalDate now = LocalDate.now();
        LocalDate borrowedAt = bookRepository.findBorrowedBookDate(book);
        return (int) borrowedAt.until(now, ChronoUnit.DAYS);
    }
}

