import java.util.Arrays;
import java.math.*;
import java.util.Scanner;
import java.lang.Integer;
/*
 * @author Ebu Bekir Acar ebubekiracar.github.io
 * github.com/ebubekiracar
 */
public class Main {

  public static void main(String[] args) {

    IPv4 ipv4 = new IPv4();
    Manager manager = new Manager();
    Color c = new Color();
    Scanner scanner = new Scanner(System.in);

    String ipBinary = "";
    int binaryIP[] = new int[32];

    System.out.println("");
    System.out
        .println("██ ██████       ██████  █████  ██       ██████ ██    ██ ██       █████  ████████  ██████  ██████ ");
    System.out
        .println("██ ██   ██     ██      ██   ██ ██      ██      ██    ██ ██      ██   ██    ██    ██    ██ ██   ██");
    System.out
        .println("██ ██████      ██      ███████ ██      ██      ██    ██ ██      ███████    ██    ██    ██ ██████ ");
    System.out
        .println("██ ██          ██      ██   ██ ██      ██      ██    ██ ██      ██   ██    ██    ██    ██ ██   ██ ");
    System.out
        .println("██ ██           ██████ ██   ██ ███████  ██████  ██████  ███████ ██   ██    ██     ██████  ██   ██ ");
    System.out.println("");
    System.out.print("Enter the IP address and Prefix value " + c.purple("(e.g:192.168.1.10/24)") + " : ");
    String input = scanner.nextLine();
    String[] IpHost = input.split("/");
    ipv4.setIPaddress(IpHost[0]); 
    ipv4.setPrefix(IpHost[1]);
    String[] ips = ipv4.getIPaddress().split("\\.");
    int[] ipAddress = new int[4];
    for (int i = 0; i < ips.length; i++) {
      ipAddress[i] = Integer.parseInt(ips[i]);
    }
    System.out.println(c.green("+ IP address split converted to string of numbers"));
    int prefix = Integer.parseInt(ipv4.getPrefix());
    System.out.println(c.green("+ Verifying IP and Prefix.."));
    if (manager.ipController(ipAddress) == 1 && manager.prefixController(prefix) == 1) {
      System.out.println(c.green("+ IP and Prefix Verified.."));
    } else {
      System.out.println(c.red("! Check the address and length."));
      System.exit(0);
    }
    /**************************************************
     * IP ADDRESS
     **************************************************/
    for (int j = 0; j < ipAddress.length; j++) {
      binaryIP = manager.toBinary(ipAddress[j]);
      for (int i = 0; i <= 7; i++) {
        ipBinary += binaryIP[i];
      }
    }
    String[] binarystringIP = new String[4];
    for (int i = 0, j = 0; i < 4; i++) {
      binarystringIP[i] = ipBinary.substring(j, j + 8);
      j += 8;
    }
    /***************************************************
     * SUBNET MASK
     ****************************************************/
    String bPrefix = "";
    for (int i = 0; i < 32; i++) {
      if (i < prefix) {
        bPrefix += "1";
      } else {
        bPrefix += "0";
      }
    }

    String[] binarystringPrefix = new String[4];
    int[] decimalPrefix = new int[4];
    String[] decimalPrefixstring = new String[4];
    for (int i = 0, j = 0; i < 4; i++) {
      binarystringPrefix[i] = bPrefix.substring(j, j + 8);
      j += 8;
    }
    for (int i = 0; i < 4; i++) {
      decimalPrefix[i] = Integer.valueOf(binarystringPrefix[i], 2);
    }
    for (int i = 0; i < 4; i++) {
      decimalPrefixstring[i] = Integer.toString(decimalPrefix[i]);
    }
    String joinedPrefixString = String.join(".", decimalPrefixstring);
    /*******************************************************
     * NETWORK
     *******************************************************/
    int hosts = (int) Math.pow(2, (32 - prefix)) - 2;
    ipv4.setHosts(Integer.toString(hosts));
    int[] networkz = new int[4];
    String[] networkstr = new String[4];
    for (int i = 0; i < 4; i++) {
      networkz[i] = ipAddress[i] & decimalPrefix[i];
    }
    for (int i = 0; i < 4; i++) {
      networkstr[i] = Integer.toString(networkz[i]);
    }
    String joinedNetworkString = String.join(".", networkstr);
    ipv4.setNetwork(joinedNetworkString);

    String[] binarystringNBinary = new String[4];
    String NBinary = "";
    int binaryN[] = new int[32];
    for (int j = 0; j < networkz.length; j++) {
      binaryN = manager.toBinary(networkz[j]);
      for (int i = 0; i <= 7; i++) {
        NBinary += binaryN[i];
      }
    }
    for (int i = 0, j = 0; i < 4; i++) {
      binarystringNBinary[i] = NBinary.substring(j, j + 8);
      j += 8;
    }
    /************************************************
     * BROADCAST
     ************************************************/
    String broadcast = "";
    String binstringip = String.join("", binarystringIP);
    int len = Math.min(binstringip.length(), bPrefix.length());
    String andResult = "";
    String orResult = "";
    for (int i = 0; i < prefix; i++) {
      if (binstringip.charAt(i) == '1' && bPrefix.charAt(i) == '1') {
        andResult += "1";
      } else {
        andResult += "0";
      }
    }
    for (int i = prefix; i < 32; i++) {
      if (binstringip.charAt(i) == '1' || '1' == '1') {
        orResult += "1";
      } else {
        orResult += "0";
      }
    }
    broadcast = andResult + orResult;

    int len2 = broadcast.length();
    int partLen = len2 / 4;

    String[] binartStringBbinary = new String[4];
    for (int i = 0; i < 4; i++) {
      binartStringBbinary[i] = broadcast.substring(i * partLen, (i + 1) * partLen);
    }

    String resultBroadcast = String.join(".", binartStringBbinary);

    String[] broadcastDecStr = new String[4];

    for (int i = 0; i < 4; i++) {
      broadcastDecStr[i] = Integer.toString(Integer.parseInt(binartStringBbinary[i], 2));
    }
    String broadcastDecStr2 = String.join(".", broadcastDecStr);
    ipv4.setBroadcast(broadcastDecStr2);
    /************************************************
     * MIN HOST
     ************************************************/
   String hostminbit;
    if(prefix == 32){
      hostminbit = NBinary;
    }else{
    String subStringHost = NBinary.substring(prefix);  
    int newValueHostminbit = Integer.parseInt(subStringHost, 2) + 1;
    String newHmnBinaryString = Integer.toBinaryString(newValueHostminbit);
    while (newHmnBinaryString.length() < (32 - prefix)) {
      newHmnBinaryString = "0" + newHmnBinaryString;
    }
    hostminbit = NBinary.substring(0, prefix) + newHmnBinaryString;
    }
    String[] binarystrinHmin = new String[4];
    int[] decimalHmin = new int[4];
    String[] decimalHminstring = new String[4];
    for (int i = 0, j = 0; i < 4; i++) {
      binarystrinHmin[i] = hostminbit.substring(j, j + 8);
      j += 8;
    }
    for (int i = 0; i < 4; i++) {
      decimalHmin[i] = Integer.valueOf(binarystrinHmin[i], 2);
    }
    for (int i = 0; i < 4; i++) {
      decimalHminstring[i] = Integer.toString(decimalHmin[i]);
    }
    String joinedHostMinString = String.join(".", decimalHminstring);
    ipv4.setHostMin(joinedHostMinString);
    /************************************************
     * MAX HOST
     ************************************************/
     String hostmaxbit;
    if(prefix == 32){
      hostmaxbit=broadcast;
    }else{
    String subStringHostM = broadcast.substring(prefix);
    int newValueHostmaxbit = Integer.parseInt(subStringHostM, 2) - 1;
    String newHmxBinaryString = Integer.toBinaryString(newValueHostmaxbit);

    while (newHmxBinaryString.length() < (32 - prefix)) {
      newHmxBinaryString = "0" + newHmxBinaryString;
    }
    hostmaxbit = broadcast.substring(0, prefix) + newHmxBinaryString;
    }
    String[] binarystrinHmax = new String[4];
    int[] decimalHmax = new int[4];
    String[] decimalHmaxstring = new String[4];
    for (int i = 0, j = 0; i < 4; i++) {
      binarystrinHmax[i] = hostmaxbit.substring(j, j + 8);
      j += 8;
    }
    for (int i = 0; i < 4; i++) {
      decimalHmax[i] = Integer.valueOf(binarystrinHmax[i], 2);
    }
    for (int i = 0; i < 4; i++) {
      decimalHmaxstring[i] = Integer.toString(decimalHmax[i]);
    }
    String joinedHostMaxString = String.join(".", decimalHmaxstring);
    ipv4.setHostMax(joinedHostMaxString);

    System.out.println(c.red("+--------------------------------------------------------------------------+"));
    System.out.println(c.red("IP Address  ")+": " + c.blue(ipv4.getIPaddress()) + "\t\t\t\t" + String.join(".", binarystringIP));
    System.out.println(c.red("Subnet Mask ")+": " + c.blue(joinedPrefixString + "/" + ipv4.getPrefix()) + "\t\t\t"+ String.join(".", binarystringPrefix));
    System.out.print(c.red("Network     ")+": " + c.blue(ipv4.getNetwork()) + "\t\t\t\t" + String.join(".", binarystringNBinary)+" "+c.green(manager.theClass(binarystringNBinary[0]))+"\n");
    System.out.println(c.red("Broadcast   ")+": " + c.blue(ipv4.getBroadcast()) + "\t\t\t\t" + resultBroadcast);
    System.out.println(c.red("HostMin     ")+": " + c.blue(ipv4.getHostMin()) + "\t\t\t\t" + String.join(".", binarystrinHmin));
    System.out.println(c.red("HostMax     ")+": " + c.blue(ipv4.getHostMax()) + "\t\t\t\t" + String.join(".", binarystrinHmax));
    System.out.println(c.red("Hosts/Net   ")+": " + c.blue(ipv4.getHosts()));
  System.out.println(c.red("+--------------------------------------------------------------------------+"));
    System.out.println();
    System.out.println(c.yellow("https://github.com/ebubekiracar/ipcalculator"));
  }
}
