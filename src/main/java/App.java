import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args){
        staticFileLocation("/public");
        //this is the home  page
        get("/",((request, response) -> {
            Map<String,Object> model=new HashMap<>();
            return new ModelAndView(model, "home.hbs");
        }), new HandlebarsTemplateEngine());

        //getting the form
        get("/animal/new",((request, response) -> {
            Map<String,Object> model=new HashMap<>();
            return new ModelAndView(model, "AnimalForm.hbs");
        }), new HandlebarsTemplateEngine());

        //Posting the form
        post("/animal/new",((request, response) -> {
            Map<String,Object> model=new HashMap<>();
            boolean danger = request.queryParamsValues("endager")!= null;
            if(danger){
                String name=request.queryParams("name");
                String health=request.queryParams("health");
                String age=request.queryParams("age");
                EndangeredAnimal newEndanger = new EndangeredAnimal(name,health,age);
                System.out.println(health);
            }else {
                String name=request.queryParams("name");
                String health=request.queryParams("health");
                String age=request.queryParams("age");
                NormalAnimal newNormal =new NormalAnimal(name,health,age);
                System.out.println(age);
            }
            return new ModelAndView(model, "animaldisplay.hbs");
        }), new HandlebarsTemplateEngine());


        get("/animals",((request, response) -> {
            Map<String,Object> model=new HashMap<>();
            ArrayList<EndangeredAnimal>indanger= EndangeredAnimal.Eall();
            ArrayList<NormalAnimal>normal = NormalAnimal.NAll();
            model.put("indanger",EndangeredAnimal.Eall());
            model.put("normal",NormalAnimal.NAll());
            System.out.println(EndangeredAnimal.Eall());
            return new ModelAndView(model, "animaldisplay.hbs");
        }), new HandlebarsTemplateEngine());


        get("/sighting/new",((request, response) -> {
            Map<String,Object> model=new HashMap<>();
            return new ModelAndView(model, "SightForm.hbs");
        }), new HandlebarsTemplateEngine());
    }
}
