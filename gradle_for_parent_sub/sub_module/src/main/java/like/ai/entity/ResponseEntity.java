package like.ai.entity;

import java.util.List;
import java.util.Map;

/**
 * @author by chenaiquan<like.aiquan@qq.com> create on 2021/5/10 12.58
 */
public class ResponseEntity {
  private String flag;
  private String msg;
  private List<Map<String, Object>> result;

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public List<Map<String, Object>> getResult() {
    return result;
  }

  public void setResult(List<Map<String, Object>> result) {
    this.result = result;
  }

  @Override
  public String toString() {
    return "ResponseEntity{" +
        "flag='" + flag + '\'' +
        ", msg='" + msg + '\'' +
        ", result=" + result +
        '}';
  }
}
