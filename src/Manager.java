public class Manager {

    IPv4 controller = new IPv4();
    Color c = new Color();
public int[] toBinary(int x) {
      int binary[] = new int[8];
        int[] binaryTemp = { 0, 0, 0, 0, 0, 0, 0, 0 };
      for (int index = 0; x > 0; index++){
	        if (x == 0){
	          binaryTemp[4] = 0;
	          binaryTemp[5] = 0;
	          binaryTemp[6] = 0;
	          binaryTemp[7] = 0;
	          x = -1;
	        }
	      binaryTemp[index] = x % 2;
	      x = x / 2;
      }
      int j = 7;
        for (int i = 0; i <= 7; i++) {
            binary[i] = binaryTemp[j];
            j--;
        }
      return binary;
    }

    public int prefixController(int prefix) {
        if (prefix >= 1 && prefix <= 32) {
            return 1;
        } else {
            System.out.println(c.red("+ Prefix length error -> " + prefix));
            return 0;
        }
    }

    public int ipController(int[] ip) {
        for (int i = 0; i < ip.length; i++) {
            if (ip[i] >= 0 && ip[i] <= 255) {
                continue;
            } else {
                System.out.println(c.red("+ IP length error -> " + ip[i]));
                return 0;
            }
        }
        return 1;
    }

    public String theClass(String firstOctet) {


      if (firstOctet.startsWith("0")) {
        return "(Class A)";
      } else if (firstOctet.startsWith("10")) {
        return "(Class B)";
      } else if (firstOctet.startsWith("110")) {
        return "(Class C)";
      } else if (firstOctet.startsWith("1110")) {
        return "(Class D)";
      } else if (firstOctet.startsWith("1111")) {
        return "(Class E)";
      } else {
        return "No match found";
      }
    }


  public String binaryStringiDecimalYapma (String binarystring){
  String[]binaryDecstring = new String[4];
  for (int i = 0, j = 0; i < 4; i++){
      binaryDecstring[i] = binarystring.substring (j, j + 8);
      j += 8;
    }
  int[] decimal = new int[4];
  String[]decimalstring = new String[4];
  for (int i = 0; i < 4; i++){
      decimal[i] = Integer.valueOf (binaryDecstring[i], 2);
    }
  for (int i = 0; i < 4; i++){
      decimalstring[i] = Integer.toString (decimal[i]);
    }
  String joinedDecString = String.join (".", decimalstring);
  return joinedDecString;
}

  
}
