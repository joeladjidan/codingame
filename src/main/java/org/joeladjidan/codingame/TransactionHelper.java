package org.joeladjidan.codingame;

/**
 * Utilitaire simple pour illustrer la gestion transactionnelle demandée.
 *
 * Règles appliquées dans la méthode a(Service s, Connection c):
 * - Appeler s.execute().
 * - Si s.execute() lance une exception : appeler c.rollback() puis propager l'exception.
 * - Sinon : appeler c.commit().
 * - Dans tous les cas, appeler c.close() avant de quitter la méthode.
 */
public final class TransactionHelper {

    private TransactionHelper() { /* non instanciable */ }

    /** Interface de service fourni par l'appelant. */
    public interface Service {
        void execute() throws Exception;
    }

    /** Interface légère de connexion utilisée pour la démonstration. */
    public interface Connection {
        void commit() throws Exception;
        void rollback() throws Exception;
        void close() throws Exception;
    }

    /**
     * Exécute le service en respectant la sémantique transactionnelle décrite ci-dessus.
     */
    public static void a(Service s, Connection c) throws Exception {
        boolean success = false;
        try {
            s.execute();
            success = true;
            c.commit();
        } catch (Exception e) {
            try {
                c.rollback();
            } catch (Exception rbEx) {
                // conserver l'exception initiale et ajouter la rollback comme suppressed
                e.addSuppressed(rbEx);
            }
            throw e; // propager l'exception
        } finally {
            try {
                c.close();
            } catch (Exception closeEx) {
                // Si nous avions déjà une exception en cours, on la rattachera ; sinon on la propage
                if (!success) {
                    // déjà une exception a été lancée et propagée; ajout en suppressed possible
                    // rien de spécial à faire ici car l'exception principale a déjà été lancée
                } else {
                    // si tout s'est bien passé mais la fermeture échoue, on propage l'exception
                    throw closeEx;
                }
            }
        }
    }

    // --- Démo dans le main ---
    public static void main(String[] args) {
        // Connexion factice qui affiche les opérations
        Connection conn = new Connection() {
            @Override public void commit() { System.out.println("commit called"); }
            @Override public void rollback() { System.out.println("rollback called"); }
            @Override public void close() { System.out.println("close called"); }
        };

        // Cas 1 : service qui réussit
        Service okService = () -> System.out.println("service executed successfully");

        try {
            System.out.println("--- Running success case ---");
            a(okService, conn);
        } catch (Exception e) {
            System.err.println("unexpected exception: " + e);
        }

        // Cas 2 : service qui échoue
        Service failingService = () -> { throw new RuntimeException("boom"); };
        try {
            System.out.println("--- Running failure case ---");
            a(failingService, conn);
        } catch (Exception e) {
            System.out.println("caught propagated exception: " + e.getMessage());
        }
    }
}

