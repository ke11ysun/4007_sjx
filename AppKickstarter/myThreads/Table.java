//table thread
//2 methods need to implement in main: getEmptyTableList, checkQueue

package AppKickstarter.myThreads;

import java.util.ArrayList;

import AppKickstarter.misc.*;
import AppKickstarter.Main_temp;

public class Table extends AppThread {
    int tid;
    int seats;
    boolean isEmpty;
    int ticketNo;

    //constructor, copy from ThreadA
    //id is for system reference totally how many threads, tid is for transmission
    public Table(String id, Main_temp a, int tid, int seats) {
        super(id, a);
        this.tid = tid;
        this.seats = seats;
        this.isEmpty = true;
    }

    public void run() {
        log.info("created");    //modify

        //for 1st round, waiting queue all empty, directly call main
        //因為是順序運行所以得單拿出來一輪,不然在check queue的時候沒法接受其他消息例如terminate
        callMain();

        //copy from ThreadA
        //after getting the first client, table thread could run in a loop for receiving msg
        for (boolean quit = false; !quit; ) {
            Msg msg = mbox.receive();
            log.info(id + ": message received: [" + msg + "].");

            switch (msg.getType()) {
               case CheckOut:
                    //main receive CheckOut from ClientStream, use tid to get this thread, table thread get cid
                    log.info(tid + ": Client at Table" + tid + "has CheckOut.");
                    isEmpty = true;
                    callMain();
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
    }


    public void callMain() {
        ArrayList<Integer> etl = new ArrayList<Integer>();  //etl stands for empty table list
        while (isEmpty) {
            //list for GUI purpose
            //then EmptyTableList should be a class, whose obj with an attribute of number-of-seats
            //then main should have getter methods
            etl = main.getEmptyTableList(seats);
            etl.add(tid);

            //main keep checking waiting queue if waiting queue is empty
            //if not empty, return the first client
            ticketNo = main.checkQueue(seats);
            if(ticketNo != -1){
                isEmpty = false;
            }

        }
        etl.remove(tid);

        synchronized (this) {
            try {
                //wait for finish eating
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }

}











