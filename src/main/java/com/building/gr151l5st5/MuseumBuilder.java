package museum;

import eu.printingin3d.javascad.coords.Angles3d;
import eu.printingin3d.javascad.coords.Coords3d;
import java.util.ArrayList;
import java.util.List;

import eu.printingin3d.javascad.coords.Dims3d;
import eu.printingin3d.javascad.models.Abstract3dModel;
import eu.printingin3d.javascad.models.Cube;
import eu.printingin3d.javascad.models.Cylinder;
import eu.printingin3d.javascad.models.Prism;
import eu.printingin3d.javascad.tranzitions.Difference;
import eu.printingin3d.javascad.tranzitions.Union;

public class MuseumBuilder extends Union {
    
    MuseumBuilder(){
        super(getModels());
    }
    
    private static List<Abstract3dModel> getModels(){
         List<Abstract3dModel> models = new ArrayList();
         
         //фундамент
         Union Found = new Union(
                 new Cube(new Dims3d(900, 900, 200)),
                 new Cube(new Dims3d(40, 900, 200)).move(new Coords3d(470, 0, 0)),
                 new Cube(new Dims3d(40, 900, 200)).move(new Coords3d(470, 0, 0)).rotate(new Angles3d(0, 0, 90)),
                 new Cube(new Dims3d(40, 900, 200)).move(new Coords3d(470, 0, 0)).rotate(new Angles3d(0, 0, 180)),
                 new Cube(new Dims3d(40, 900, 200)).move(new Coords3d(470, 0, 0)).rotate(new Angles3d(0, 0, 270)),
                 
                 
                 //стенки на втором этаже
                 new Cube(new Dims3d(20, 900, 50)).move(new Coords3d(470, 0, 120)),
                 new Cube(new Dims3d(20, 900, 50)).move(new Coords3d(470, 0, 120)).rotate(new Angles3d(0, 0, 90)),
                 new Cube(new Dims3d(20, 900, 50)).move(new Coords3d(470, 0, 120)).rotate(new Angles3d(0, 0, 180)),
                 new Cube(new Dims3d(20, 900, 50)).move(new Coords3d(470, 0, 120)).rotate(new Angles3d(0, 0, 270)),
                 
                 new Cube(new Dims3d(50, 120, 120)).move(new Coords3d(470, -130, 120)),
                 new Cube(new Dims3d(30, 140, 120)).move(new Coords3d(470, 0, 120)),
                 new Cube(new Dims3d(50, 120, 120)).move(new Coords3d(470, 130, 120))
                 
                 
         );
         
         //скруленные углы
         Union CornerCylinders = new Union(
                 new Cylinder(250, 40).move(new Coords3d(450, -450, 25)),
                 new Cylinder(250, 40).move(new Coords3d(450, 450, 25)),
                 new Cylinder(250, 40).move(new Coords3d(-450, 450, 25)),
                 new Cylinder(250, 40).move(new Coords3d(-450, -450, 25))
         );
         
         Difference CentralCut = new Difference(
                 Found,
                 new Cube(new Dims3d(50, 150, 120)).move(new Coords3d(500, 0, 0)),
                 new Cube(new Dims3d(20, 180, 110)).move(new Coords3d(480, -310, 10)),
                 new Cube(new Dims3d(20, 180, 110)).move(new Coords3d(480, 310, 10)),
                 new Cube(new Dims3d(20, 180, 110)).move(new Coords3d(480, -310, 10)).rotate(Angles3d.zOnly(-90)),
                 new Cube(new Dims3d(20, 180, 110)).move(new Coords3d(480, 310, 10)).rotate(Angles3d.zOnly(-90)),
                 new Cube(new Dims3d(20, 180, 110)).move(new Coords3d(480, -310, 10)).rotate(Angles3d.zOnly(-270)),
                 new Cube(new Dims3d(20, 180, 110)).move(new Coords3d(480, 310, 10)).rotate(Angles3d.zOnly(-270))
         );
         
         Union FrontSteps = new Union(
                 new Cube(new Dims3d(50, 180, 5)).move(new Coords3d(300, 0, -65)),
                 new Cube(new Dims3d(70, 200, 5)).move(new Coords3d(300, 0, -70)),
                 new Cube(new Dims3d(90, 220, 5)).move(new Coords3d(300, 0, -75)),
                 new Cube(new Dims3d(110, 240, 5)).move(new Coords3d(300, 0, -80)),
                 new Cube(new Dims3d(130, 260, 5)).move(new Coords3d(300, 0, -85)),
                 new Cube(new Dims3d(150, 280, 5)).move(new Coords3d(300, 0, -90)),
                 new Cube(new Dims3d(170, 300, 5)).move(new Coords3d(300, 0, -95))
         );
         
         Union FrontEnter = new Union(
                 new Cube(new Dims3d(80, 120, 200)).move(new Coords3d(320, -135, 0)),
                 new Cube(new Dims3d(80, 120, 200)).move(new Coords3d(320, 135, 0)),
                 new Cube(new Dims3d(40, 160, 40)).move(new Coords3d(310, 0, 80))
         );
         
         Difference AroundEnterCutter = new Difference(
                 FrontEnter,
                 new Cube(new Dims3d(10, 70, 110)).move(new Coords3d(357, -135, 10)),
                 new Cube(new Dims3d(10, 70, 110)).move(new Coords3d(357, 135, 10))
         );
         
         Difference FrontEnterCutter = new Difference(
                 new Cube(new Dims3d(90, 140, 80)).move(new Coords3d(330, -135, 140)),
                 new Cube(new Dims3d(90, 75, 110)).rotate(new Angles3d(-65, 0, 0)).move(new Coords3d(330, -190, 160)),
                 new Cube(new Dims3d(90, 75, 110)).rotate(new Angles3d(65, 0, 0)).move(new Coords3d(330, -80, 160)),

                 new Cube(new Dims3d(90, 75, 190)).rotate(new Angles3d(-65, 0, 0)).move(new Coords3d(330, -190, 190)),
                 new Cube(new Dims3d(90, 75, 190)).rotate(new Angles3d(65, 0, 0)).move(new Coords3d(330, -80, 190)),
                 
                 new Cube(new Dims3d(90, 20, 10)).move(new Coords3d(330, -135, 176))
         );
         
         Union CenterColumns = new Union(
                 new Cube(new Dims3d(25, 25, 25)).move(new Coords3d(310, -30, -60)),
                 new Cube(new Dims3d(25, 25, 25)).move(new Coords3d(310, 30, -60)),
                 
                 new Cylinder(110, 8, 6).move(new Coords3d(310, -30, 5)),
                 
                 new Cylinder(110, 8, 6).move(new Coords3d(310, 30, 5)),
                 
                 new Cube(new Dims3d(15, 15, 140)).move(new Coords3d(310, -70, 0)),
                 
                 new Cube(new Dims3d(15, 15, 140)).move(new Coords3d(310, 70, 0)),
                 
                 new Cube(new Dims3d(80, 130, 10)).move(new Coords3d(325, 0, 105)),
                 
                 new Cube(new Dims3d(15, 15, 110)).move(new Coords3d(355, 100, 10)),
                 
                 new Cube(new Dims3d(15, 15, 110)).move(new Coords3d(355, 170, 10)),
                 
                 new Cube(new Dims3d(15, 15, 110)).move(new Coords3d(355, -170, 10)),
                 
                 new Cube(new Dims3d(15, 15, 110)).move(new Coords3d(355, -100, 10))      
         );
         
         Union FirstRoof = new Union(
                 new Prism(100, 600, 300, 4).rotate(Angles3d.zOnly(45)).move(Coords3d.zOnly(150)),
                 new Cube(new Dims3d(420, 420, 60)).move(new Coords3d(0, 0, 200)),
                 new Prism(60, 315, 80, 4).rotate(Angles3d.zOnly(45)).move(Coords3d.zOnly(260))
         );
         
         Union WallsColumns = new Union(
                 new Cylinder(120, 10, 10).move(new Coords3d(480, -350, 5)),
                 new Cylinder(120, 10, 10).move(new Coords3d(480, -280, 5)),
                 new Cylinder(120, 10, 10).move(new Coords3d(480, 350, 5)),
                 new Cylinder(120, 10, 10).move(new Coords3d(480, 280, 5)),
                 
                 new Cylinder(120, 10, 10).move(new Coords3d(480, -350, 5)).rotate(Angles3d.zOnly(-90)),
                 new Cylinder(120, 10, 10).move(new Coords3d(480, -280, 5)).rotate(Angles3d.zOnly(-90)),
                 
                 new Cylinder(120, 10, 10).move(new Coords3d(480, 350, 5)).rotate(Angles3d.zOnly(-90)),
                 new Cylinder(120, 10, 10).move(new Coords3d(480, 280, 5)).rotate(Angles3d.zOnly(-90)),
                 
                 new Cylinder(120, 10, 10).move(new Coords3d(480, -350, 5)).rotate(Angles3d.zOnly(-270)),
                 new Cylinder(120, 10, 10).move(new Coords3d(480, -280, 5)).rotate(Angles3d.zOnly(-270)),
                 
                 new Cylinder(120, 10, 10).move(new Coords3d(480, 350, 5)).rotate(Angles3d.zOnly(-270)),
                 new Cylinder(120, 10, 10).move(new Coords3d(480, 280, 5)).rotate(Angles3d.zOnly(-270))
         );
         
         
         models.add(CornerCylinders);
         
         models.add(CentralCut);
         
         models.add(FrontSteps.move(new Coords3d(200, 0, -2.5)));
         
         models.add(AroundEnterCutter.move(Coords3d.xOnly(200)));
         
         models.add(FrontEnterCutter.move(Coords3d.xOnly(200)));
         
         models.add(FrontEnterCutter.move(new Coords3d(200, 270, 0)));
         
         models.add(CenterColumns.move(Coords3d.xOnly(200)));
         
         models.add(FirstRoof);
         
         models.add(WallsColumns);
         
         return models;
    }
}