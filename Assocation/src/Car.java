public class Car{
   String carName;
   int carId;
   Car(String name, int id)
   {
	this.carName = name;
	this.carId = id;
   }
}
//what is association?
//unlike aggregation, association can be a one-to-one relationship between classes, one-to-many relationship, many-to-one or many-to-many
//for example, one-to-one means that one object can only have a relationship to another type of object. Like how one human can have one brain
//one-to-many could be car to humans, as one car can fit many humans
//association is a relationship only between 2 classes, however
//what association means is that an object will use another object's functionalities
//association>aggregation>composition. levels of restriction. association least restricted


//COMPOSITION
//while composition is considered "more restrictive", it is a two-way form of association, where both objects are dependent on each other
//for example, heart and brain are dependent on each other. if one fails, so does the other