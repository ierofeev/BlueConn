package BlueConn;

import de.avetana.bluetooth.connection.ConnectionFactory;
import de.avetana.bluetooth.sdp.RemoteServiceRecord;
import de.avetana.bluetooth.stack.AvetanaBTStack;
import de.avetana.bluetooth.stack.BlueZ;
import de.avetana.bluetooth.stack.BluetoothStack;
import de.avetana.bluetooth.util.BTAddress;
import de.avetana.bluetooth.util.LibLoader;

public class BConnect extends BluetoothStack {

    private int m_bd;       // bluetooth descriptor
    private int devID=-1;   // bluetooth adapter
    private static RemoteServiceRecord myRecord;
    private static boolean fini = false;
    private static boolean initialized = false;
    private static final Object mutex = new Object();

    public BConnect() throws Exception{
        this(0);
    }
    public BConnect(int devID) throws Exception{
        synchronized (mutex) {
            if (initialized) return;
            LibLoader.loadBTLib();
            m_bd = BlueZ.hciOpenDevice(devID, new BlueZ());
            this.devID = devID;
            initialized = true;
        }
    }

    public void setDeviceID(int dev) throws Exception{
        if (BlueZ.myFactory.getConnections().size()!=0) throw new Exception("You must close before all connections");
        if (BlueZ.myFactory.getNotifiers().size()!=0) throw new Exception("You must close before all connection notifiers");
        BlueZ.myFactory = new ConnectionFactory();
        if(devID > -1) {
            try {
                BlueZ.hciCloseDevice(devID);
            } catch(Exception ex) {}
        }
        BlueZ.hciOpenDevice(dev, new BlueZ());
    }

    public String getRemoteName(String bd_addr) throws Exception {
        try {
            String addr="";
            if(bd_addr.length()==12) {
                addr=BTAddress.transform(bd_addr);
            } else addr=bd_addr;
            return BlueZ.hciRemoteName(m_bd,addr);
        }catch(Exception ex) {return "null";}
    }


    public static void main(String[] args) {
        //BConnect FirstConn = new BConnect();

    }
}

