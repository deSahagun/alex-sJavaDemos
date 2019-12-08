import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World! coooooooooool");

        List<List<String>> myIngredients = new ArrayList<>();


        List<String> itemOne = new ArrayList<>();
        itemOne.add("cheese");
        itemOne.add("tomato");
        itemOne.add("lettuce");

        myIngredients.add(itemOne);


        List<String> itemTwo = new ArrayList<>();
        itemTwo.add("tortilla");
        itemTwo.add("beef");
        itemTwo.add("sourcream");

        myIngredients.add(itemTwo);


        List<String> itemThree = new ArrayList<>();
        itemThree.add("lettuce");
        itemThree.add("tomato");
        itemThree.add("cheese");


        myIngredients.add(itemThree);


        List<String> itemFour = new ArrayList<>();
        itemFour.add("lettuce");
        itemFour.add("tomato");
        itemFour.add("cheese");
        itemFour.add("salsa");

        myIngredients.add(itemFour);





        int res1 = unique(myIngredients);

        System.out.println(res1 + " Unique Value(s)!!!");


    }



    /*
    for(ArrayList<Integer> eachList : listOfList){
  for(Integer elementInList : eachList){
    System.out.print(elementInList + "\t");
  }
  System.out.println();
}


     */




    public static int unique(List<List<String>> ingredientsList)
    {

        //ISystem.out.println(ingredientsList.size()); //to return unique get size minus how many dupes

        int toReturn = ingredientsList.size();

        //why Map<List<String>, Integer> -> new HashMap<List<String>, Integer> ??
        //explanation here
        //create a list to integer hashmap

        Map<List<String>, Integer> myHashie = new HashMap<List<String>, Integer>();


        for(int i = 0; i < ingredientsList.size(); i++)
        {
            //sort the list
            Collections.sort(ingredientsList.get(i));

            //if the sorted lists exists
            if(!myHashie.containsKey(ingredientsList.get(i)))
            {
                myHashie.put(ingredientsList.get(i),1);

            }

            else{

                    Integer temp = myHashie.get(ingredientsList.get(i));
                    temp++;
                    myHashie.put(ingredientsList.get(i), temp);

            }

            //System.out.println(ingredientsList.get(i));

        }

        for(Map.Entry<List<String>, Integer> tmp : myHashie.entrySet())
        {
            if(tmp.getValue() > 1)
            {
                toReturn -= tmp.getValue();
            }

        }


        return toReturn;
    }


}
