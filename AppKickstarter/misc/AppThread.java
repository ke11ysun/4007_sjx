package AppKickstarter.misc;
import AppKickstarter.Main_temp;
import java.util.logging.Logger;

//======================================================================
// AppThread
public abstract class AppThread implements Runnable {
    protected String id;
    protected Main_temp main;
    protected MBox mbox = null;
    protected Logger log = null;

    //------------------------------------------------------------
    // AppThread
    public AppThread(String id, Main_temp main_temp) {
        this.id = id;
        this.main = main_temp;
        log = main.getLogger();
        mbox = new MBox(id, log);
        main.regThread(this);
        log.fine(id + ": created!");
    } // AppThread


    //------------------------------------------------------------
    // getters
    public MBox getMBox() {
        return mbox;
    }

    public String getID() {
        return id;
    }
} // AppThread
