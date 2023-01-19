public class Color {
 public static final String reset = "\u001B[0m";
 public static final String black = "\u001B[30m";
 public static final String red = "\u001B[31m";
 public static final String green = "\u001B[32m";
 public static final String yellow = "\u001B[33m";
 public static final String blue = "\u001B[34m";
 public static final String purple = "\u001B[35m";
 public static final String cyan = "\u001B[36m";
 public static final String white = "\u001B[37m";
 public static final String bgBlack = "\u001B[40m";
 public static final String bgRed = "\u001B[41m";
 public static final String bgGreen = "\u001B[42m";
 public static final String bgYellow = "\u001B[43m";
 public static final String bgBlue = "\u001B[44m";
 public static final String bgPurple = "\u001B[45m";
 public static final String bgCyan = "\u001B[46m";
 public static final String bgWhite = "\u001B[47m";
  public String red(String t){
    return red + t + reset;
  }
  public String green(String t){
    return green + t + reset;
  }
  public String cyan(String t){
    return cyan + t + reset;
  }
  public String blue(String t){
    return blue + t + reset;
  }
  public String yellow(String t){
    return yellow + t + reset;
  }
  public String purple(String t){
    return purple + t + reset;
  }
}