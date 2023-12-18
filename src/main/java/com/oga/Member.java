package com.oga;

import java.util.Objects;

/**
 * La classe abstraite Member représente un membre de la bibliothèque, avec des attributs tels que l'identifiant,
 * le prénom, le nom, le portefeuille, et la configuration de profil.
 * Elle fournit un constructeur pour initialiser les informations du membre, ainsi que des méthodes abstraites
 * pour effectuer le paiement des livres empruntés.
 */
public abstract class Member {

    /** L'identifiant du membre. */
    private String id;

    /** Le prénom du membre. */
    private String firstName;

    /** Le nom de famille du membre. */
    private String lastName;

    /** Le montant d'argent disponible dans le portefeuille du membre. */
    private float wallet;

    /** La configuration de profil du membre. */
    private Profil config;

    /**
     * Constructeur de la classe abstraite Member.
     *
     * @param id L'identifiant du membre.
     * @param firstName Le prénom du membre.
     * @param lastName Le nom de famille du membre.
     * @param wallet Le montant d'argent dans le portefeuille du membre.
     * @param config La configuration de profil du membre.
     */
    public Member(String id, String firstName, String lastName, float wallet, Profil config) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.wallet = wallet;
        this.config = config;
    }

    /**
     * Méthode abstraite pour effectuer le paiement des livres empruntés.
     *
     * @param numberOfDays Le nombre de jours pendant lesquels les livres ont été empruntés.
     */
    public abstract void payBook(int numberOfDays);

    /**
     * Obtient le prénom du membre.
     *
     * @return Le prénom du membre.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Modifie le prénom du membre.
     *
     * @param firstName Le nouveau prénom du membre.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Obtient le nom de famille du membre.
     *
     * @return Le nom de famille du membre.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Modifie le nom de famille du membre.
     *
     * @param lastName Le nouveau nom de famille du membre.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Obtient l'identifiant du membre.
     *
     * @return L'identifiant du membre.
     */
    public String getId() {
        return id;
    }

    /**
     * Modifie l'identifiant du membre.
     *
     * @param id Le nouvel identifiant du membre.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Modifie la configuration de profil du membre.
     *
     * @param config La nouvelle configuration de profil du membre.
     */
    public void setConfig(Profil config) {
        this.config = config;
    }

    /**
     * Obtient le montant d'argent dans le portefeuille du membre.
     *
     * @return Le montant d'argent dans le portefeuille du membre.
     */
    public float getWallet() {
        return wallet;
    }

    /**
     * Modifie le montant d'argent dans le portefeuille du membre.
     *
     * @param wallet Le nouveau montant d'argent dans le portefeuille du membre.
     */
    public void setWallet(float wallet) {
        this.wallet = wallet;
    }

    /**
     * Obtient la configuration de profil du membre.
     *
     * @return La configuration de profil du membre.
     */
    public Profil getConfig() {
        return config;
    }

    /**
     * Compare cet objet Member à un autre objet pour déterminer s'ils sont égaux.
     * Deux objets Member sont considérés comme égaux s'ils ont le même identifiant, prénom et nom.
     *
     * @param o L'objet à comparer.
     * @return true si les objets sont égaux, false sinon.
     */
    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (o instanceof Member) {
            Member member = (Member) o;
            result = id.equals(member.id) &&
                    firstName.equals(member.firstName) &&
                    lastName.equals(member.lastName);
        }
        return result;
    }

    /**
     * Génère un code de hachage pour cet objet Member en utilisant l'identifiant, le prénom et le nom.
     *
     * @return Le code de hachage.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }
}

