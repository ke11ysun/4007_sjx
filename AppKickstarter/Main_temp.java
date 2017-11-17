package AppKickstarter;

import AppKickstarter.misc.*;
import AppKickstarter.myThreads.ChildThread;
import AppKickstarter.myThreads.Table;

import java.net.*;
import java.io.*;
import java.util.ArrayList;



//class Main_temp = class AppKickStarter
public class Main_temp extends AppKickstarter {

    public String ServerIP;
    public int portNum;
    public int maxNPersons = 10;    //suppose
    public int tnum = 0;
    public int ticketNo = 0;
    public ArrayList<Ticket>[] queues;
    public Table[] tables = new Table[32];
    public EmptyTableList[] etls = new EmptyTableList[5];

    public Main_temp(String id, String ServerIP, int portNum) throws IOException {
        super(id);
        this.ServerIP = ServerIP;
        this.portNum = portNum;

        for (int i = 1; i <= maxNPersons; i++) {
            queues[i] = new ArrayList<Ticket>();
            etls[i] = new EmptyTableList(i);
            tables[i] = new Table(Integer.toString(i), this, 0, 1);
            new Thread(tables[i]).start();
        }

        ServerSocket sSocket = new ServerSocket(portNum);
        System.out.println(String.format("Listening at port %d... ", portNum));
        do {
            ChildThread t = new ChildThread("msg" + Integer.toString(tnum), this);
            t.cSocket = sSocket.accept();
            new Thread(t).start();
            System.out.println("tnum this time: " + tnum);

        } while (tnum > 0);
    }


    public boolean checkTooLong(int nPersons) {
        boolean isTooLong;
        if (queues[nPersons-1].size() > 10) {
            isTooLong = true;
        } else {
            isTooLong = false;
        }
        return isTooLong;
    }

    public ArrayList<Integer> getEmptyTableList(int nPersons) {
        return etls[nPersons-1];
    }


    public int checkQueue(int nPersons) {
        ArrayList<Ticket> theQueue = queues[nPersons-1];
        while (theQueue.size() == 0) {
            //keep checking
        }
        int num = 0;
        int calls = 0;
        Socket cSocket;
        DataOutputStream outToServer;
        while (num < theQueue.size()) {
            //if not empty call the first client waiting
            Ticket theTicket = theQueue.get(num);
            try {
                cSocket = new Socket(InetAddress.getByName(ServerIP), portNum);
                outToServer = new DataOutputStream(cSocket.getOutputStream());
                System.out.println("Connected to server port# " + portNum + " using local port: " + cSocket.getLocalPort());
                while (!theTicket.isACKed) {
                    try {
                        outToServer.writeBytes("TicketCall " + ticketNo + " " + getEmptyTableList(theTicket.nPersons).get(0));
                        outToServer.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    calls++;

                    long startTime = System.currentTimeMillis();
                    while ((System.currentTimeMillis() - startTime <= 100000)){
                        //wait
                        if(theTicket.isACKed) {
                            break;
                        }
                    }
                    if (calls > 2) {
                        theQueue.remove(theTicket);
                        break;
                    }
                }
                num++;
                //if no one from the waiting queue ACKed
                if (num == theQueue.size() - 1) {
                    ticketNo = -1;
                }
                outToServer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        return ticketNo;
    }

    public static void main(String[] args) throws IOException {
        new Main_temp("sjx", "127.0.0.1", 54321);
    }
}