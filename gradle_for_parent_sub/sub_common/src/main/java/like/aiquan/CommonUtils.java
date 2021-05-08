package like.aiquan;


import static java.util.Objects.isNull;

/**
 * Administrator Components Public Components
 *
 * @author by chenaiquan<like.aiquan@qq.com> create on 2021/5/8 23.00
 */
public class CommonUtils {
  public static Boolean isEmpty(String str) {
    return isNull(str) || str.isEmpty();
  }
}
