package com.oga;

/**
 * L'énumération Profil représente les différents profils de membres de la bibliothèque,
 * chacun avec ses propres paramètres tels que la période maximale d'emprunt, la période gratuite,
 * le montant facturé avant et après la période gratuite.
 */
public enum Profil {

    /** Profil pour les résidents. */
    RESIDENT(60, 0, 0.10f, 0.20f),

    /** Profil pour les étudiants. */
    STUDENT(30, 0, 0.10f, 0.10f),

    /** Profil pour les étudiants de première année. */
    STUDENT_1ST_YEAR(30, 15, 0.10f, 0.10f);

    /** La période maximale d'emprunt pour ce profil. */
    private final int maxPeriod;

    /** La période gratuite avant que des frais ne soient facturés. */
    private final int freePeriod;

    /** Le montant facturé avant la période gratuite. */
    private final float amountChargedBefore;

    /** Le montant facturé après la période gratuite. */
    private final float amountChargedAfter;

    /**
     * Constructeur de l'énumération Profil.
     *
     * @param maxPeriod La période maximale d'emprunt pour ce profil.
     * @param freePeriod La période gratuite avant que des frais ne soient facturés.
     * @param amountChargedBefore Le montant facturé avant la période gratuite.
     * @param amountChargedAfter Le montant facturé après la période gratuite.
     */
    Profil(int maxPeriod, int freePeriod, float amountChargedBefore, float amountChargedAfter) {
        this.maxPeriod = maxPeriod;
        this.freePeriod = freePeriod;
        this.amountChargedBefore = amountChargedBefore;
        this.amountChargedAfter = amountChargedAfter;
    }

    /**
     * Obtient la période maximale d'emprunt pour ce profil.
     *
     * @return La période maximale d'emprunt.
     */
    public int getMaxPeriod() {
        return maxPeriod;
    }

    /**
     * Obtient la période gratuite avant que des frais ne soient facturés.
     *
     * @return La période gratuite.
     */
    public int getFreePeriod() {
        return freePeriod;
    }

    /**
     * Obtient le montant facturé avant la période gratuite.
     *
     * @return Le montant facturé avant la période gratuite.
     */
    public float getAmountChargedBefore() {
        return amountChargedBefore;
    }

    /**
     * Obtient le montant facturé après la période gratuite.
     *
     * @return Le montant facturé après la période gratuite.
     */
    public float getAmountChargedAfter() {
        return amountChargedAfter;
    }
}
