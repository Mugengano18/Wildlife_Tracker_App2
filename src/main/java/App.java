import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args){
        staticFileLocation("/public");
        get("/",((request, response) -> {
            Map<String,Object> model=new HashMap<>();
            return new ModelAndView(model, "home.hbs");
        }), new HandlebarsTemplateEngine());

        get("/animal/new",((request, response) -> {
            Map<String,Object> model=new HashMap<>();
            return new ModelAndView(model, "AnimalForm.hbs");
        }), new HandlebarsTemplateEngine());

        get("/sighting/new",((request, response) -> {
            Map<String,Object> model=new HashMap<>();
            return new ModelAndView(model, "SightForm.hbs");
        }), new HandlebarsTemplateEngine());
    }
}
