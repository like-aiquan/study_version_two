package like.ai.test;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 * test common-io some method
 *
 * @author by chenaiquan<like.aiquan@qq.com> create on 2021/5/12 21.20
 */
public class IoTest {
  public static void main(String[] args) throws IOException {

    System.out.println(System.getProperty("user.dir"));

    File file = new File("gradle_for_boot/a.txt");
    FileUtils.copyFileToDirectory(file, new File("D:\\idea\\sources\\study_version_two\\gradle_for_boot"));
  }
}
