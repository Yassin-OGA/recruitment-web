package com.oga;
/**
 * La classe ISBN représente un numéro ISBN (International Standard Book Number) associé à un livre.
 * Elle stocke le code ISBN sous forme de long.
 */
public class ISBN {
    /** Le code ISBN sous forme de long. */
    long isbnCode;

    /**
     * Constructeur par défaut de la classe ISBN.
     */
    public ISBN() {}

    /**
     * Constructeur de la classe ISBN avec un code ISBN donné.
     *
     * @param isbnCode Le code ISBN à associer à l'objet ISBN.
     */
    public ISBN(long isbnCode) {
        this.isbnCode = isbnCode;
    }

    /**
     * Obtient le code ISBN associé à cet objet ISBN.
     *
     * @return Le code ISBN.
     */
    public long getIsbnCode() {
        return isbnCode;
    }

    /**
     * Modifie le code ISBN associé à cet objet ISBN.
     *
     * @param isbnCode Le nouveau code ISBN.
     */
    public void setIsbnCode(long isbnCode) {
        this.isbnCode = isbnCode;
    }

    /**
     * Génère un code de hachage pour cet objet ISBN en utilisant le code ISBN sous-jacent.
     *
     * @return Le code de hachage.
     */
    @Override
    public int hashCode() {
        return Long.hashCode(isbnCode);
    }

    /**
     * Compare cet objet ISBN à un autre objet pour déterminer s'ils sont égaux.
     * Deux objets ISBN sont considérés comme égaux s'ils ont le même code ISBN.
     *
     * @param o L'objet à comparer.
     * @return true si les objets sont égaux, false sinon.
     */
    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (o instanceof ISBN) {
            ISBN isbn = (ISBN) o;
            result = isbnCode == isbn.getIsbnCode();
        }
        return result;
    }
}
