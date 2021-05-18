package like.io;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author by chenaiquan<like.aiquan@qq.com> create on 2021/5/12 21.02
 */
public class PathStudy {
  public static void main(String[] args) {
    getRelativePath();
  }


  public static void getRelativePath() {
    String baseDir = System.getProperty("user.dir");
    Path basePath = Paths.get(baseDir);
    Path resolve = basePath.resolve("work");
    System.out.println(resolve);
  }
}
