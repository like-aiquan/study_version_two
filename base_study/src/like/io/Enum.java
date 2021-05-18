package like.io;

/**
 * @author by chenaiquan<like.aiquan@qq.com> create on 2021/5/12 20.37
 */
public class Enum {
  public static final Enum e1 = new Enum(1);
  public static final Enum e2 = new Enum(2);
  public static final Enum e3 = new Enum(3);

  private int i;

  private Enum(int i) {
    this.i = i;
  }

  public int getI() {
    return i;
  }
}
