package rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class formServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            System.out.println("RMI registry is ready on port: 1099");
            formimpl aformImpl = new formimpl();
            Naming.rebind("rmi://localhost:1099/formServer", aformImpl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}