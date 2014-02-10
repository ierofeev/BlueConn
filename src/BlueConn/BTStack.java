/*
import com.appliancestudio.jbluez.BlueZ;

import javax.bluetooth.BluetoothStateException;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.RemoteDevice;
import java.io.IOException;
import javax.microedition.io.Connection;
import com.sun.kvem.jsr082.bluetooth.BluetoothConnection;
import com.sun.kvem.jsr082.bluetooth.BCC;

public class RemoteDevice {


        // JAVADOC COMMENT ELIDED
        private long l_address;

        // JAVADOC COMMENT ELIDED
        private String s_address;

        // JAVADOC COMMENT ELIDED
        private String friendlyName;

        // JAVADOC COMMENT ELIDED
        protected RemoteDevice(String address) {
            if (address == null) {
                throw new NullPointerException("null address");
            }
            final String errorMsg = "Malformed address: " + address;

            if (address.length() != 12) {
                throw new IllegalArgumentException(errorMsg);
            }

            if (address.startsWith("-")) {
                throw new IllegalArgumentException(errorMsg);
            }

            try {
                l_address = Long.parseLong(address, 16);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(errorMsg);
            }

            // should be upper case only
            address = address.toUpperCase();

            try {
                String lAddr = LocalDevice.getLocalDevice().getBluetoothAddress();

                if (address.equals(lAddr)) {
                    throw new IllegalArgumentException(
                            "Can't use the local address.");
                }
            } catch (BluetoothStateException e) {
                throw new RuntimeException("Can't initialize bluetooth support");
            }
            s_address = address;
        }

    // JAVADOC COMMENT ELIDED
    public final String getBluetoothAddress() {
        return s_address;
    }

    public static void main(String[] args) {

        try {
            BTStack sstack = new BTStack();


        } catch (Exception e) {
            System.out.println("Can't show address? sorry");
        }

    }
}*/
