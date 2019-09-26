import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args){
        staticFileLocation("/public");
        String connectionString = "jdbc:h2:~/wildlife_tracker.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "alice", "20001");

        //this is the home  page
        get("/",((request, response) -> {
            Map<String,Object> model=new HashMap<>();
            return new ModelAndView(model, "home.hbs");
        }), new HandlebarsTemplateEngine());

        //getting the form
        get("/animal/form",((request, response) -> {
            Map<String,Object> model=new HashMap<>();
            return new ModelAndView(model, "AnimalForm.hbs");
        }), new HandlebarsTemplateEngine());

        //Posting the form
        post("/animal/new",((request, response) -> {
            Map<String,Object> model=new HashMap<>();
            boolean danger = request.queryParamsValues("endager")!= null;
            if(danger== true){
                String name=request.queryParams("name");
                String health=request.queryParams("health");
                String age=request.queryParams("age");
                EndangeredAnimal newEndanger = new EndangeredAnimal(name,health,age,danger);
                model.put("name",name);
                model.put("health",health);
                model.put("age",age);
                model.put("danger",danger);
                model.put("endanger",newEndanger);
                System.out.println(danger);
                newEndanger.save();

            }else if(danger==false) {
                String name=request.queryParams("name");
                String health=request.queryParams("health");
                String age=request.queryParams("age");
                NormalAnimal newNormal =new NormalAnimal(name,health,age,danger);
                System.out.println(newNormal);
                model.put("name",name);
                model.put("health",health);
                model.put("age",age);
                model.put("danger",danger);
                model.put("normal",newNormal);
                newNormal.save();
                System.out.println(danger);
            }
            return new ModelAndView(model, "saveanimal.hbs");
        }), new HandlebarsTemplateEngine());



        //getting all the animals
        get("/animals",((request, response) -> {
            Map<String,Object> model=new HashMap<>();
                List<EndangeredAnimal> endangeredAnimals=EndangeredAnimal.all();
                model.put("endanger",endangeredAnimals);

                List<NormalAnimal> normal=NormalAnimal.all();
                model.put("normal",normal);

            return new ModelAndView(model, "animaldisplay.hbs");
        }), new HandlebarsTemplateEngine());


        //Sighting form
        get("/sighting/new",((request, response) -> {
            Map<String,Object> model=new HashMap<>();
            List<EndangeredAnimal>animals=EndangeredAnimal.all();
            model.put("animals",animals);
            return new ModelAndView(model, "SightForm.hbs");
        }), new HandlebarsTemplateEngine());



        //posting the animals infos
        post("/sighting/new",((request, response) -> {
            Map<String,Object> model=new HashMap<>();
            String name=request.queryParams("Rname");
            String location=request.queryParams("location");
            String animal=request.queryParams("animal2");
            Sighting newsight=new Sighting(name,location,animal);
            newsight.saveto();
            return new ModelAndView(model, "savesighting.hbs");
        }), new HandlebarsTemplateEngine());

        get("/sights",((request, response) -> {
            Map<String,Object> model=new HashMap<>();
            List<Sighting>sightsg=Sighting.all();
            model.put("sights",sightsg);

            return new ModelAndView(model, "Sightingdisplay.hbs");
        }), new HandlebarsTemplateEngine());

    }


}
