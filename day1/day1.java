import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

class day1 {
  static final int init = 50;

  public static void main(String[] args) {
    dial();
  }

  public static void dial() {
    Path path = Paths.get("./input.txt");
    int res = 50;
    List<String> dir = new ArrayList<>();
    List<Integer> vals = new ArrayList<>();
    try {
      Files.lines(path).forEach(line -> {
        String s = line.substring(0, 1);
        String rest = line.substring(1);
        int num = Integer.parseInt(rest);
        dir.add(s);
        vals.add(num);
      });
    } catch (Exception e) {
      // TODO: handle exception
    }

    calc(dir, vals);

  }

  public static void calc(List<String> dir, List<Integer> nums) {
    String s = "";
    String latestChar = "R";
    int res = 50;
    int num = 0;
    int numDial = 0;
    for (int i = 0; i < nums.size(); i++) {
      s = dir.get(i);
      num = nums.get(i);
      if (latestChar.equals("R") && s.equals("L")) {
        res -= num;
        while (res < 0) {
          res = res + 100;
        }
      } else if (latestChar.equals("L") && s.equals("L")) {
        res -= num;
        while (res < 0) {
          res = res + 100;
        }
      } else if (latestChar.equals("L") && s.equals("R")) {
        res += num;
        while (res >= 100) {
          res = res - 100;
        }
      } else if (latestChar.equals("R") && s.equals("R")) {
        res += num;
        while (res >= 100) {
          res = res - 100;
        }

      }
      if (res == 0)
        numDial++;
      latestChar = s;

      System.out.println(i + "----" + res);
    }
    System.out.println(numDial);
  }
}
