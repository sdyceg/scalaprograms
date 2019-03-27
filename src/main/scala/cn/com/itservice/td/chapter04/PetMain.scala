package cn.com.itservice.td.chapter04

object PetMain {
    def main(args: Array[String]): Unit = {
      var dog=new DogPet("sdyceg",26,"济南","helloworld");
      println(dog.say());
      println(dog);

      println();
      var cat=new CatPet("sdyceg",26,"helloworld");
      println(cat.say());
      println(cat);

  }
}
