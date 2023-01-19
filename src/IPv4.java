public class IPv4 {

    private String IPaddress;
    private String prefix;
    private String Network;
    private String Broadcast;
    private String HostMin;
    private String HostMax;
    private String Hosts;
    private String classes;

    public String getIPaddress() {
        return IPaddress;
    }

    public void setIPaddress(String IPaddress) {
        this.IPaddress = IPaddress;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getNetwork() {
        return Network;
    }

    public void setNetwork(String Network) {
        this.Network = Network;
    }

    public String getBroadcast() {
        return Broadcast;
    }

    public void setBroadcast(String Broadcast) {
        this.Broadcast = Broadcast;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getHostMin() {
        return HostMin;
    }

    public void setHostMin(String HostMin) {
        this.HostMin = HostMin;
    }

    public String getHostMax() {
        return HostMax;
    }

    public void setHostMax(String HostMax) {
        this.HostMax = HostMax;
    }

    public String getHosts() {
        return Hosts;
    }

    public void setHosts(String Hosts) {
        this.Hosts = Hosts;
    }

}
