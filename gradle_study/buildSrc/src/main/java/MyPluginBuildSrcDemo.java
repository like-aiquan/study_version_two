import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;

/**
 * customer plugin
 *
 * @author by chenaiquan<like.aiquan@qq.com> create on 2021/5/8 20.40
 */
public class MyPluginBuildSrcDemo implements Plugin<Project> {
  @Override
  public void apply(Project project) {
    for (int i = 0; i < 10; i++) {
      project.task("MyPluginBuildSrcDemo_task" + i, task -> {
        System.out.println("configure MyPluginBuildSrcDemo is running ...");
        task.doLast(new Action<Task>() {
          @Override
          public void execute(Task task) {
            System.out.println("MyPluginBuildSrcDemo is running ...");
          }
        });
      });
    }
  }
}
