package like.io;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * handle file and directory to do something
 *
 * @author by chenaiquan<like.aiquan@qq.com> create on 2021/5/17 19.29
 */
public class FileAndDirectory {
  public static void main(String[] args) {
    deleteDirectory();
  }

  /**
   * delete empty directory
   */
  private static void deleteDirectory() {
    try {
      // if this directory is empty, this directory will be deleted.
      Files.deleteIfExists(Path.of(createDirectoryPath));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * delete file
   */
  private static void deleteFile() {
    // if not present, exception
    try {
      Files.delete(Path.of(directoryPath + fileName_a));
    } catch (IOException e) {
      e.printStackTrace();
    }

    // delete only if the file exists
    try {
      Files.deleteIfExists(Path.of(directoryPath + fileName_a));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * get the file stream for this file and copy other files
   */
  private static void copyFileByInputStream() {
    try {
      FileInputStream inputStream = new FileInputStream(directoryPath + fileName_a);
      Files.copy(inputStream, Path.of(filePath + fileName_c));
      inputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * copy file to outPutStream
   */
  private static void copyToOutputStream() {
    try {
      FileOutputStream outputStream = new FileOutputStream(directoryPath + fileName_a);
      outputStream.write("\n".getBytes(StandardCharsets.UTF_8));
      Files.copy(Path.of(filePath + fileName_b), outputStream);
      // take outputStream to do something
      outputStream.flush();
      outputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  /**
   * copy file to directory and if this file name existing replace this file
   */
  private static void copyFileToDirectoryReplace() {
    // let the folder store the file
    try {
      Path sources = Path.of(filePath + fileName_a);
      Path target = Path.of(directoryPath + fileName_a);
      Files.copy(sources, target);
    } catch (IOException e) {
      e.printStackTrace();
    }

    // second time, copy a file with the same name into this folder, and replace first file
    try {
      Path sources = Path.of(filePath + fileName_b);
      Path target = Path.of(directoryPath + fileName_a);
      // REPLACE_EXISTING --> static import
      Files.copy(sources, target, REPLACE_EXISTING);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * copy file to directory, make target file name == sources file name.
   */
  private static void copyFileToDirectory() {
    try {
      Path sources = Path.of(filePath + fileName_a);
      Path target = Path.of(directoryPath + fileName_a);
      Files.copy(sources, target);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * create empty file
   */
  private static void createEmptyFile() {
    try {
      Files.createFile(Path.of(createDirectoryPath + fileName_a));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * any that is present in the path and does not exist will be created
   */
  private static void createDirectories() {
    try {
      Path path = Path.of(createDirectories);
      Files.createDirectories(path);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * create the last directory on the path
   */
  private static void createDirectory() {
    try {
      Path path = Path.of(createDirectoryPath);
      Files.createDirectory(path);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  private static final String directoryPath;
  private static final String filePath;
  private static final String fileName_a;
  private static final String fileName_b;
  private static final String createDirectoryPath;
  private static final String createDirectories;
  private static final String fileName_c;

  static {
    createDirectories = "D://test/test/test/test/";
    createDirectoryPath = "base_study/src/like/test_create/";
    directoryPath = "base_study/src/like/io/";
    filePath = "base_study/src/like/";
    fileName_a = "a.txt";
    fileName_b = "b.txt";
    fileName_c = "c.txt";
  }
}
