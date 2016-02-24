import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/pads", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      int width = Integer.parseInt(request.queryParams("width"));
      int length = Integer.parseInt(request.queryParams("length"));

      GoalPads myGoalPads = new GoalPads(width, length);

      model.put("myGoalPads", myGoalPads);
      model.put("template", "templates/padCheck.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
