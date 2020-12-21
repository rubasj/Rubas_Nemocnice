package Data;

/**
 * Trida s informacemi o nemocnici, jak funguji smeny, informace o oddeleni, sestrach atd.
 * @author Jan Rubas
 * @version 1.0.1
 */
public class Znalosti {

    /** maximalni pocet smen za sebou */
    public final int MAX_POCET_SMEN = 3;
    /** pocet dni volna */
    public final int DNI_VOLNO_MIN = 3;


    /** pocet hodin v nocni smene */
    public final int NOCNI_SMENA = 12;
    /** nocni smena od */
    public final int NOCNI_SMENA_OD = 18;
    /** nocni smena do */
    public final int NOCNI_SMENA_DO = 6;


    /** pocet hodin v denni smene */
    public final int DENNI_SMENA = 12;
    /** denni smena do */
    public final int DENNI_SMENA_DO = 18;
    /** denni smena od */
    public final int DENNI_SMENA_OD = 6;


    /** pocet hodin ve vikendove odpoledni smene */
    public final int ODPOLEDNI_SMENA_VIKEND = 13;
    /** vikendova odpoledni smena od */
    public final int ODPOLEDNI_SMENA_VIKEND_OD = 8;
    /** vikendova odpoledni smena do */
    public final int ODPOLEDNI_SMENA_VIKEND_DO = 21;


    /** pocet hodin v odpoledni smene */
    public final int ODPOLEDNI_SMENA = 8;
    /** nocni smena od */
    public final int ODPOLEDNI_SMENA_OD = 14;
    /** nocni smena do */
    public final int ODPOLEDNI_SMENA_DO = 22;



}
