package like.ai;



import java.io.IOException;
import like.aiquan.CommonUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * boot entrance
 *
 * @author by chenaiquan<like.aiquan@qq.com> create on 2021/5/8 22.30
 */
@SpringBootApplication
@RestController
public class MainApplication {

  public static final Logger log = LogManager.getLogger(MainApplication.class);

  public static void main(String[] args) throws IOException {
    // 在run方法之前打出日志，由于springboot的初始化还没开始所以这里要不打不出来 要不就是一个默认样式的日志
    log.info("starter ...");
    SpringApplication.run(MainApplication.class, args);
  }

  @GetMapping("/hello")
  public Boolean hello() {
    Boolean hello = CommonUtils.isEmpty("hello");
    // 正常打印
    log.info("get hello...");
    return hello;
  }
}
