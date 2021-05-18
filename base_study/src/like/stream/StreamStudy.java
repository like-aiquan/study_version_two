package like.stream;


import static java.util.stream.Collectors.*;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import like.entity.User;

/**
 * 流的方式
 *
 * @author by chenaiquan<like.aiquan@qq.com>  create on 2021/5/10 16.02
 */
public class StreamStudy {
  public static void main(String[] args) throws IOException {
    testNullList();
  }

  private static void grouping() {
    User tom = new User("tom", "男", 11);
    User amy = new User("amy", "女", 13);
    User ali = new User("ali", "男", 12);
    User daming = new User("daming", "男", 13);
    List<User> list = new ArrayList<>();
    list.add(tom);
    list.add(amy);
    list.add(ali);
    list.add(daming);
    // 按照性别分组  分组后set对象是user实体
    System.out.println(list.stream().collect(groupingBy(User::getSex, toSet())).toString());
    // mapping 之后仅仅把名字收集
    System.out.println(list.stream().collect(groupingBy(User::getSex, mapping(User::getUsername, toSet()))).toString());
  }

  private static void flatMap() {
    List<Stream<Integer>> list = new ArrayList<>();
    ArrayList<Integer> child1 = new ArrayList<>();
    ArrayList<Integer> child2 = new ArrayList<>();
    ArrayList<Integer> child3 = new ArrayList<>();
    ArrayList<Integer> child4 = new ArrayList<>();
    child1.add(1);
    child1.add(2);
    child1.add(3);
    child1.add(4);
    child2.add(5);
    child2.add(6);
    child2.add(7);
    child2.add(8);
    child3.add(9);
    child3.add(10);
    child3.add(11);
    child3.add(12);
    child4.add(13);
    child4.add(14);
    child4.add(15);
    child4.add(16);
    list.add(child1.stream());
    list.add(child2.stream());
    list.add(child3.stream());
    list.add(child4.stream());
    // 把其中每一个流的结果都连接起来  结果 == 流
    list.stream().flatMap(i -> i).forEach(System.out::print);
  }

  private static void toStream() throws IOException {
    Stream<Object> stream;
    // 元素转流
    stream = Stream.of(1, 12, 3, 2, 3, 2, 32);
    // 空流
    stream = Stream.empty();
    // 无限流  随机数
    Stream.generate(() -> (int) (Math.random() * 10) + 1).limit(5);
    // 迭代器  序列 去掉limit(2)无限流
    Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE)).limit(2).collect(Collectors.toList());
    BigInteger limit = new BigInteger("10000");
    // 中间的方法结束谓词
    Stream.iterate(BigInteger.ZERO, n -> n.compareTo(limit) < 0, n -> n.add(BigInteger.ONE)).collect(Collectors.toList());
    // file读取流
    Files.lines(Path.of("base_study/src/like/a.txt")).collect(Collectors.toList());
    // 从字符串获取单词流
    String content = "how are u? i am fine, and u? me too.";
    new Scanner(content).tokens().forEach(System.out::println);
  }

  private static void testNullList() {
    ArrayList<Object> objects = new ArrayList<>();
    System.out.println(objects.stream().collect(toList()));
    List<Object> list = objects.stream().map(i -> i.getClass()).collect(toList());
    System.out.println(list);
  }
}
