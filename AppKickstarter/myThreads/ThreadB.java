package AppKickstarter.myThreads;

import AppKickstarter.misc.*;
import AppKickstarter.AppKickstarter;
import AppKickstarter.Main_temp;


//======================================================================
// ThreadB
public class ThreadB extends AppThread {
    private final int sleepTime = 2000;

    //------------------------------------------------------------
    // ThreadB
    public ThreadB(String id, Main_temp main) {
	super(id, main);
    } // ThreadB


    //------------------------------------------------------------
    // run
    public void run() {
	log.info(id + ": starting...");

	for (boolean quit = false; !quit;) {
	    Msg msg = mbox.receive();

	    log.info(id + ": message received: [" + msg + "].");

	    switch (msg.getType()) {
		case Hello:
		    log.info(id + ": " + msg.getSender() + " is saying Hello to me!!!");
		    msg.getSenderMBox().send(new Msg(id, mbox, Msg.Type.HiHi, "HiHi, this is Thread B!"));
		    break;

		case Terminate:
		    quit = true;
		    break;

		default:
		    log.severe(id + ": unknown message type!!");
		    break;
	    }
	}

	// declaring our departure
	main.unregThread(this);
	log.info(id + ": terminating...");
    } // run
} // ThreadB

