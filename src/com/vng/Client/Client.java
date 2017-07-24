/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.Client;

import java.util.List;
import java.util.Vector;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 *
 * @author thangbq
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       try{
           TTransport transport;
           transport = new TSocket("localhost",8000);
           transport.open();
           
           TProtocol protocol = new TBinaryProtocol(transport);
           array.Client client = new array.Client(protocol);
           
           perform(client);
           
           transport.close();
       }catch(Exception e)
       {
           e.printStackTrace();
       }
    }
    
    private static void perform(array.Client client) throws TException
    {
        List<Integer> list = new Vector<Integer>(7);
        list.add(5);
        list.add(4);
        list.add(9);
        list.add(9);
        list.add(7);
        list.add(3);
        list.add(8);
        
        list.add(5);
        while (true){
            Result res = client.doAct(Type.PUSH, list);
            
            System.out.println(res.error);
            for(int i = 0; i < res.result.size(); i++)
                System.out.print(res.result.get(i) + " ");
            
            
        }
        
    }
}
