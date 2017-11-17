package AppKickstarter.myThreads;

import AppKickstarter.misc.*;
import AppKickstarter.Main_temp;
import AppKickstarter.timer.Timer;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class ChildThread extends AppThread {
    public Socket cSocket;
    DataOutputStream outToClient;
    DataInputStream inFromClient;
    public Main_temp main;

    public ChildThread(String id, Main_temp main_temp) {
        super(id, main_temp);
        this.main = main_temp;
    }


    @Override
    public void run(){
        String inmsg;
        String[]instrs;
        String intype;
        String cid;
        int nPersons;
        int ticketNo;
        int tid;
        boolean isTooLong;

        main.tnum++;
        try{
            outToClient=new DataOutputStream(cSocket.getOutputStream());
            inFromClient=new DataInputStream(cSocket.getInputStream());

            byte b[] = new byte[1024];
            inFromClient.read(b);
            inmsg=new String(b);

            instrs=inmsg.split(" ");
            intype=instrs[0];

            switch(intype){
                case"TicketReq":
                    cid=instrs[1];
                    nPersons=Integer.parseInt(instrs[2]);
                    main.ticketNo++; //global
                    ticketNo=main.ticketNo;
                    Ticket ticket=new Ticket(ticketNo,cid,nPersons,false);   //need Ticket class to save each isACKed value
                    isTooLong=main.checkTooLong(nPersons);
                    if(!isTooLong){
                        outToClient.writeBytes("TicketRep "+cid+" "+nPersons+" "+ticketNo);
                        //save info to waiting queue
                        main.queues[nPersons-1].add(ticket); //not cid only because TicketCall use ticketNo; could add both
                        //GUI
                    }else{
                        outToClient.writeBytes("QueueTooLong "+cid+" "+nPersons);
                    }
//                    main.unregThread(this);
                    break;

                case"TicketACK":
                    ticketNo=Integer.parseInt(instrs[0]);
                    tid=Integer.parseInt(instrs[1]);
                    nPersons=main.getTableThread(Integer.toString(tid-1)).seats;
                    ArrayList<Ticket> theQueue=main.queues[nPersons-1];
                    for(Ticket t:theQueue){
                        if(t.ticketNo==ticketNo){
                            t.isACKed=true;
                        }
                    }

                    outToClient.writeBytes("TableAssign "+ticketNo+" "+tid);
//                    main.unregThread(this);
                    break;

                case"CheckOut":
                    tid=Integer.parseInt(instrs[0]);
                    main.getTableThread(Integer.toString(tid-1)).getMBox().send(new Msg(id, null, Msg.Type.CheckOut, "Client at " + tid + "CheckOut!"));
//                    main.unregThread(this);
                    break;

                default:
                    break;
            }

            inFromClient.close();
            outToClient.close();
            cSocket.close();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }

    }
}
