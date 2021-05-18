package like.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * io stream and ...
 *
 * @author by chenaiquan<like.aiquan@qq.com>  create on 2021/5/10 19.55
 */
public class IOStudy {
  private static final File file = new File("base_study/src/like/a.txt");

  public static void main(String[] args) throws IOException {
    readFileByBinary();
  }

  /**
   * 字节方式读取文件
   */
  private static void readFileByBinary() throws IOException {
    // 大文件是如何读取的  是一次加载道内存还是开辟通道 还是进行页缓存？？？
    FileInputStream input = new FileInputStream("D:\\idea\\牛客网 算法初级班第4期课程（已完结）\\暴力递归到动态规划1【瑞客论坛 www.ruike1.com】.mp4");

    // 创建缓存
    byte[] buffer = new byte[1024];
    int len;
    while ((len = input.read(buffer)) != -1) {
      System.out.print(new String(buffer, 0, len));
    }
    input.close();
  }

  /**
   * 二进制形式文件后续写
   */
  private static void appendFileByBinary() throws IOException {
    // true表示开启在文件后续写
    FileOutputStream outputStream = new FileOutputStream(file, true);
    // 字节流方式  要先获取字节信息
    outputStream.write("\n".getBytes());
    outputStream.write("ggggg".getBytes());
    outputStream.flush();
    outputStream.close();
  }

  /**
   * writer 方式文件后续写
   */
  private static void appendFileByWriter() throws IOException {
    // true表示开启在文件后续写
    FileWriter writer = new FileWriter(file, StandardCharsets.UTF_8, true);
    writer.append("\n");
    writer.append("hhhhh");
    writer.flush();
    writer.close();
  }

  /**
   * 获取工作空间目录
   */
  public static void getRelativePath() {
    // D:\idea\sources\study_version_two
    System.out.println(System.getProperty("user.dir"));
  }
}
