import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FoodItem {
    private String name;
    private String type;
    private int calPer100Gr;

    public FoodItem(String name, int calPer100Gr){
        this.name = name;
        this.calPer100Gr = calPer100Gr;

        addFoodToFile();
    }

    private void addFoodToFile(){
        String filePath = "src/res/foods.txt";
        File file  = new File(filePath);

        try (FileOutputStream fos = new FileOutputStream(file, true)){

            String newLine = this.name + "|" + this.type + "|" + this.calPer100Gr + "\n";
            byte[] newLineBytes = newLine.getBytes();
            fos.write(newLineBytes);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FoodItem foodItem = (FoodItem) o;

        return name.equals(foodItem.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
