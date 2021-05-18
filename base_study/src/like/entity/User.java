package like.entity;

/**
 * @author by chenaiquan<like.aiquan@qq.com>  create on 2021/5/10 17.23
 */
public class User {
  private String username;
  private String sex;
  private int age;

  public User() {
  }

  public User(String username, String sex, int age) {
    this.username = username;
    this.sex = sex;
    this.age = age;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "User{" +
        "username='" + username + '\'' +
        ", sex='" + sex + '\'' +
        ", age=" + age +
        '}';
  }
}
