import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
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
            if(danger){
                String name=request.queryParams("name");
                String health=request.queryParams("health");
                String age=request.queryParams("age");
                EndangeredAnimal newEndanger = new EndangeredAnimal(name,health,age);
                EndangeredAnimal.save();
                System.out.println(health);
                model.put("name",name);
                model.put("health",health);
                model.put("age",age);
                model.put("endanger",newEndanger);


            }else {
                String name=request.queryParams("name");
                String health=request.queryParams("health");
                String age=request.queryParams("age");
                NormalAnimal newNormal =new NormalAnimal(name,health,age);
                System.out.println(age);
                model.put("name",name);
                model.put("health",health);
                model.put("age",age);
                model.put("normal",newNormal);
            }

            return new ModelAndView(model, "animaldisplay.hbs");
        }), new HandlebarsTemplateEngine());



        //getting all the animals
        get("/animals",((request, response) -> {
            Map<String,Object> model=new HashMap<>();
            ArrayList<EndangeredAnimal>indanger= EndangeredAnimal.Eall();
            ArrayList<NormalAnimal>normal = NormalAnimal.NAll();
            model.put("indanger",indanger);
            model.put("normal",normal);
            System.out.println(EndangeredAnimal.Eall());
            System.out.println(NormalAnimal.NAll());
            return new ModelAndView(model, "animaldisplay.hbs");
        }), new HandlebarsTemplateEngine());


        get("/sighting/new",((request, response) -> {
            Map<String,Object> model=new HashMap<>();
            return new ModelAndView(model, "SightForm.hbs");
        }), new HandlebarsTemplateEngine());

        post("/sighting/new",((request, response) -> {
            Map<String,Object> model=new HashMap<>();
            String name=request.queryParams("Rname");
            String location=request.queryParams("location");
//            int animal=Integer.parseInt(request.params("animal2"));
            Sighting newsight=new Sighting(name,location);
            model.put("time",newsight.getDate());
            model.put("name",name);
            model.put("loc",location);
//            model.put("alanimal",animal);
            System.out.println(newsight.getDate());
            System.out.println(location);
//            System.out.println(animal);
            return new ModelAndView(model, "Sightingdisplay.hbs");
        }), new HandlebarsTemplateEngine());

        post("/sights",((request, response) -> {
            Map<String,Object> model=new HashMap<>();
            ArrayList<Sighting>sights=Sighting.getSinstances();
            model.put("sights",sights);
            System.out.println(sights);
            return new ModelAndView(model, "Sightingdisplay.hbs");
        }), new HandlebarsTemplateEngine());

    }


}
